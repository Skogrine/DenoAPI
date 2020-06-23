package fr.denoria.api.bungee.sql;

import java.util.Arrays;


public enum RankList {
	OWNER(1, 100, "§0", "Owner", "§4Owner §8❘§4", "", "§4", true),
	ADMIN(2, 99, "§a", "Admin","§cAdmin §8❘§c", "", "§c", true),
	DEV(3, 98, "§b", "Developpeur", "§cDeveloppeur §8❘§c", "", "§c", true),
	RESP(3, 60, "§c", "Responsable","§6Responsable §8❘§6", "", "§6", true),
	MOD(4, 50, "§d", "Mod","§9Modérateur §8❘§9", "", "§9", true),
	HELPER(5, 40, "§e", "Helper","§3Helper §8❘§3", "", "§3", true),
	STAFF(6, 30, "§f", "Staff","§dStaff §8❘§d", "", "§d", true),
	AMI(7, 6, "§g", "Ami","§dAmi §8❘§d", "", "§d", false),
	YT(8, 7, "§h", "Youtubeur","§cYoutuber §8❘§c", "", "§c", false),
	PERSO(10, 5, "§i", "Custom", "§dCustom §8❘§d", "", "§d", false),
	LEGEND(11, 4, "§j", "Legend","§3Legend §8❘§3", "", "§3", false),
	HYPE(12, 3, "§k", "Hype","§bHype §8❘§b", "", "§b", false),
	VIPP(13, 2, "§l", "Vip+","§eVIP+ §8❘§e", "", "§e", false),
	VIP(14, 1, "§m", "Vip","§aVIP §8❘§a", "", "§a", false),
	JOUEUR(15, 0, "§n", "Joueur","§7", "", "§7", false);

	String priority, name, prefix, suffix, color;
	int id, power;
	boolean staff;

	private RankList(int id, int power, String priority, String name, String prefix, String suffix, String color, boolean staff) {
		this.id = id;
		this.power = power;
		this.priority = priority;
		this.name = name;
		this.prefix = prefix;
		this.suffix = suffix;
		this.color = color;
		this.staff = staff;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPriority() {
		return priority;
	}

	public boolean isStaff() {
		return staff;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getId() {
		return id;
	}
	
	public static RankList getbyPower(int power) {
		return Arrays.stream(values()).filter(r -> r.getPower() == power).findAny().orElse(RankList.JOUEUR);
	}
	
	public static RankList getByID(int id){
        return Arrays.stream(values()).filter(r -> r.getId() == id).findAny().orElse(RankList.JOUEUR);
    }

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public static RankList getByName(String name){
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RankList.JOUEUR);
    }
	
}

