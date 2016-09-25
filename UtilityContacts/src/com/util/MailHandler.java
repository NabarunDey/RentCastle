package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;
import com.sessionBeans.UserProfile;

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
				InternetAddress.parse(emailId));
			message.setSubject("RentCastle Password Reset");
			message.setText("Dear User,"
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
	
	public static boolean orderConfirmationMailCustomer(ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean,UserProfile userProfile)
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
				InternetAddress.parse(userProfile.getUserName()));
			message.setSubject("RentCastle OrderConfirmation - ORD00"+ordersDBBean.getOrderid());
			
			
			String order="\n\n\nOrder Id : ORD00"+ordersDBBean.getOrderid()+"\nProduct Id :PRD00"+ordersDBBean.getProductid()+
					"\nProduct Name  : "+productsDBBean.getProductname()+"\nAddress : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin();
			message.setText("Dear "+userProfile.getUserName()+","
					+ "\n\n We have received the following order."+order+"\n\nRegards,"
					+ "\nRentCastle Team");
			
			Transport.send(message);
			mailSuccess= true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return mailSuccess;
	}
	
	public static boolean orderConfirmationMailVendor(ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean)
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
				InternetAddress.parse(productsDBBean.getUsername()));
			message.setSubject("RentCastle OrderConfirmation - ORD00"+ordersDBBean.getOrderid());
			
			
			String order="\n\n\nOrder Id : ORD00"+ordersDBBean.getOrderid()+"\nProduct Id :PRD00"+ordersDBBean.getProductid()+
							"\nProduct Name  : "+productsDBBean.getProductname()+"\nAddress : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin();
			message.setText("Dear User,"
					+ "\n\n The following order have been placed on the items offerred by you."+order+"\n\nRegards,"
					+ "\nRentCastle Team");
			
			Transport.send(message);
			mailSuccess= true;
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return mailSuccess;
	}
	
}