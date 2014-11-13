package com.ing.hackaton.control;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.common.KeyGen;
import com.ing.hackaton.database.DBConnector;
import com.ing.hackaton.database.dao.impl.UserDaoImpl;
import com.ing.hackaton.model.KeyResult;
import com.ing.hackaton.model.Result;
import com.ing.hackaton.model.User;

@RestController
public class UserController {
	DBConnector connector = new DBConnector();
	UserDaoImpl impl = new UserDaoImpl();
	
	@RequestMapping("/addUser")
	public KeyResult addUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "image", required = false) String image,
			@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname) {

		User user = new User(username, password, email, image, firstname, lastname);
		connector.connect();
		
		String secretKey = new KeyGen().getKey();
		user.setKey(secretKey);

		boolean r = false;
		try {
			r = impl.createUser(connector.getConn(), user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();
		KeyResult result = new KeyResult(r);
		if (r) {
			result.setKey(secretKey);
		}
		return result;
	}
	
	@RequestMapping("/validateUser")
	public KeyResult validateUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {

		connector.connect();

		String secretKey = null;
	
		boolean r = false;
		try {
			r = impl.isValid(connector.getConn(), username, password);
			if (r) {
				User user = impl.getUser(connector.getConn(), username);
				secretKey = user.getKey();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connector.disconnect();
		KeyResult result = new KeyResult(r);
		result.setKey(secretKey);

		return result;
	}
	
	@RequestMapping("/getUser")
	public User validateUser(
			@RequestParam(value = "username") String username) {

		connector.connect();

		User user = null;
		try {
			user = impl.getUser(connector.getConn(), username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connector.disconnect();

		return user;
	}
	
	@RequestMapping("/addAccessToken")
	public Result addAccessToken(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "access_token") String access_token) {

		connector.connect();
		
		boolean r = false;
		try {
			r = impl.updateToken(connector.getConn(), username, access_token);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
	}
	
	@RequestMapping("/updateUser")
	public Result updateUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "image") String image,
			@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname){
		
		connector.connect();
		
		boolean r = false;
		try {
			User old = impl.getUser(connector.getConn(), username);
			User user = new User(old.getUsername(), password, email, image, 
					firstname, lastname);

			r = impl.updateUser(connector.getConn(), user);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connector.disconnect();
		Result result = new Result(r);

		return result;
		
	}
}
