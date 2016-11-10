package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.StringUtils;

import cart.projector.outputBeans.CartItem;

import com.dao.CredentialsDao;
import com.databaseBeans.OrdersDBBean;
import com.databaseBeans.ProductsDBBean;



public class SMSHandler 
{
	final static String auth = CredentialsDao.getValue("smsAuthToken");
	final static String smsEnabled = CredentialsDao.getValue("smsEnabled");


	public static void sendOrderConfirmationSmsCustomer(String mobile,ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean,int total){

		if(StringUtils.isNotEmpty(smsEnabled)&&"true".equals(smsEnabled) )
		{
			String newline = System.getProperty("line.separator");
			String orderTxt="Order Confirmation:"+newline+"Product : "+productsDBBean.getProductname()+""+newline+"Address : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin()
					+""+newline+"Total : "+total
					+""+newline+"Regards,"+newline+"RentCastle Team";
			String param="authkey="+auth+"&mobiles="+mobile+"&message="+orderTxt+"&sender=RentCS&route=4&country=91";
			sendPost(param);
		}
	}
	
	public static void sendOrderConfirmationSmsVendor(String mobile,ProductsDBBean productsDBBean, OrdersDBBean ordersDBBean,CartItem cartItem,int total){

		if(StringUtils.isNotEmpty(smsEnabled)&&"true".equals(smsEnabled) )
		{
			String newline = System.getProperty("line.separator");
			String orderTxt="Order Placed:"+newline+"Product : "+productsDBBean.getProductname()+""+newline
					+"Rent : "+cartItem.getPeriodValue() +" "+cartItem.getPeriodUnit()+" Rs."+cartItem.getRentAmount()+newline
					+"Security : "+cartItem.getSecurityMoney()+newline
					+"Regards,"+newline+"RentCastle Team";
			String param="authkey="+auth+"&mobiles="+mobile+"&message="+orderTxt+"&sender=RentCS&route=4&country=91";
			sendPost(param);
		}
	}
	
	public static void sendPost(String urlParameters)
	{
		String url = "https://control.msg91.com/api/sendhttp.php";
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}