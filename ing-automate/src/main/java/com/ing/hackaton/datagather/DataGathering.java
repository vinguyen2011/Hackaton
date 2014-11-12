package com.ing.hackaton.datagather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataGathering {
	private static String API_KEY = "gotNqHyungYD4Xh0cGGirQ8XVQOK7VAS";
	private static String BASE_URL = "http://ingcommonapi-test.apigee.net/commonapi/v0/nl/";

	public String getWithToken(String token, String callUrl) throws Exception {

		String url = BASE_URL + callUrl + "?apikey=" + API_KEY;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("Authorization", "Bearer " + token);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

		String strReturn = response.toString();
		return strReturn;
	}

	public String getUserId(String token) throws Exception {

		String url = BASE_URL + "me" + "?apikey=" + API_KEY;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("Authorization", "Bearer " + token);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
		
		// get a String from the JSON object
		String userId = (String) jsonObject.get("userId");

		// print result
		System.out.println(userId);

		return userId;
	}

}
