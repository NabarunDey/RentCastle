package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.dao.CredentialsDao;

import userRegistration.appService.inputBeans.UserRegistrationAppServiceIB;



public class FacebookHandler {
	public static final String FB_APP_ID = "841162669353192";
	public static final String FB_APP_SECRET = CredentialsDao.getValue("fb_app_secret");
	public static String REDIRECT_URI = "";

	static String accessToken = "";

	public static String getFBAuthUrl() {
		String fbLoginUrl = "";
		try {
			fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id="
					+ FB_APP_ID + "&redirect_uri="
					+ URLEncoder.encode(REDIRECT_URI, "UTF-8")
					+ "&scope=email";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbLoginUrl;
	}

	public static String getFBGraphUrl(String code) {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://graph.facebook.com/oauth/access_token?"+"scope=public_profile,email"
					+ "&client_id=" + FB_APP_ID + "&redirect_uri="
					+ URLEncoder.encode(REDIRECT_URI, "UTF-8")
					+ "&client_secret=" + FB_APP_SECRET + "&code=" + code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

	public static String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(getFBGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection fbConnection;
			StringBuffer b = null;
			try {
				fbConnection = fbGraphURL.openConnection();
				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(
						fbConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook "
						+ e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: "
						+ accessToken);
			}
		}
		return accessToken;
	}

	public static String getFBGraph() {
		String graph = null;
		try {

			String g = "https://graph.facebook.com/me?" + accessToken;
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			graph = b.toString();
			System.out.println(graph);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
		return graph;
	}

	public static Map<String, String> getGraphData(String fbGraph) {
		Map<String, String> fbProfile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(fbGraph);
			fbProfile.put("id", json.getString("id"));
			fbProfile.put("first_name", json.getString("name"));
			if (json.has("email"))
				fbProfile.put("email", json.getString("email"));
			if (json.has("gender"))
				fbProfile.put("gender", json.getString("gender"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return fbProfile;
	}


	public static UserRegistrationAppServiceIB getfbData(String code,String server)
	{
		
		REDIRECT_URI = "http://"+server+"/loginFunction";

		UserRegistrationAppServiceIB userRegistrationAppServiceIB = new UserRegistrationAppServiceIB();
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		accessToken =getAccessToken(code);

		String graph = getFBGraph();
		Map<String, String> fbProfileData = getGraphData(graph);
		userRegistrationAppServiceIB.setUsername(fbProfileData.get("id"));
		userRegistrationAppServiceIB.setFirstname(fbProfileData.get("first_name").split(" ")[0]);
		userRegistrationAppServiceIB.setLastname(fbProfileData.get("first_name").split(" ")[1]);

		return userRegistrationAppServiceIB;
	}
}
