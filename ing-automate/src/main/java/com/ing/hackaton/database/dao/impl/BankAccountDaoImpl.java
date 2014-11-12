package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountDaoImpl {
	
	public boolean isValid(Connection conn, String username, String password)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from user where username = ? and password = ?");
		boolean success = false;
		try {
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			rs.last();
			if (rs.getRow() == 1) {
				success = true;
			}
		} finally {
			stmt.close();
		}
		return success;
	}
}
