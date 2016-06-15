package com.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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
	public ImagesDaoOB insertMultipleProductImages(AddProductAppServiceIB addProductAppServiceIB){  

		ImagesDaoOB imagesDaoOB= new ImagesDaoOB();
		ArrayList<String> imageIdsList = new ArrayList<String>();
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") +"\\";
		ApplicationContextProvider appContext = new ApplicationContextProvider();
		UserProfile userProfile = appContext.getApplicationContext().getBean("userProfile", UserProfile.class);

		try{
			for(FileBean fileBean: addProductAppServiceIB.getFileBeans())
			{
				String imageId= userProfile.getUserName() + Calendar.getInstance().getTimeInMillis();
				String imagePath = imageId+".jpg";
				File destFile  = new File(contextPath+"productImages\\", imageId+".jpg");
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
	@Transactional
	public List<ImagesDBBean> getImagesByIdList(List<String> imageIds){  
		List<ImagesDBBean> list; 
		List<ImagesDBBean> querryList = new ArrayList<ImagesDBBean>();
		ImagesDBBean imagesDBBean =new ImagesDBBean();
		imageIds.add("nabarundeysit@gmail.com1465650411661");
		for(String imageId : imageIds)
		{
		
			imagesDBBean.setImagepath(imageId+".jpg");
			querryList.add(imagesDBBean);
		}
		
		Query q = template.getSessionFactory().getCurrentSession().createQuery("select imagepath from images where imageid like 'nabarundeysit@gmail.com1465650411661'");
		//q.setParameter(1, imageIds);
		 list= q.list();

		/*list =(List<ImagesDBBean>) template.getSessionFactory().getCurrentSession().createCriteria(ImagesDBBean.class)
										.add(Example.create(querryList)).list();*/
		return list;  
	}  

}
