package org.travelandtourism.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.travelandtourism.constants.CONSTANTS;

public class DBConnectivity {
	private static DBConnectivity instance = null;
	private Connection connection = null;
	
	private DBConnectivity() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONSTANTS.DB_URL, CONSTANTS.USERNAME, CONSTANTS.PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized DBConnectivity getInstance() {
		if (instance == null) {
			instance = new DBConnectivity();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
