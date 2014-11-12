package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ing.hackaton.model.Campaign;

public class CampaignDaoImpl {
	
	public boolean createCampaign(Connection conn, Campaign campaign) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into campaign (name, description, target_amount, current_amount,"
						+ " currency, id_receiving_account, id_creator_user) "
						+ "values (?, ?, ?, ?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setString(1, campaign.getName());
			stmt.setString(2, campaign.getDescription());
			stmt.setDouble(3, campaign.getTarget_amount());
			stmt.setDouble(4, 0);
			stmt.setString(5, campaign.getCurrency());
			stmt.setString(6, campaign.getId_receiving_account());
			stmt.setInt(7, campaign.getId_creator_user());

			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}
}
