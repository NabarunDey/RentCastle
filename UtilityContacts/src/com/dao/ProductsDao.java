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
		
		String imageIdsConcat = "";
		for(String imageId :addProductAppServiceIB.getImageIdsList())
		{
			imageIdsConcat= imageIdsConcat+imageId+"|";
		}
		productsDBBean.setImages(imageIdsConcat);
		
		productsDBBean.setUsername(addProductAppServiceIB.getUsername());
		
		
		boolean success = true;
		try{
		template.save(productsDBBean);
		}catch (Exception exception)
		{
			success= false;
		}
		AddProductDaoOB addProductDaoOB =new AddProductDaoOB();
		addProductDaoOB.setSuccess(success);
		addProductDaoOB.setProductId(productsDBBean.getProductid());
		return addProductDaoOB;
	}
	
	public ProductsDBBean getProductDetails(int productId)
	{
		ProductsDBBean productsDBBean = null;
		try{
			productsDBBean= (ProductsDBBean) template.get(ProductsDBBean.class,productId);
		}catch(Exception exception)
		{
			System.out.println("Error in fetchin ProductsDBBean");

		}
		return productsDBBean;
	}

}
