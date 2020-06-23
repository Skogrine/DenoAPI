package fr.denoria.api.gameapi;

public enum Game {

    UHC(1, "UHC", "UHC1", "Skogrin"),
    UHCRUN(2, "UHCRun", "UHC2", "Skogrin"),
    LGUHC(3, "LGUHC", "UHC3", "Skogrin"),
    SHOOTCRAFT(4, "ShootCraft", "SC1", "Skogrin & Bleu40"),
    PEARLWARS(5, "PearlWars", "PW", "Skogrin"),
    BEDWARS(6, "BedWars", "BW", "Skogrin"),
    FREEBUILD(7, "FreeBuild", "FB", "Skogrin"),
    IAGS(8, "Hide and go seek", "IAGS", "Skogrin"),
    HUNTER(9, "Hunter", "Hunter", "Skogrin & Kintoshi");

    int ID;
    String name, nameid, developpers;

    Game(int ID, String name, String nameid, String developpers){
        this.ID = ID;
        this.name = name;
        this.nameid = nameid;
        this.developpers = developpers;
    }

    public int getID() {
        return ID;
    }

    public String getDeveloppers() {
        return developpers;
    }

    public String getName() {
        return name;
    }

    public String getNameid() {
        return nameid;
    }

}
