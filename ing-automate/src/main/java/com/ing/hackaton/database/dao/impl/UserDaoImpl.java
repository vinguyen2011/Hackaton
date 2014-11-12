package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ing.hackaton.model.User;

import java.sql.PreparedStatement;

public class UserDaoImpl {
	public boolean createUser(Connection conn, User user) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into user (USERNAME, PASSWORD, EMAIL, IMAGE, FIRSTNAME, LASTNAME) "
						+ "values (?, ?, ?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getImage());
			stmt.setString(5, user.getFirstname());
			stmt.setString(6, user.getLastname());

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
			rs.close();
		} finally {
			stmt.close();
		}
		return success;
	}

	public User getUser(Connection conn, String username)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from user where username = ?");
		User user = null;
		try {
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getString("firstname"),
						rs.getString("lastname"));
				user.setId(rs.getInt("iduser"));
				user.setAccess_token(rs.getString("access_token"));
			}
			rs.close();
		} finally {
			stmt.close();
		}
		return user;
	}
	
	public boolean updateToken(Connection conn, String username, String access_token) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("UPDATE user set access_token = ? where username = ?");
		boolean success = false;
		try {
			stmt.setString(1, access_token);
			stmt.setString(2, username);

			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}
	
	public boolean updateUser(Connection conn, User user) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("update user set"
						+ " password = ?, email = ?, image = ?,"
						+ " firstname = ?, lastname = ?"
						+ " where username = ?");
		boolean success = false;
		try {
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getImage());
			stmt.setString(4, user.getFirstname());
			stmt.setString(5, user.getLastname());
			stmt.setString(6, user.getUsername());
			
			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}

}
