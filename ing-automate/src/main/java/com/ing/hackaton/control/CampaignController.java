package com.ing.hackaton.control;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.CampaignDaoImpl;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.datagather.DataGathering;
import com.ing.hackaton.model.Campaign;
import com.ing.hackaton.model.Result;

@RestController
public class CampaignController {
	DBConnector connector = new DBConnector();
	CampaignDaoImpl impl = new CampaignDaoImpl();
	UserDaoImpl userImpl = new UserDaoImpl();
	DataGathering dataCollector = new DataGathering();
	
	@RequestMapping("/addCampaign")
	public Result addUser(
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
}
