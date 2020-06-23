package fr.denoria.api.bungee.core;

import fr.denoria.api.bungee.commons.Account;
import fr.denoria.api.bungee.exception.AccountNotFoundException;
import fr.denoria.api.bungee.redis.RedisAccess;
import fr.denoria.api.bungee.sql.DatabaseManager;
import fr.denoria.api.bungee.sql.RankList;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AccountProvider {

    public static final String REDIS_KEY = "account:";
    public static final Account DEFAULT_ACCOUNT = new Account(0, UUID.randomUUID(), "Aucune", 0, 0, 1, RankList.JOUEUR, "None");

    private RedisAccess redisAccess;
    private ProxiedPlayer player;
    private Player p2;

    public AccountProvider(ProxiedPlayer player){
        this.player = player;
        this.redisAccess = RedisAccess.INSTANCE;
    }
    public AccountProvider(Player player){
        this.p2 = player;
    }


    public Account getAccount() throws AccountNotFoundException {

        Account account = getAccountFromRedis();

        if(account == null){
            account = getAccountFromDatabase();

            sendAccountToRedis(account);
        }
        return account;
    }

    public void sendAccountToDatabase(Account account) throws AccountNotFoundException{

        if(account == null) {
            getAccount();
        }

        final RedissonClient redisson = redisAccess.getRedissonClient();
        final String key = REDIS_KEY + this.player.getUniqueId().toString();
        final RBucket<Account> accountRBucket = redisson.getBucket(key);


        try {
            final UUID uuid = player.getUniqueId();
            final Connection connection = DatabaseManager.DENORIA_SERVER.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `info_players` SET guildname=?,denocoins=?,denogemmes=?,level=?,grade=?,supperm=? WHERE uuid=?");
            preparedStatement.setString(7, uuid.toString().replace("-", ""));
            assert account != null;
            preparedStatement.setString(1, account.getGuild());
            preparedStatement.setFloat(2, account.getDenocoins());
            preparedStatement.setFloat(3, account.getDenogemmes());
            preparedStatement.setInt(4, account.getLevel());
            preparedStatement.setString(5, account.getRank().getName());
            preparedStatement.setString(6, account.getSupperm());
            ResultSet rs = preparedStatement.executeQuery();
            if(!rs.next()){
                System.err.println("L'envoi des données redis vers BDD n'ont pas fonctionné !");
            }


        } catch(SQLException ex){
            ex.printStackTrace();
        }




    }

    public void sendAccountToRedis(Account account){
        final RedissonClient redisson = redisAccess.getRedissonClient();
        final String key = REDIS_KEY + this.player.getUniqueId().toString();
        final RBucket<Account> accountRBucket = redisson.getBucket(key);

        accountRBucket.set(account);
    }

    public Account getAccountFromRedis(){
        final RedissonClient redissonClient = redisAccess.getRedissonClient();
        final String key = REDIS_KEY + this.player.getUniqueId().toString();
        final RBucket<Account> accountRBucket = redissonClient.getBucket(key);

        return accountRBucket.get();
    }

    public Account getAccountFromDatabase() throws AccountNotFoundException{
        Account account = null;
        try{
            final UUID uuid = player.getUniqueId();
            final Connection connection = DatabaseManager.DENORIA_SERVER.getDatabaseAccess().getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM info_players WHERE uuid = ?");

            preparedStatement.setString(1, uuid.toString().replace("-", ""));
            preparedStatement.executeQuery();

            final ResultSet resultSet = preparedStatement.getResultSet();

            if(resultSet.next()){
                final int id = resultSet.getInt("id");
                final String guild = resultSet.getString("guildname");
                final RankList rank = RankList.getByName(resultSet.getString("grade"));
                final String supperm = resultSet.getString("supperm");
                final float denocoins = resultSet.getFloat("denocoins");
                final float denogemmes = resultSet.getFloat("denogemmes");
                final byte level = resultSet.getByte("level");
                account = new Account(id, uuid, guild, denocoins, denogemmes, level, rank, supperm);


            } else {
                account = createNewAccount(uuid);
            }
            connection.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return account;
    }

    private Account createNewAccount(UUID uuid) throws SQLException{
        final Account account = DEFAULT_ACCOUNT.clone();
        final Connection connection = DatabaseManager.DENORIA_SERVER.getDatabaseAccess().getConnection();
        final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO info_players (uuid, guildname, denocoins, denogemmes, level, grade, supperm) VALUES (?,?,?,?,?,?,?)");

        preparedStatement.setString(1, uuid.toString().replace("-", ""));
        preparedStatement.setString(2, "Aucune");
        preparedStatement.setFloat(3, 0.0f);
        preparedStatement.setFloat(4, 0.0f);
        preparedStatement.setShort(5, (short)1);
        preparedStatement.setString(6, "Joueur");
        preparedStatement.setString(7, "None");

        final int row = preparedStatement.executeUpdate();
        final ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(row > 0 && resultSet.next()){
            final int id = resultSet.getInt(1);

            account.setId(id);
            account.setUuid(uuid);

            // Création fait !

        }
        connection.close();
        return account;


    }

    public String getUUID(Player player) {
        if(getAccountFromRedis() == null){
            return "Compte inconnu";
        }
        return getAccountFromRedis().getUuid().toString();
    }

    public Float getDenoCoins() {
        if(getAccountFromRedis() == null){
            return 0.0F;
        }
        return getAccountFromRedis().getDenocoins();
    }

    public Float getDenoGemmes() {
        if(getAccountFromRedis() == null){
            return 0.0F;
        }
        return getAccountFromRedis().getDenogemmes();
    }

    public String getGuild() {
        if(getAccountFromRedis() == null){
            return "Aucune";
        }
        return getAccountFromRedis().getGuild();
    }

    public RankList getRank() {
        RankList rank = null;
        if(getAccountFromRedis() == null){
            return RankList.JOUEUR;
        }
        return getAccountFromRedis().getRank();
    }

    public int getLevel(){
        if(getAccountFromRedis() == null){
            return 0;
        }
        return getAccountFromRedis().getLevel();

    }




    public RedisAccess getRedisAccess() {
        return redisAccess;
    }

    public ProxiedPlayer getPlayer() {
        return player;
    }

    public Player getP2() {
        return p2;
    }
}
