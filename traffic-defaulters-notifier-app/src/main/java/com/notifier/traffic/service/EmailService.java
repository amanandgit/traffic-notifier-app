package com.notifier.traffic.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.notifier.traffic.vo.Defaulter;

import lombok.extern.slf4j.Slf4j;

/**  This class is designed to connect SMTP server to send email using Gmail Service.
 * @author Aman Anand
 *
 */
@Slf4j
@Component
public class EmailService {
	
	public String sendEmailReport(Defaulter defaulter) {
		log.info("EmailService.sendEmailReport >> inside controller...");
		run(defaulter);
		return "Email Sent !!";
	}
	
	public void run(Defaulter defaulter) {
		log.info("EmailService.run >> Sending Email...");
		
		Session session = createEmailSession();

		try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("email@gmail.com")); //add email
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(defaulter.getEmailId())
	        );
	        
	        message.setSubject("Bihar Traffic Police- Fine_"+defaulter.getVehicleNumber());
	        message.setText("Dear "+defaulter.getOwnerName()+","
	        		+ "\n\n Greetings of the Day!"
	                + "\n\n You have broken the traffic rules last week, by you vehicle number: "+defaulter.getVehicleNumber()
	                + "\n Reason: "+defaulter.getDescription()
	                + "\n\n You need to pay a fine of Rs. "+defaulter.getFine()+" within next 15 days"
	                + "\n\n Thanks !!"
	                + "\n Bihar Traffic Police");
	
	       Transport.send(message);
	
	   	log.info("EmailService.run >> Email Sent!!");
	
	    } catch (MessagingException e) {
	        log.error("EmailService.run >> error occured while sending email. Message: "+e.getMessage());
	    }
	}

	private Session createEmailSession() {
		final String username = "eamil@gmail.com";//add email
		final String password = "";// add password

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(prop,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });
		return session;
	}

}
