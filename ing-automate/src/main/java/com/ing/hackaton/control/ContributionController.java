package com.ing.hackaton.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.common.SendEmail;
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
	
	@SuppressWarnings("unchecked")
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
					campaign.getName(), id_campaign, account.getId(), description, source_username);

			r = impl.createContribution(connector.getConn(), contribution);
			
			if(r) {
				//update campaign current amount
				double new_amount = campaign.getCurrent_amount() + amount;
				campaignImpl.updateCampaignCurrentAmount(connector.getConn(),id_campaign,new_amount);
				if(new_amount >= campaign.getTarget_amount()) {
					List<User> contributors = impl.getAllContributiorsOfCampaign(connector.getConn(), id_campaign);
					List<String> emails = new ArrayList<String>();
					
					for (User c: contributors) {
						emails.add(c.getEmail());
					}
					HashSet<String> hs = new HashSet<String>();
					hs.addAll(emails);
					emails.clear();
					emails.addAll(hs);
					
					new SendEmail().send(emails, campaign.getName());
				}
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
	
	@RequestMapping("/getContribution")
	public Contribution getContribution(
			@RequestParam(value = "id_contribution") int id_contribution) {

		connector.connect();
		
		Contribution contribution = null;
		try {
			contribution = impl.getContribution(connector.getConn(), id_contribution);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();

		return contribution;
	}
	
	@RequestMapping("/campaign/getContributions")
	public List<Contribution> getAllContributionOfCampaign(
			@RequestParam(value = "id_campaign") int id_campaign) {

		connector.connect();
		
		List<Contribution> contributions = null;
		
		try {
			contributions = impl.getAllContributionsOfCampaign(connector.getConn(), id_campaign);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		connector.disconnect();

		return contributions;
	}
	
	@RequestMapping("/unwindContribution")
	public Result unwindContribution(
			@RequestParam(value = "idcontribution") int idcontribution) {

		connector.connect();

		boolean r = false;
		
		try {
			Contribution old = null;
			old = impl.getContribution(connector.getConn(), idcontribution);
			Campaign campaign = campaignImpl.getCampaign(connector.getConn(), old.getId_campaign());
			
			User source_user = userImpl.getUser(connector.getConn(), campaign.getCreator_username());
			String source_userId = dataCollector.getUserId(source_user.getAccess_token());
			String source_user_accounts = dataCollector.getWithToken(source_user.getAccess_token(), "persons/" + source_userId + "/accounts");
			
			account.parse(source_user_accounts);
			
			User target_user = userImpl.getUser(connector.getConn(), old.getUsername_contributor());
			
			TransferRequest transfer = new TransferRequest();
			
			String objStr = transfer.newTransfer(campaign.getId_receiving_account(),
					old.getId_contributing_account(),
					target_user.getFirstname() + "," + target_user.getLastname(),
					old.getAmount(), campaign.getName(), "Refund of campaign " + old.getId_campaign());
			
			String step1 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers", objStr);
			String step2 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/next", step1);
			String step3 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/next", step2);
			String step4 = dataCollector.postTransaction(source_user.getAccess_token(), "transfers/sign?PIN=12345", step3);
			dataCollector.postTransaction(source_user.getAccess_token(), "transfers/execute", step4);

			Calendar cal = Calendar.getInstance();
			
			Contribution contribution = new Contribution(old.getAmount()*-1, old.getCurrency(), cal.getTime(),
					campaign.getName(), old.getId_campaign(), account.getId(), "PURGE contribution #" + old.getId(), campaign.getCreator_username());

			r = impl.createContribution(connector.getConn(), contribution);
			
			if(r) {
				//update campaign current amount
				double new_amount = campaign.getCurrent_amount() - old.getAmount();
				campaignImpl.updateCampaignCurrentAmount(connector.getConn(),campaign.getId(),new_amount);
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
