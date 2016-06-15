package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;

import com.databaseBeans.ProductsDBBean;
import com.util.CommonUtility;

@Transactional
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
	
	public List<ProductsDBBean> searchByProductName(String searchString)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
				.add(Restrictions.like("productname", "%"+searchString+"%"));
		productsDBBeans = criteria.list();

		return productsDBBeans;
	}

}
