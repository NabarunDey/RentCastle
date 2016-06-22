package com.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.sessionBeans.UserProfile;
import com.util.ApplicationContextProvider;
import com.util.CommonUtility;

@Transactional
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
	public ImagesDaoOB insertMultipleProductImages(List<FileBean> fileBeans){  

		ImagesDaoOB imagesDaoOB= new ImagesDaoOB();
		ArrayList<String> imageIdsList = new ArrayList<String>();
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") +"\\";
		ApplicationContextProvider appContext = new ApplicationContextProvider();
		UserProfile userProfile = appContext.getApplicationContext().getBean("userProfile", UserProfile.class);

		try{
			for(FileBean fileBean: fileBeans)
			{
				String imageId= userProfile.getUserName() + Calendar.getInstance().getTimeInMillis();
				String imagePath = "productImages\\"+imageId+".jpg";
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
		}
		return imagesDaoOB;  
	}  
	
	public List<ImagesDBBean> getImagesByIdList(List<String> imageIds){  
		List<ImagesDBBean> list; 

		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ImagesDBBean.class)
				.add(Restrictions.in("imageid", imageIds));
		list=criteria.list();
		String contextPath =  ServletActionContext.getServletContext().getContextPath();
		List<ImagesDBBean> newImageList = new ArrayList<ImagesDBBean>(); 

		for(ImagesDBBean imagesDBBean : list)
		{
			ImagesDBBean imagesDBBean2 = new ImagesDBBean();
			CommonUtility.copyBean(imagesDBBean, imagesDBBean2);
			imagesDBBean2.setImagepath(contextPath+"/images/"+imagesDBBean.getImagepath());
			newImageList.add(imagesDBBean2);
		}
		return newImageList;  
	}  

	public Map<String,ImagesDBBean> getPrimaryImageOfProduct(List<ProductsDBBean> productsDBBeans)
	{
		Map<String,ImagesDBBean> imageMap = new HashMap<String, ImagesDBBean>();
		Map<String,String> imageProductMap = new HashMap<String, String>();
		List<String> imageIds = new ArrayList<String>();
		for(ProductsDBBean productsDBBean : productsDBBeans)
		{
			String[] str = productsDBBean.getImages().split("\\|");
			imageIds.add(str[0]);
			imageProductMap.put(str[0],String.valueOf(productsDBBean.getProductid()));
		}
		List<ImagesDBBean> imagesDBBeans= getImagesByIdList(imageIds);
		
		for(ImagesDBBean imagesDBBean : imagesDBBeans)
		{
			imageMap.put(imageProductMap.get(imagesDBBean.getImageid()), imagesDBBean);
		}
		return imageMap;
		
	}
	
	public void deleteImagesList(List<String> imageIds)
	{

		String hql = "delete from com.databaseBeans.ImagesDBBean where imageid in :imageIds";
		template.getSessionFactory().getCurrentSession().createQuery(hql).setParameterList("imageIds", imageIds).executeUpdate();
		
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") +"\\";
		for(String imageId: imageIds)
		{
			File destFile  = new File(contextPath+"productImages\\", imageId+".jpg");
			destFile.delete();
		}
	}

}
