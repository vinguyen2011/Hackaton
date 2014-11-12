package com.ing.hackaton.control;

import java.sql.SQLException;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.CampaignDaoImpl;
import com.ing.hackaton.database.dao.impl.ContributionDaoImpl;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.datagather.DataGathering;
import com.ing.hackaton.model.Campaign;
import com.ing.hackaton.model.Contribution;
import com.ing.hackaton.model.CurrentBankAccount;
import com.ing.hackaton.model.Result;
import com.ing.hackaton.model.TransferRequest;
import com.ing.hackaton.model.User;

@RestController
public class ContributionController {
	DBConnector connector = new DBConnector();
	CampaignDaoImpl campaignImpl = new CampaignDaoImpl();
	UserDaoImpl userImpl = new UserDaoImpl();
	ContributionDaoImpl impl = new ContributionDaoImpl();

	DataGathering dataCollector = new DataGathering();
	
	CurrentBankAccount account = new CurrentBankAccount();
	
	@RequestMapping("/addContribution")
	public Result addContribution(
			@RequestParam(value = "source_username") String source_username,
			@RequestParam(value = "amount") double amount,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "currency") String currency,
			@RequestParam(value = "id_campaign") int id_campaign) {

		connector.connect();

		boolean r = false;
		
		try {
			
			User source_user = userImpl.getUser(connector.getConn(), source_username);
			String source_userId = dataCollector.getUserId(source_user.getAccess_token());
			String source_user_accounts = dataCollector.getWithToken(source_user.getAccess_token(), "persons/" + source_userId + "/accounts");
			
			account.parse(source_user_accounts);
			
			Campaign campaign = campaignImpl.getCampaign(connector.getConn(), id_campaign);
			User target_user = userImpl.getUser(connector.getConn(), campaign.getCreator_username());
			
			TransferRequest transfer = new TransferRequest();
			
			String objStr = transfer.newTransfer(account.getId(),
					campaign.getId_receiving_account(),
					target_user.getFirstname() + "," + target_user.getLastname(),
					amount, campaign.getName(), description);
			
			String step1 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers", objStr);
			String step2 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/next", step1);
			String step3 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/next", step2);
			String step4 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/sign?PIN=12345", step3);
			dataCollector.postTransaction(source_user.getAccess_token(), "transfers/execute", step4);

			Calendar cal = Calendar.getInstance();
			
			Contribution contribution = new Contribution(amount, currency, cal.getTime(),
					campaign.getName(), id_campaign, account.getId(), description);

			r = impl.createContribution(connector.getConn(), contribution);
			
			if(r) {
				//update campaign current amount
				double new_amount = campaign.getCurrent_amount() + amount;
				campaignImpl.updateCampaignCurrentAmount(connector.getConn(),id_campaign,new_amount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
	}
}