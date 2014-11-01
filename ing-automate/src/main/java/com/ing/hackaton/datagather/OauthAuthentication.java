package com.ing.hackaton.datagather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class OauthAuthentication {
	private OAuthConsumer consumer;
	
	private static volatile OauthAuthentication instance = new OauthAuthentication();
	
	private OauthAuthentication()
	{
		try {
			authenticate();
		} catch (OAuthMessageSignerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthNotAuthorizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public OAuthConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(OAuthConsumer consumer) {
		this.consumer = consumer;
	}

	public static OauthAuthentication getInstance()
	{
		if (instance == null) {
            instance = new OauthAuthentication();
        }
        return instance;
	}
	public void authenticate() throws OAuthMessageSignerException,
			OAuthNotAuthorizedException, OAuthExpectationFailedException,
			OAuthCommunicationException, IOException {
		consumer = new DefaultOAuthConsumer(
				"n3ba3uqwln3qt21qng0gmtrhhetqi3dqhc5kfsfs",
				"0ecwuszyzqig0t5jgsq4ijt1qv4qxpq1k5bi53lr");

		OAuthProvider provider = new DefaultOAuthProvider(
				"https://api.openbankproject.com/oauth/initiate",
				"https://api.openbankproject.com/oauth/token",
				"https://api.openbankproject.com/oauth/authorize");

		System.out.println("Fetching request token...");

		String authUrl = provider.retrieveRequestToken(consumer,
				OAuth.OUT_OF_BAND);

		System.out.println("Request token: " + consumer.getToken());
		System.out.println("Token secret: " + consumer.getTokenSecret());

		System.out.println("Now visit:\n" + authUrl
				+ "\n... and grant this app authorization");
		System.out
				.println("Enter the verification code and hit ENTER when you're done:");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String verificationCode = br.readLine();

		System.out.println("Fetching access token...");

		provider.retrieveAccessToken(consumer, verificationCode.trim());

		System.out.println("Access token: " + consumer.getToken());
		System.out.println("Token secret: " + consumer.getTokenSecret());

	}
}
