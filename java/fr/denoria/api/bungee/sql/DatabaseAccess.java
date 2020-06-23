package fr.denoria.api.bungee.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseAccess {

	private final DatabaseCredentials credentials;
	private HikariDataSource hikariDataSource;
	
	public DatabaseAccess(DatabaseCredentials credentials) {
		this.credentials = credentials;
	}
	
	private void setupHiaCP(){
		final HikariConfig hikariConfig = new HikariConfig();

		hikariConfig.setMaximumPoolSize(20);
		hikariConfig.setAutoCommit(true);
		hikariConfig.setJdbcUrl(credentials.toURI());
		hikariConfig.setUsername(credentials.getUser());
		hikariConfig.setPassword(credentials.getPass());

		this.hikariDataSource = new HikariDataSource(hikariConfig);
	}

	public void initPool(){
		setupHiaCP();
	}

	public void closePool(){
		this.hikariDataSource.close();
	}

	public Connection getConnection() throws SQLException {
		if(this.hikariDataSource == null){
			System.out.println("Not Connected");
			setupHiaCP();
		}

		return this.hikariDataSource.getConnection();
	}
	
}
