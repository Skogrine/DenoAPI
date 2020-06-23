package fr.denoria.api;



import fr.denoria.api.bungee.commands.RedisCommand;
import fr.denoria.api.bungee.listener.ProxyJoinListener;
import fr.denoria.api.bungee.redis.RedisAccess;
import fr.denoria.api.bungee.sql.DatabaseManager;
import net.md_5.bungee.api.plugin.Plugin;


public class DenoAPI extends Plugin{

    public static final boolean ENABLED = false;
    public static DenoAPI INSTANCE;

	
	@Override
	public void onEnable() {
		INSTANCE = this;
		
		DatabaseManager.initAllDatabaseConnection();
		RedisAccess.init();
		
		getProxy().getPluginManager().registerListener(this, new ProxyJoinListener());

		this.getProxy().registerChannel("Denoria");
		//this.getProxy().getPluginManager().registerCommand(this, new RedisCommand("redis"));

		//getProxy().getPluginManager().registerCommand(this, new ServerManagerCommand());

	}
	
	@Override
	public void onDisable() {
		DatabaseManager.closeAllDatabaseConnection();
		RedisAccess.close();
	}

	public static DenoAPI getInstance(){
		return INSTANCE;
	}


}
