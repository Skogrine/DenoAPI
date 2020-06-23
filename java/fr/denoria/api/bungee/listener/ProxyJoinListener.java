package fr.denoria.api.bungee.listener;


import fr.denoria.api.bungee.commons.Account;
import fr.denoria.api.DenoAPI;
import fr.denoria.api.bungee.redis.RedisAccess;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;


public class ProxyJoinListener implements Listener {





    @EventHandler
    public void onPlayerJoinProxy(PostLoginEvent e){
        BungeeCord.getInstance().getScheduler().runAsync(DenoAPI.INSTANCE, () -> {
            final ProxiedPlayer player = e.getPlayer();
            //TabManager.setPlayerList(player, "§6§lDENORIA\n§fplay.denoria.fr\n\n§7Ping : §e" + player.getPing() + " §8❘ §7TPS : §a20.0 §8| §7Serveur : §6Hub #1\n", "\n§7Besoin d'§6aide§7 ? Demandez à un §2Helper§7 !\n§7Site web : §cdenoria.fr §8| §7TS : §3ts.denoria.fr");

            final RedisAccess redisAccess = RedisAccess.INSTANCE;
            final RedissonClient redissonClient = redisAccess.getRedissonClient();
            final RBucket<Account> rBucket = redissonClient.getBucket("account:"+ player.getUniqueId().toString());
            final Account account = rBucket.get();




            if(DenoAPI.ENABLED && account.getRank().getPower() >= 30) {
                player.disconnect(new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + "DENORIA" +
                        "\n" + ChatColor.GRAY + "  Denoria est en maintenance." +
                        "\n" + ChatColor.GRAY + " Repassez plus tard." +
                        "\n\n" + ChatColor.GRAY + "Vous voulez nous contacter?" +
                        "\n" + ChatColor.GRAY + "Discord " + ChatColor.DARK_GRAY + "» " + ChatColor.DARK_AQUA + "https://discord.gg/a2WkNs6"));
            }



            for(int i = 0; i < 15; i++) {
                player.sendMessage(new TextComponent(" "));
            }
            player.sendMessage(new TextComponent("  §f§lBienvenue à vous sur §6§lDENORIA (Bêta) §f§l!"));
            player.sendMessage(new TextComponent("   §6§l» §bUtilisez la §a§lboussole §bpour accéder aux jeux"));
            player.sendMessage(new TextComponent(" "));
            player.sendMessage(new TextComponent("  §f[§a§l?§f] Reportez les bugs à cette adresse:"));
            player.sendMessage(new TextComponent("   §6§l» §a§lfeedback.denoria.fr"));
            player.sendMessage(new TextComponent(" "));


        });
    }

}
