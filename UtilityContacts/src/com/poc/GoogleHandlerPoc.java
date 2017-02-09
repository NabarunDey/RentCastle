package com.poc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;

import com.dao.CredentialsDao;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoogleHandlerPoc {

	public static String accessToken(String code,String server)
	{
		String urlParameters = "code="
				+ code
				+ "&client_id=968847956660-7cs0n3ke5m69hj96hp9sfmqql34gsd4s.apps.googleusercontent.com"
				+ "&client_secret="+CredentialsDao.getValue("google_client_secret")
				+ "&redirect_uri=http://"+server+"/loginFunctionStep1"
				+ "&grant_type=authorization_code";
		try{
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					urlConn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			//get output in outputString 
			String line, outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			System.out.println(outputString);

			//get Access Token 
			JsonObject json = (JsonObject)new JsonParser().parse(outputString);
			String access_token = json.get("access_token").getAsString();
			return access_token;
		}catch (Exception e) {
			return null;
		}
	}

	public static UserRegistrationAppServiceIB getUserInfo(String access_token)
	{

		UserRegistrationAppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();

		try{
			URL	url = new URL(
					"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
							+ access_token);
			URLConnection urlConn = url.openConnection();
			String line,outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			JsonObject json2 = (JsonObject)new JsonParser().parse(outputString);
			userRegistrationAppServiceIB.setUsername(json2.get("id").getAsString());
			userRegistrationAppServiceIB.setFirstname(json2.get("given_name").getAsString());
			userRegistrationAppServiceIB.setLastname(json2.get("family_name").getAsString());
			userRegistrationAppServiceIB.setEmail(json2.get("email").getAsString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRegistrationAppServiceIB;
	}

}
