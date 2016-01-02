package com.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;

import com.databaseBeans.ProductsDBBean;
import com.util.CommonUtility;

public class ProductsDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  

		
	
	public AddProductDaoOB addProduct(
			AddProductAppServiceIB addProductAppServiceIB) {

		ProductsDBBean productsDBBean = new  ProductsDBBean();
		CommonUtility.copyBean(addProductAppServiceIB, productsDBBean);
		
		
		template.save(productsDBBean);
		AddProductDaoOB addProductDaoOB =new AddProductDaoOB();
		return addProductDaoOB;
	}

}
