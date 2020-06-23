package fr.denoria.api.bungee.commons;

import fr.denoria.api.bungee.sql.RankList;

import java.util.UUID;

public class Account implements Cloneable{

    private int id;
    private UUID uuid;
    private String guild;
    private float denocoins;
    private float denogemmes;
    private int level;
    private RankList rank;
    private String supperm;

    public Account(){}

    public Account(int id, UUID uuid, String guild, float denocoins, float denogemmes, int level, RankList rank, String supperm) {
        this.id = id;
        this.uuid = uuid;
        this.guild = guild;
        this.denocoins = denocoins;
        this.denogemmes = denogemmes;
        this.level = level;
        this.rank = rank;
        this.supperm = supperm;
    }

    public UUID getUuid() {
        return uuid;
    }

    public RankList getRank() {
        return rank;
    }

    public int getLevel() {
        return level;
    }

    public float getDenocoins() {
        return denocoins;
    }

    public float getDenogemmes() {
        return denogemmes;
    }

    public int getId() {
        return id;
    }

    public String getGuild() {
        return guild;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSupperm() {
        return supperm;
    }

    public void setSupperm(String supperm) {
        this.supperm = supperm;
    }

    public void setRank(RankList rank) {
        this.rank = rank;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDenocoins(float denocoins) {
        this.denocoins = denocoins;
    }

    public void setDenogemmes(float denogemmes) {
        this.denogemmes = denogemmes;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof  Account)) {
            return false;
        } else {
            return ((Account)o).getId() == this.id;
        }

    }

    @Override
    public Account clone() {
        try{
            return (Account)super.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
