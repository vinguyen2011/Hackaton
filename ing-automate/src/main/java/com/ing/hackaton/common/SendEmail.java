package com.ing.hackaton.common;

//File Name SendEmail.java

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	public void send(List<String> emails, String name) {
		// Recipient's email ID needs to be mentioned.
	      //String to = "masoom.tulsiani@gmail.com";//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = "pooling.robot@gmail.com";//change accordingly
	      final String username = "pooling.robot";//change accordingly
	      final String password = "12345Peru";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

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
	         message.setSubject("Your Campaign: "+name+" has been funded!");

	         // Now set the actual message
	         message.setText("Hello, we are sending you this message to inform you "
	            + "that your campaign has been funded!!! ");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	}
}
