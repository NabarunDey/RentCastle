package com.util;

import help.appService.inputBeans.HelpAppServiceIB;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dao.CredentialsDao;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.PaymentsDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.UsersDBBean;
import com.sessionBeans.UserProfile;

public class MailHandler {

	private static Session session= null;
	private static boolean initialized;

	private static void initialize() {

		final String username = "support@i-fit.in";
		final String password = CredentialsDao.getValue("mail_password");

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.i-fit.in");

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
			message.setFrom(new InternetAddress("support@i-fit.in"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("i-Fit Password Reset");
			message.setText("Dear User,"
					+ "\n\nWe have received a Password Retrieval request from your i-Fit id."
					+ "\n\nYour temporary password is "+password
					+"\n\nRegards,"
					+ "\ni-Fit Team");

			Transport.send(message);
			mailSuccess= true;

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+emailId +" " + e.getMessage());
			e.printStackTrace();
		}
		return mailSuccess;
	}

	public static void welcomeMail(String emailId)
	{
		try {

			if(!initialized)
			{
				initialize();
				initialized=true;
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("support@i-fit.in"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("Welcome to i-Fit");
			message.setText("Dear User,"
					+ "\n\nThanks for registering @ i-Fit. Wish you a pleasant experience."
					+"\n\nRegards,"
					+ "\ni-Fit Team");

			Transport.send(message);

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+emailId +" " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void feedBackMail(HelpAppServiceIB helpAppServiceIB)
	{
		try {

			if(!initialized)
			{
				initialize();
				initialized=true;
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("support@i-fit.in"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("nabarundeysit@gmail.com"));
			message.setSubject("i-Fit Feedback");
			message.setText("Dear Admin,"
					+ "\n\nU have a new i-Fit feedback."
					+ "\n Name :"+helpAppServiceIB.getName()
					+ "\n Email :"+helpAppServiceIB.getEmail()
					+ "\n Mobile :"+helpAppServiceIB.getMobile()
					+ "\n Type :"+helpAppServiceIB.getCategory()
					+ "\n Messege :"+helpAppServiceIB.getMessage()

					+"\n\nRegards,"
					+ "\ni-Fit Team");

			Transport.send(message);

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to nabarundeysit@gmail.com " + e.getMessage());
			e.printStackTrace();
		}
	}


	public static boolean orderConfirmationMailCustomer(ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean,UserProfile userProfile,int total)
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
					InternetAddress.parse(userProfile.getEmail()));
			message.setSubject("RentCastle OrderConfirmation - ORD00"+ordersDBBean.getOrderid());


			String order="\n\n\nOrder Id : ORD00"+ordersDBBean.getOrderid()+"\nProduct Id :PRD00"+ordersDBBean.getProductid()+
					"\nProduct Name  : "+productsDBBean.getProductname()+"\nAddress : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin()
					+"\nTotal Amount  : "+total;
			message.setText("Dear "+userProfile.getFirstName()+","
					+ "\n\n We have received the following order."+order+"\n\nRegards,"
					+ "\nRentCastle Team");

			Transport.send(message);
			mailSuccess= true;

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+userProfile.getEmail() +" " + e.getMessage());
			e.printStackTrace();
		}
		return mailSuccess;
	}

	public static boolean orderConfirmationMailVendor(ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean, String email)
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
					InternetAddress.parse(email));
			message.setSubject("RentCastle OrderConfirmation - ORD00"+ordersDBBean.getOrderid());


			String order="\n\n\nOrder Id : ORD00"+ordersDBBean.getOrderid()+"\nProduct Id :PRD00"+ordersDBBean.getProductid()+
					"\nProduct Name  : "+productsDBBean.getProductname();
			message.setText("Dear User,"
					+ "\n\n The following order have been placed on the items offerred by you."+order+"\n\nRegards,"
					+ "\nRentCastle Team");

			Transport.send(message);
			mailSuccess= true;

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+productsDBBean.getUsername()+" " + e.getMessage());
			e.printStackTrace();
		}
		return mailSuccess;
	}


	public static boolean paymentAddedMail(PaymentsDBBean paymentsDBBean, UsersDBBean usersDBBean)
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
					InternetAddress.parse(usersDBBean.getEmail()));
			message.setSubject("Pending Payment - PMT00"+paymentsDBBean.getPaymentid());


			String pmt="\n\n\nOrder Id : ORD00"+paymentsDBBean.getOrderid()
					+"\nPayment Id  : "+paymentsDBBean.getPaymentid()
					+"\nRent Amount : "+paymentsDBBean.getRentamount()
					+"\nSecurity Money : "+paymentsDBBean.getSecuritymoney()
					+"\nDelivery Charges : "+paymentsDBBean.getDeliveryCharge()
					+"\nDate : "+paymentsDBBean.getDatetime();


			if(usersDBBean.getUsername().equals(paymentsDBBean.getTousername()))
			{
				message.setText("Dear "+usersDBBean.getFirstname()+","
						+ "\n\n A pending payment is generated for your below item."
						+ "\n You will receive the money within 2-3 days."
						+ "\n You will be contacted by our team regarding payment options."
						+pmt
						+"\n\nRegards,"
						+"\nRentCastle Team");
				Transport.send(message);
			}

			if(usersDBBean.getUsername().equals(paymentsDBBean.getFromusername()))
			{
				message.setText("Dear "+usersDBBean.getFirstname()+","
						+ "\n\n A pending payment is generated for your below item."
						+ "\n You will be contacted by our team regarding payment options."+pmt+"\n\nRegards,"
						+ "\nRentCastle Team");
				Transport.send(message);
			}

			mailSuccess= true;

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+usersDBBean.getEmail() +" " + e.getMessage());
			e.printStackTrace();
		}
		return mailSuccess;
	}

	public static boolean paymentCompleted(PaymentsDBBean paymentsDBBean, UsersDBBean usersDBBean)
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
					InternetAddress.parse(usersDBBean.getEmail()));
			message.setSubject("Pending Payment - PMT00"+paymentsDBBean.getPaymentid());


			String pmt="\n\n\nOrder Id : ORD00"+paymentsDBBean.getOrderid()
					+"\nPayment Id  : "+paymentsDBBean.getPaymentid()
					+"\nRent Amount : "+paymentsDBBean.getRentamount()
					+"\nSecurity Money : "+paymentsDBBean.getSecuritymoney()
					+"\nDelivery Charges : "+paymentsDBBean.getDeliveryCharge()
					+"\nDate : "+paymentsDBBean.getDatetime();


			if(usersDBBean.getUsername().equals(paymentsDBBean.getTousername()))
			{
				message.setText("Dear "+usersDBBean.getFirstname()+","
						+ "\n\nThe amount for the following payment has been made to you."
						+ "\n Thank you for your business."
						+ "\n In case you did not receive the money, please feel free to contact with us."
						+pmt
						+"\n\nRegards,"
						+"\nRentCastle Team");
				Transport.send(message);
			}

			if(usersDBBean.getUsername().equals(paymentsDBBean.getFromusername()))
			{
				message.setText("Dear "+usersDBBean.getFirstname()+","
						+ "\n\n We have received your payment with respect to the below order.."
						+ "\n Thank you for your business."
						+pmt
						+"\n\nRegards,"
						+ "\nRentCastle Team");
				Transport.send(message);
			}

			mailSuccess= true;

		} catch (Exception e) {
			System.out.println("Mail Could not be sent to "+usersDBBean.getEmail() +" " + e.getMessage());
			e.printStackTrace();
		}
		return mailSuccess;
	}

}