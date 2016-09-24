package com.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.databaseBeans.OrdersDBBean;

public class MailHandler {

	private static Session session= null;
	private static boolean initialized;
	
	public static void initialize() {

		final String username = "nabarundey@rentcastle.in";
		final String password = "nabarunrent@1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.rentcastle.in");

		 session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
	}
	
	public static boolean passwordResetMail(String emailId, String password)
	{
		boolean mailSuccess =false;
		try {
			
			if(!initialized)
			{
				initialize();
				initialized=true;
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nabarundey@rentcastle.in"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("nabarundeysit@gmail.com"));
			message.setSubject("Password Reset");
			message.setText("Dear Mail Crawler,"
				+ "\n\n We have received a Password Retrieval request from your RentCastle id."
				+ "\n\n Your password is "+password
				+"\n\nRegards,"
				+ "\nRentCastle Team");

			Transport.send(message);
			mailSuccess= true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return mailSuccess;
	}
	
	public static boolean orderConfirmationMail(String emailId, List<OrdersDBBean> ordersDBBeans)
	{
		boolean mailSuccess =false;
		try {
			
			if(!initialized)
			{
				initialize();
				initialized=true;
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nabarundey@rentcastle.in"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("nabarundeysit@gmail.com"));
			message.setSubject("OrderConfirmation");
			
			
			String orders="";
			for(OrdersDBBean ordersDBBean : ordersDBBeans)
			{
				orders=orders+"\n\n\nOrder Id : ORD"+ordersDBBean.getOrderid()+"\nProduct Id :PRD"+ordersDBBean.getProductid()+
							"\nAddress : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin();
			}
			message.setText("Dear Mail Crawler,"
					+ "\n\n We have received the following orders."+orders+"\n\nRegards,"
					+ "\nRentCastle Team");
			
			Transport.send(message);
			mailSuccess= true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return mailSuccess;
	}
	
}