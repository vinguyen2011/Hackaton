package com.ing.hackaton.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicLong;

import oauth.signpost.OAuthConsumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackaton.datagather.OauthAuthentication;
import com.ing.hackaton.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s from %s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name,
			@RequestParam(value = "group", defaultValue = "student") String group,
			@RequestParam(value = "age", defaultValue = "12") int age,
			@RequestParam(value = "account_id", defaultValue = "tesobe") String account_id,
			@RequestParam(value = "signed", defaultValue = "false") boolean signed) {

		// Test GET request
		try {

			OAuthConsumer consumer = OauthAuthentication.getInstance()
					.getConsumer();
			System.out.println(consumer.getConsumerKey());
			System.out.println(consumer.getConsumerSecret());
			System.out.println(consumer.getToken());
			System.out.println(consumer.getTokenSecret());

			URL url = new URL(
					"https://api.openbankproject.com/obp/v1.2.1/banks/"+name+"/accounts/private");
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();
			if(signed)
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Test POST request
		try {

			OAuthConsumer consumer = OauthAuthentication.getInstance()
					.getConsumer();
			System.out.println(consumer.getConsumerKey());
			System.out.println(consumer.getConsumerSecret());
			System.out.println(consumer.getToken());
			System.out.println(consumer.getTokenSecret());
			
			URL url = new URL(
					"https://api.openbankproject.com/obp/v1.2.1/banks/" + name
							+ "/accounts/tesobe/views");
			System.out.println("https://api.openbankproject.com/obp/v1.2.1/banks/" + name
							+ "/accounts/"+account_id+"/public/transactions/e8bf6902-8b45-444f-824a-d47e26ea81e3"
									+ "/metadata/narrative");
			HttpURLConnection request = (HttpURLConnection) url
					.openConnection();

			consumer.sign(request);
			
			request.setRequestMethod("POST");
			request.setDoOutput(true);
			request.setDoInput(true);
			request.setUseCaches(false);
			request.setAllowUserInteraction(false);
			request.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			// Create the form content
			OutputStream out = request.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			String[] paramName = new String[]{
					"narrative"};
			
			String[] paramVal = new String[]{"text explaining the purpose of the transaction"};
			
			for (int i = 0; i < paramName.length; i++) {
				writer.write(paramName[i]);
				writer.write("=");
				writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
				writer.write("&");
			}
			writer.close();
			out.close();

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

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Return Json String to the client
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name, group), age);
	}
}