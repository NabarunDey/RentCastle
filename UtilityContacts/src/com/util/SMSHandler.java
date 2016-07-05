package com.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


  
  public class SMSHandler 
  {
	 
	  
	    public static void main( String[] args ){

	    	try {
	    	  URL url = new URL("http://www.smslane.com/vendorsms/pushsms.aspx?user=nabarundeysit@gmail.com&password=806264&msisdn=919641814868&sid=WEBSMS&msg=Hello&fl=0");		  
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