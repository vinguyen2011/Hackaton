package com.ing.hackaton.control;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.BankAccountDaoImpl;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.model.BankAccount;
import com.ing.hackaton.model.Result;
import com.ing.hackaton.model.User;

@RestController
public class BankAccountController {
	DBConnector connector = new DBConnector();
	BankAccountDaoImpl impl = new BankAccountDaoImpl();
	UserDaoImpl userImpl = new UserDaoImpl();

	@RequestMapping("/addBankAccount")
	public Result addBankAccount(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "account_number") String account_number,
			@RequestParam(value = "bank_holder") String bank_holder,
			@RequestParam(value = "bank_name") String bank_name) {
		connector.connect();

		boolean r = false;
		try {
			User user = userImpl.getUser(connector.getConn(), username);
			
			BankAccount account = new BankAccount(account_number, 
					bank_holder, bank_name, user.getId());
			r = impl.createAccount(connector.getConn(), account);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
	}
}
