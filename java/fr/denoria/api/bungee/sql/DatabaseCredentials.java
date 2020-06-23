package fr.denoria.api.bungee.sql;

public class DatabaseCredentials {
    private final String host;
    private final String user;
    private final String pass;
    private final String dbName;
    private final int port;


    public DatabaseCredentials(String host, String user, String pass, String dbName, int port) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        this.port = port;
    }
    public String toURI(){
        return "jdbc:mysql://" +
                host +
                ":" +
                port +
                "/" +
                dbName;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }

    public String getHost() {
        return host;
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }
}
