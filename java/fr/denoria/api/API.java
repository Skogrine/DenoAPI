package fr.denoria.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.denoria.api.gameapi.players.DenoriaPlayer;
import fr.denoria.api.gameapi.utils.ServerProperties;
import fr.denoria.api.gameapi.utils.i18n.I18n;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public abstract class API extends JavaPlugin
{

    public static final boolean TEST_MODE;

    static {
        String testMode = System.getProperty("denoria.testmode");

        if(testMode == null) {
            testMode = ServerProperties.getProperties().getProperty("denoria.testmode", "false");
        }
        boolean isTestMode = false;
        try {
            isTestMode = Boolean.parseBoolean(testMode);
        } catch(Exception e){
            isTestMode = false;
        } finally {
            TEST_MODE = isTestMode;
        }
    }

    protected static API API;
    protected static I18n i18n;
    protected static String gameName;
    protected static String internalGameName;
    protected static Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).serializeSpecialFloatingPointValues().serializeNulls().disableHtmlEscaping()
            .create();
    protected static Gson prettyGson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT)
            .disableHtmlEscaping().setPrettyPrinting().create();
    protected static boolean isJoinable = true;
    private boolean finished;


    public static I18n i18n(){
        return getI18n();
    }

    public static void log(String message) {
        Bukkit.getLogger().log(Level.INFO, message);
    }

    public static void logColor(String message) {
        Bukkit.getConsoleSender().sendMessage(i18n().replaceColors(message));
    }

    public static void logError(String message) {
        Bukkit.getLogger().log(Level.SEVERE, message);
    }

    public static void logWarning(String message) {
        Bukkit.getLogger().log(Level.WARNING, message);
    }
    /*public static String getPrettyServerName(){
        String[] splitted = getServerName().split("_");

        String type = StringUtils.getUpperFirstLetter(splitted[0].toLowerCase());

        if(splitted.length == 1){
            return type;
        } else {
            return type + " nÄ�Å¼Ë�" + splitted[1];
        }
    }*/
    public static String getServerName(){
        return Bukkit.getServer().getServerName();
    }

    public abstract List<DenoriaPlayer> getOnlinePlayers();

    public abstract List<DenoriaPlayer> getRealOnlinePlayers();

    public abstract void balanceTeams(boolean sameSize);

    /**
     * Active l'anti-spawnkill
     */
    public abstract void enableAntiSpawnKill();


    public static I18n getI18n() {
        return null;
    }

    public static fr.denoria.api.API getAPI() {
        return API;
    }

    public static String getGameName() {
        return gameName;
    }

    public static void setGameName(String gameName) {
        fr.denoria.api.API.gameName = gameName;
    }

    public static String getInternalGameName() {
        return internalGameName;
    }

    public static void setInternalGameName(String internalGameName) {
        fr.denoria.api.API.internalGameName = internalGameName;
    }

    public static Gson getGson() {
        return gson;
    }

    public static Gson getPrettyGson() {
        return prettyGson;
    }

    public static boolean isIsJoinable() {
        return isJoinable;
    }

    public static void setIsJoinable(boolean isJoinable) {
        fr.denoria.api.API.isJoinable = isJoinable;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }


}
