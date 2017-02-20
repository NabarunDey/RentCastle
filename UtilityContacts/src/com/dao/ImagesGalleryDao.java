package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import addProduct.appService.inputBeans.FileBean;
import addProduct.dao.outputBeans.ImagesDaoOB;

import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ImagesGalleryDBBean;
import com.databaseBeans.ProductsDBBean;
import com.util.CloudinaryHandler;
import com.util.CommonUtility;

@Transactional
public class ImagesGalleryDao {

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
	public ImagesGalleryDBBean addImagesGallery(){  
		
		ImagesGalleryDBBean imagesGalleryDBBean = new ImagesGalleryDBBean();
		template.save(imagesGalleryDBBean);
		return imagesGalleryDBBean;
	}
	
	public ImagesGalleryDBBean getImagesGallery(int imageGalleryId)
	{
		ImagesGalleryDBBean imagesGalleryDBBean = template.get(ImagesGalleryDBBean.class, imageGalleryId);
		return imagesGalleryDBBean;
	}
}
