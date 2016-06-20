package com.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import search.appService.inputBeans.SearchProductAppServiceIB;
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
		String locationConcat = "";
		for(String location : addProductAppServiceIB.getProductlocation().split(",") )
		{
			locationConcat = locationConcat+location+"|";
		}
		productsDBBean.setProductlocation(locationConcat);
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
	
	public List<ProductsDBBean> searchByCriteria(SearchProductAppServiceIB searchProductAppServiceIB)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class);
		Criterion completeCondition = null;
		Conjunction conjunction = Restrictions.conjunction();

		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchState()))
			conjunction.add(Restrictions.like("productstate", "%"+searchProductAppServiceIB.getSearchState()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchCity()))
			conjunction.add(Restrictions.like("productcity", "%"+searchProductAppServiceIB.getSearchCity()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchLocation()))	
			conjunction.add(Restrictions.like("productlocation", "%"+searchProductAppServiceIB.getSearchLocation()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchLocation()))	
			conjunction.add(Restrictions.like("producttype", "%"+searchProductAppServiceIB.getSearchType()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchLocation()))	
			conjunction.add(Restrictions.like("subproducttype", "%"+searchProductAppServiceIB.getSearchSubType()+"%"));
	
		completeCondition = conjunction;
		criteria.add(completeCondition);
		productsDBBeans = criteria.list();

		return productsDBBeans;
	}
	
	public List<ProductsDBBean> searchByVendor(String username)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
				.add(Restrictions.like("username", username));
		productsDBBeans = criteria.list();

		return productsDBBeans;
	}
	
	public ProductsDBBean deleteProduct(String productId)
	{
		ProductsDBBean productsDBBean = new ProductsDBBean();
		productsDBBean = template.get(ProductsDBBean.class, Integer.parseInt(productId));
		template.delete(productsDBBean);
		ProductsDBBean productsDBBean2 = new ProductsDBBean();
		CommonUtility.copyBean(productsDBBean, productsDBBean2);
		return productsDBBean2;
	}

	public List<ProductsDBBean> getProductListByIds(List<String> productIds)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
				.add(Restrictions.in("productId", productIds));
		productsDBBeans=criteria.list();
		return productsDBBeans;
	}

}
