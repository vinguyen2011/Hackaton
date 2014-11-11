package com.ing.hackaton.database;

import java.sql.*;

public class DBConnector {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "Jedi";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "2011matden";

	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void connect() {
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
