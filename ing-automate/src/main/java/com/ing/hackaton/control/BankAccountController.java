package com.ing.hackaton.control;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.BankAccountDaoImpl;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.datagather.DataGathering;
import com.ing.hackaton.model.CurrentBankAccount;
import com.ing.hackaton.model.User;

@RestController
public class BankAccountController {
	DBConnector connector = new DBConnector();
	BankAccountDaoImpl impl = new BankAccountDaoImpl();
	UserDaoImpl userImpl = new UserDaoImpl();
	DataGathering dataCollector = new DataGathering();
	
	@RequestMapping("/listAllCurrentBankAccount")
	public CurrentBankAccount listAllBankAccount(
			@RequestParam(value = "username") String username) {
		CurrentBankAccount account = new CurrentBankAccount();

		connector.connect();

		try {
			User user = userImpl.getUser(connector.getConn(), username);
			
			String userId = dataCollector.getUserId(user.getAccess_token());
			String accounts = dataCollector.getWithToken(user.getAccess_token(), "persons/" + userId + "/accounts");
			
			account.parse(accounts);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();

		return account;
	}
	
}
