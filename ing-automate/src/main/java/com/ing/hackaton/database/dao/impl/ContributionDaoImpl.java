package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ing.hackaton.model.Contribution;
import com.ing.hackaton.model.User;

public class ContributionDaoImpl {
	
	public boolean createContribution(Connection conn, Contribution contribution) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into contribution (amount, currency, date, comment,"
						+ " id_campaign, id_contributing_account, description, username_contributor) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setDouble(1, contribution.getAmount());
			stmt.setString(2, contribution.getCurrency());
			stmt.setDate(3, convertJavaDateToSqlDate(contribution.getDate()));
			stmt.setString(4, contribution.getComment());
			stmt.setInt(5, contribution.getId_campaign());
			stmt.setString(6, contribution.getId_contributing_account());
			stmt.setString(7, contribution.getDescription());
			stmt.setString(8, contribution.getUsername_contributor());

			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}
	
	public Contribution getContribution(Connection conn, int id_contribution)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from contribution where idcontribution = ?");
		Contribution contribution = null;
		try {
			stmt.setInt(1, id_contribution);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contribution = new Contribution(rs.getDouble("amount"),
						rs.getString("currency"),
						convertSqlDateToJavaDate(rs.getDate("date")),
						rs.getString("comment"),
						rs.getInt("id_campaign"),
						rs.getString("id_contributing_account"),
						rs.getString("description"),
						rs.getString("username_contributor"));
				contribution.setId(rs.getInt("idcontribution"));
			}
			rs.close();
		} finally {
			stmt.close();
		}
		return contribution;
	}
	
	public List<Contribution> getAllContributionsOfCampaign(Connection conn, int id_campaign)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from contribution where id_campaign = ?");
		List<Contribution> contributions = new ArrayList<Contribution>();
		
		Contribution contribution = null;
		try {
			stmt.setInt(1, id_campaign);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contribution = new Contribution(rs.getDouble("amount"),
						rs.getString("currency"),
						convertSqlDateToJavaDate(rs.getDate("date")),
						rs.getString("comment"),
						rs.getInt("id_campaign"),
						rs.getString("id_contributing_account"),
						rs.getString("description"),
						rs.getString("username_contributor"));
				contribution.setId(rs.getInt("idcontribution"));
				contributions.add(contribution);
			}
			rs.close();
		} finally {
			stmt.close();
		}
		
		return contributions;
	}
	
	public List<User> getAllContributiorsOfCampaign(Connection conn, int id_campaign)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from user JOIN contribution "+
					"ON user.username=contribution.username_contributor where id_campaign = ?");
		
		List<User> users = new ArrayList<User>();
		User user = null;
		try {
			stmt.setInt(1, id_campaign);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getString("firstname"),
						rs.getString("lastname"));
				user.setId(rs.getInt("iduser"));
				users.add(user);
			}
			rs.close();
		} finally {
			stmt.close();
		}
		
		return users;
	}
	
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	public java.util.Date convertSqlDateToJavaDate(java.sql.Date date) {
	    return new java.util.Date(date.getTime());
	}
	
}
