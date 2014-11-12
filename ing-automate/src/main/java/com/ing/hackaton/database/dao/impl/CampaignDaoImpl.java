package com.ing.hackaton.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ing.hackaton.model.Campaign;

public class CampaignDaoImpl {
	
	public boolean createCampaign(Connection conn, Campaign campaign) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("insert into campaign (name, description, target_amount, current_amount,"
						+ " currency, id_receiving_account, creator_username, image_url, type) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		boolean success = false;
		try {
			stmt.setString(1, campaign.getName());
			stmt.setString(2, campaign.getDescription());
			stmt.setDouble(3, campaign.getTarget_amount());
			stmt.setDouble(4, 0);
			stmt.setString(5, campaign.getCurrency());
			stmt.setString(6, campaign.getId_receiving_account());
			stmt.setString(7, campaign.getCreator_username());
			stmt.setString(8, campaign.getImage_url());
			stmt.setString(9, campaign.getType());
			
			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}
	
	public Campaign getCampaign(Connection conn, int id_campaign)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from campaign where idcampaign = ?");
		Campaign campaign = null;
		try {
			stmt.setInt(1, id_campaign);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				campaign = new Campaign(rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("target_amount"),
						rs.getDouble("current_amount"),
						rs.getString("currency"),
						rs.getString("id_receiving_account"),
						rs.getString("creator_username"),
						rs.getString("image_url"),
						rs.getString("type"));
				campaign.setId(rs.getInt("idcampaign"));
			}
			rs.close();
		} finally {
			stmt.close();
		}
		return campaign;
	}
	
	public List<Campaign> getAllCampaignOfUser(Connection conn, String creator_username)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from campaign where creator_username = ?");
		List<Campaign> campaigns = new ArrayList<Campaign>();
		
		Campaign campaign = null;
		try {
			stmt.setString(1, creator_username);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				campaign = new Campaign(rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("target_amount"),
						rs.getDouble("current_amount"),
						rs.getString("currency"),
						rs.getString("id_receiving_account"),
						rs.getString("creator_username"),
						rs.getString("image_url"),
						rs.getString("type"));
				campaign.setId(rs.getInt("idcampaign"));
				campaigns.add(campaign);
			}
			rs.close();
		} finally {
			stmt.close();
		}
		
		System.out.println(campaigns.size());
		return campaigns;
	}
	public List<Campaign> getAllCampaigns(Connection conn)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("select * from campaign");
		List<Campaign> campaigns = new ArrayList<Campaign>();
		
		Campaign campaign = null;
		try {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				campaign = new Campaign(rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("target_amount"),
						rs.getDouble("current_amount"),
						rs.getString("currency"),
						rs.getString("id_receiving_account"),
						rs.getString("creator_username"),
						rs.getString("image_url"),
						rs.getString("type"));
				campaign.setId(rs.getInt("idcampaign"));
				campaigns.add(campaign);
			}
			rs.close();
		} finally {
			stmt.close();
		}
		
		return campaigns;
	}
	
	public boolean updateCampaign(Connection conn, Campaign campaign) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement("update campaign set name = ?,"
						+ " description = ?, target_amount = ?, current_amount = ?,"
						+ " currency = ?, id_receiving_account = ?, creator_username = ?,"
						+ " image_url = ?, type = ?)"
						+ " where idcampaign = ?");
		boolean success = false;
		try {
			stmt.setString(1, campaign.getName());
			stmt.setString(2, campaign.getDescription());
			stmt.setDouble(3, campaign.getTarget_amount());
			stmt.setDouble(4, 0);
			stmt.setString(5, campaign.getCurrency());
			stmt.setString(6, campaign.getId_receiving_account());
			stmt.setString(7, campaign.getCreator_username());
			stmt.setString(8, campaign.getImage_url());
			stmt.setString(9, campaign.getType());
			stmt.setInt(10, campaign.getId());
			
			stmt.executeUpdate();
			success = true;

		} finally {
			stmt.close();
		}
		return success;
	}
}
