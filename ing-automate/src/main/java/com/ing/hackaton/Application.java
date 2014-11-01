package com.ing.hackaton;

/**
 * Hello world!
 *
 */

import oauth.signpost.exception.OAuthMessageSignerException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ing.hackaton.datagather.OauthAuthentication;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws OAuthMessageSignerException {
			OauthAuthentication oath = OauthAuthentication.getInstance();
	        SpringApplication.run(Application.class, args);
    }
}
