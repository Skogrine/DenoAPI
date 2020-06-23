package fr.denoria.api.bungee.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Collection;
import java.util.UUID;

public class TeamUtils {
	
	private String prefix;
	private String suffix;
	private Team team;
	public static Scoreboard scoreboard;
	
	public TeamUtils(String name, String prefix, String suffix, Scoreboard current) throws Exception{
		this.prefix = prefix;
		this.suffix = suffix;
		this.team = current.getTeam(name);
		scoreboard = current;
		if(this.team == null) {
			this.team = current.registerNewTeam(name);
		}
		scoreboard = current;
		this.team.setCanSeeFriendlyInvisibles(false);
		this.team.setAllowFriendlyFire(false);
		int prefixLength = 0;
		int suffixLength = 0;
		if(prefix != null) {
			prefixLength = prefix.length();
		}
		if(suffix != null) {
			prefixLength = suffix.length();
		}
		if(prefixLength + suffixLength >= 32) {
			throw new Exception("prefix and suffix lengths are greater than 16");
		}
		if(suffix != null) {
			this.team.setSuffix(ChatColor.translateAlternateColorCodes('&', suffix));
		}
		if(prefix != null) {
			this.team.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
		}
	}
	
	public TeamUtils(String name, String prefix, String suffix) throws Exception{
		this(name,prefix, suffix, Bukkit.getScoreboardManager().getMainScoreboard());
	}
	
	@SuppressWarnings("deprecation")
	public void set(Player player) {
		this.team.addPlayer(player);
		player.setScoreboard(scoreboard);
	}
	@SuppressWarnings("deprecation")
	public void remove(Player player) {
		this.team.removePlayer(player);
	}
	
	public void resetTag(UUID uuid) {
		remove(Bukkit.getPlayer(uuid));
	}
	
	public void setAll(Collection<Player> players) {
		for(Player player : players) {
			set(player);
		}
	}
	
	public void setAll(Player[] players) {
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = players).length;
		for(int i = 0; i < j; i++) {
			Player player = arrayOfPlayer[i];
			set(player);
		}
	}
	
	public void setPrefix(String prefix) {
		this.prefix = ChatColor.translateAlternateColorCodes('&', prefix);
		this.team.setPrefix(prefix);
	}
	
	public void setSuffix(String suffix) {
		this.suffix = ChatColor.translateAlternateColorCodes('&', suffix);
		this.team.setSuffix(suffix);
	}
	
	public String getPrefix() {
		return this.prefix;
	}
	
	public String getSuffix() {
		return this.suffix;
	}
	
	public Team getTeam() {
		return this.team;
	}
	
	public void removeTeam() {
		this.team.unregister();
	}
	
	public Scoreboard getScoreboard() {
		return scoreboard;
	}
	
	public static void setNameTag(Player player, String name, String prefix, String suffix) {
		try {
			TeamUtils tagPlayer = new TeamUtils(name,prefix,suffix);
			tagPlayer.set(player);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
