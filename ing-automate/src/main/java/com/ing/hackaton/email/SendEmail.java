package com.ing.hackaton.email;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	public void send(List<String> emails) {
		//String to = "abcd@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "thanhvi.ng@gmail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			for(String email : emails) {
				message.addRecipient(Message.RecipientType.BCC, new InternetAddress(
					email));
			}
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					from));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			//Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
