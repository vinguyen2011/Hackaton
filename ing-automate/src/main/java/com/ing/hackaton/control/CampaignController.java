package com.ing.hackaton.control;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.CampaignDaoImpl;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.datagather.DataGathering;
import com.ing.hackaton.model.Campaign;
import com.ing.hackaton.model.ListCampaign;
import com.ing.hackaton.model.Result;
import com.ing.hackaton.model.User;

@RestController
public class CampaignController {
	DBConnector connector = new DBConnector();
	CampaignDaoImpl impl = new CampaignDaoImpl();
	UserDaoImpl userImpl = new UserDaoImpl();
	DataGathering dataCollector = new DataGathering();
	
	@RequestMapping("/addCampaign")
	public Result addCampaign(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "target_amount") double target_amount,
			@RequestParam(value = "currency") String currency,
			@RequestParam(value = "id_receiving_account") String id_receiving_account,
			@RequestParam(value = "creator_username") String creator_username,
			@RequestParam(value = "image_url") String image_url,
			@RequestParam(value = "type") String type) {

		connector.connect();
		
		boolean r = false;
		try {
			Campaign campaign = new Campaign(name, description, target_amount, 0, 
					currency, id_receiving_account, creator_username, image_url, type);

			r = impl.createCampaign(connector.getConn(), campaign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
	}
	
	@RequestMapping("/updateCampaign")
	public Result updateCampaign(
			@RequestParam(value = "id_campaign") int id_campaign,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "target_amount") double target_amount,
			@RequestParam(value = "currency") String currency,
			@RequestParam(value = "id_receiving_account") String id_receiving_account,
			@RequestParam(value = "image_url") String image_url,
			@RequestParam(value = "type") String type) {

		connector.connect();
		
		boolean r = false;
		try {
			Campaign old = impl.getCampaign(connector.getConn(), id_campaign);
			Campaign campaign = new Campaign(name, description, target_amount, 0, 
					currency, id_receiving_account, old.getCreator_username(), image_url, type);

			r = impl.updateCampaign(connector.getConn(), campaign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
	}
	
	@RequestMapping("/getCampaign")
	public Campaign getCampaign(
			@RequestParam(value = "id_campaign") int id_campaign) {

		connector.connect();
		
		Campaign campaign = null;
		try {
			campaign = impl.getCampaign(connector.getConn(), id_campaign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();

		return campaign;
	}
	
	@RequestMapping("/user/getCampaigns")
	public List<Campaign> getAllCampaignOfUser(
			@RequestParam(value = "username") String username) {

		connector.connect();
		
		List<Campaign> campaigns = null;
		
		try {
			campaigns = impl.getAllCampaignOfUser(connector.getConn(), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connector.disconnect();

		return campaigns;
	}
	
	@RequestMapping("/getCampaigns")
	public List<Campaign> getAllCampaigns() {

		connector.connect();
		
		List<Campaign> campaigns = null;
		
		try {
			campaigns = impl.getAllCampaigns(connector.getConn());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connector.disconnect();

		return campaigns;
	}
}
