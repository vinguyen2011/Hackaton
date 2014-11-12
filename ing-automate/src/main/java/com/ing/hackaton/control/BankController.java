package com.ing.hackaton.control;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
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
