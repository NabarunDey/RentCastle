package com.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

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

			String orderTxt="Order Confirmation:\\nProduct : "+productsDBBean.getProductname()+"\\nAddress : "+ordersDBBean.getAddress()+" "+ordersDBBean.getPin()
					+"\\nTotal : "+total
					+"\\nRegards,\\nRentCastle Team";
		//	orderTxt="sss";
			try {
				URL url = new URL("https://control.msg91.com/api/sendhttp.php?authkey="+auth+"&mobiles="+mobile+"&message="+orderTxt+"&sender=RentCS&route=4&country=91&unicode=1");		  
				HttpURLConnection uc;

				uc = (HttpURLConnection)url.openConnection();
				System.out.println(uc.getResponseMessage());

				uc.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}