package com.ing.hackaton.common;

import java.security.NoSuchAlgorithmException;

import javax.crypto.*;

public class KeyGen {

	public String getKey() {
		KeyGenerator keyGen = null;
		SecretKey secretKey = null;
		try {
			keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(256); // for example
			secretKey = keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secretKey.getEncoded().toString();
	}
}
