package fr.denoria.api.bungee.sql;



public enum DatabaseManager {

	DENORIA_SERVER(new DatabaseCredentials("localhost", "root", "--", "denoriav1", 3306));
	//DENORIA_DEV(new DatabaseCredentials("localhost", "root", "((", "denoriadev", 3306)),
	//DENORIA_CUSTOM(new DatabaseCredentials("localhost", "root", "((", "denoriacustom", 3306));

	private final DatabaseAccess databaseAccess;

	DatabaseManager(DatabaseCredentials credentials) {
		this.databaseAccess = new DatabaseAccess(credentials);
	}

	public static void closeAllDatabaseConnection() {
		for(DatabaseManager databaseManager : values()){
			databaseManager.databaseAccess.closePool();
		}
	}

	public static void initAllDatabaseConnection() {
		for(DatabaseManager databaseManager : values()){
			databaseManager.databaseAccess.initPool();
		}
	}

	public DatabaseAccess getDatabaseAccess() {
		return databaseAccess;
	}
















}


