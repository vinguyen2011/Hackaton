package com.ing.hackaton.control;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.datagather.DataGathering;
import com.ing.hackaton.model.Account;
import com.ing.hackaton.model.Bank;

@RestController
public class BankController {
	private DataGathering dataCollector;

	@RequestMapping("/banks")
	public Bank bank(
			@RequestParam(value = "name", defaultValue = "null") String name) {

		dataCollector = new DataGathering();

		// Business ...
		Bank bank = new Bank();
		try {
			bank.parse(dataCollector
					.get("https://api.openbankproject.com/obp/v1.2.1/banks/"
							+ name));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Return Json String to the client
		return bank;
	}

	@RequestMapping("/banks/accounts/public")
	public Account bankPublicAccount(
			@RequestParam(value = "name", defaultValue = "null") String name,
			@RequestParam(value = "signed", defaultValue = "false") boolean signed) {

		dataCollector = new DataGathering();

		// Business ...
		Account lastAccount = new Account();
		try {
			lastAccount.parse(dataCollector.get("https://api.openbankproject.com/obp/v1.2.1/banks/" + name
							+ "/accounts/public"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Return Json String to the client
		return lastAccount;
	}

	@RequestMapping("/banks/accounts/private")
	public Account bankPrivateAccount(
			@RequestParam(value = "name", defaultValue = "null") String name,
			@RequestParam(value = "signed", defaultValue = "false") boolean signed) {

		dataCollector = new DataGathering();

		// Business ...
		Account lastAccount = new Account();
		try {
			lastAccount.parse(dataCollector.get("https://api.openbankproject.com/obp/v1.2.1/banks/" + name
							+ "/accounts/private"));
		} catch (ParseException e) {
			e.printStackTrace();
		}


		// Return Json String to the client
		return lastAccount;
	}
}

/*
 * // Test POST request try {
 * 
 * OAuthConsumer consumer = OauthAuthentication.getInstance() .getConsumer();
 * 
 * URL url = new URL( "https://api.openbankproject.com/obp/v1.2.1/banks/" + name
 * + "/accounts/tesobe/views");
 * System.out.println("https://api.openbankproject.com/obp/v1.2.1/banks/" + name
 * + "/accounts/"+account_id+
 * "/public/transactions/e8bf6902-8b45-444f-824a-d47e26ea81e3" +
 * "/metadata/narrative"); HttpURLConnection request = (HttpURLConnection) url
 * .openConnection();
 * 
 * consumer.sign(request);
 * 
 * request.setRequestMethod("POST"); request.setDoOutput(true);
 * request.setDoInput(true); request.setUseCaches(false);
 * request.setAllowUserInteraction(false);
 * request.setRequestProperty("Content-Type",
 * "application/x-www-form-urlencoded");
 * 
 * // Create the form content OutputStream out = request.getOutputStream();
 * Writer writer = new OutputStreamWriter(out, "UTF-8"); String[] paramName =
 * new String[]{ "narrative"};
 * 
 * String[] paramVal = new
 * String[]{"text explaining the purpose of the transaction"};
 * 
 * for (int i = 0; i < paramName.length; i++) { writer.write(paramName[i]);
 * writer.write("="); writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
 * writer.write("&"); } writer.close(); out.close();
 * 
 * if (request.getResponseCode() != 200) { throw new
 * IOException(request.getResponseMessage()); }
 * 
 * // Buffer the result into a string BufferedReader rd = new BufferedReader(new
 * InputStreamReader( request.getInputStream())); StringBuilder sb = new
 * StringBuilder(); String line; while ((line = rd.readLine()) != null) {
 * sb.append(line); } rd.close();
 * 
 * request.disconnect(); System.out.println(sb.toString());
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 */
