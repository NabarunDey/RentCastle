package com.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.CredentialsDao;

public class CloudinaryHandler {

	private static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			  "cloud_name", "rentcastlecloudimages",
			  "api_key", "569927272779378",
			  "api_secret", CredentialsDao.getValue("cloudinary_app_secret")));
	
	public static Map uploadImage(File file)
	{
		Map uploadResult=null;
		
		try {
			 uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uploadResult;
	}
	
	
	public static void delete(String publicId)
	{
		 try {
			cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
