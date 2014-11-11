package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ing.hackaton.model.BankAccount;

public class BankAccountDaoImpl {
	public boolean createAccount(Connection conn, BankAccount account) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into bank_account (ACCOUNT_NUMBER, BANK_HOLDER, BANK_NAME, ID_OWNER_USER) "
						+ "values (?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setString(1, account.getAccount_number());
			stmt.setString(2, account.getBank_holder_name());
			stmt.setString(3, account.getBank_name());
			stmt.setInt(4, account.getId_owner());

			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}

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
