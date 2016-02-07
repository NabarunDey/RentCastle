package com.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.databaseBeans.ImagesDBBean;
import com.sessionBeans.UserProfile;
import com.util.ApplicationContextProvider;

public class ImagesDao {

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
		this.template = template;  
	}  
	public void saveImages(ImagesDBBean e){  
		template.save(e);  
	}  
	public void updateImages(ImagesDBBean e){  
		template.update(e);  
	}  
	public void deleteImages(ImagesDBBean e){  
		template.delete(e);  
	}  
	public ImagesDaoOB insertMultipleImages(AddProductAppServiceIB addProductAppServiceIB){  

		ImagesDaoOB imagesDaoOB= new ImagesDaoOB();
		ArrayList<String> imageIdsList = new ArrayList<String>();
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") ;
		ApplicationContextProvider appContext = new ApplicationContextProvider();
		UserProfile userProfile = appContext.getApplicationContext().getBean("userProfile", UserProfile.class);

		try{
			for(FileBean fileBean: addProductAppServiceIB.getFileBeans())
			{
				String imageId= userProfile.getUserName() + Calendar.getInstance().getTimeInMillis();
				String imagePath = contextPath+imageId+".jpg";
				File destFile  = new File(contextPath, imageId+".jpg");
				FileUtils.copyFile(fileBean.getFile(), destFile);

				ImagesDBBean imagesDBBean =new ImagesDBBean();
				imagesDBBean.setImageid(imageId);
				imagesDBBean.setImagepath(imagePath);
				saveImages(imagesDBBean);
				imageIdsList.add(imageId);

			}
			imagesDaoOB.setImageIdsList(imageIdsList);
		}catch(Exception exception)
		{
			System.out.println("ggtg");
		}
		return imagesDaoOB;  
	}  

}
