package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ing.hackaton.model.Contribution;

public class ContributionDaoImpl {
	
	public boolean createContribution(Connection conn, Contribution contribution) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into contribution (amount, currency, date, comment,"
						+ " id_campaign, id_contributing_account, description) "
						+ "values (?, ?, ?, ?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setDouble(1, contribution.getAmount());
			stmt.setString(2, contribution.getCurrency());
			stmt.setDate(3, convertJavaDateToSqlDate(contribution.getDate()));
			stmt.setString(4, contribution.getComment());
			stmt.setInt(5, contribution.getId_campaign());
			stmt.setString(6, contribution.getId_contributing_account());
			stmt.setString(7, contribution.getDescription());

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
				.prepareStatement("select * from contribution where id_contribution = ?");
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
						rs.getString("description"));
				contribution.setId(rs.getInt("idcontribution"));
			}
			rs.close();
		} finally {
			stmt.close();
		}
		return contribution;
	}
	
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	public java.util.Date convertSqlDateToJavaDate(java.sql.Date date) {
	    return new java.util.Date(date.getTime());
	}
}
