package com.aesis.utility;



import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import com.testing.framework.EmailUtils;





public class readOtpByMail {

	
	public static void main(String args[]) throws Exception {
	

		EmailUtils emailUtils = new EmailUtils();
		Properties prop = new Properties();

		//prop.load(new FileInputStream(System.getProperty("user.dir") + "/configuration/mailConfig.properties"));
		prop.setProperty("to", "aeconnect@guildhousegroup.com");
		prop.setProperty("gmail_from", "akshay.patil1541@gmail.com");
		prop.setProperty("gmail_username", "akshay.patil1541@gmail.com");
		prop.setProperty("gmail_password", "ecnipmznbgrdauge");
		prop.setProperty("gmail_port", "587");

		Store connection = emailUtils.connectToGmail(prop);
		// emailUtils.getUnreadMessages(connection, "Inbox")
		
		@SuppressWarnings("unchecked")
		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(connection, "Inbox",
				"aeconnect@guildhousegroup.com", "AE Connect - Two Factor Authentication");

		if(emailtext.size()<1)
			throw new Exception("No OTP received");
		else {
			String regex = "[^\\d]+";
			String[] arrOTP = emailtext.get(0).split(regex);
			
			System.out.println("OTP is :"+arrOTP[1]);
			
		}
		 
		
	}
}