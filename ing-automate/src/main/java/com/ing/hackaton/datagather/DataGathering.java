package com.ing.hackaton.datagather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import oauth.signpost.OAuthConsumer;

public class DataGathering {
	public String get(String str) {
		String strReturn = "";
		try {
			OAuthConsumer consumer = OauthAuthentication.getInstance().getConsumer();

			URL url = new URL(str);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			
			consumer.sign(request);
			request.connect();

			if (request.getResponseCode() != 200) {
				throw new IOException(request.getResponseMessage());
			}

			// Buffer the result into a string
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					request.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();

			request.disconnect();
			System.out.println(sb.toString());
			strReturn = sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strReturn;
	}
}
