package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import productManagement.appService.inputBeans.ProductManagementAppServiceIB;
import search.appService.inputBeans.SearchProductAppServiceIB;
import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;

import com.databaseBeans.ProductsDBBean;
import com.structures.status.ProductStatus;
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
		String pinConcat = "";
		if("All".equals(addProductAppServiceIB.getProductpin()))
		{
			pinConcat=addProductAppServiceIB.getProductpin();
		}
		else
		{
			for(String pin : addProductAppServiceIB.getProductpin().split(",") )
			{
				pinConcat = pinConcat+pin+"|";
			}
		}
		productsDBBean.setProductpin(pinConcat);
		productsDBBean.setImages(imageIdsConcat);
		productsDBBean.setUsername(addProductAppServiceIB.getUsername());
		productsDBBean.setApprovalStatus(ProductStatus.PENDING.toString());

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
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class);
			//	.add(Restrictions.like("productname", "%"+searchString+"%"));*/
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like("productname", "%"+searchString+"%"));
		disjunction.add(Restrictions.like("description", "%"+searchString+"%"));
		Criterion completeCondition=disjunction;
		criteria.add(completeCondition);
		productsDBBeans = criteria.list();

		return productsDBBeans;
	}

	public List<ProductsDBBean> searchByCriteria(SearchProductAppServiceIB searchProductAppServiceIB)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class);
		Criterion completeCondition = null;
		Disjunction disjunction = Restrictions.disjunction();

		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchState()))
			disjunction.add(Restrictions.like("productstate", "%"+searchProductAppServiceIB.getSearchState()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchCity()))
			disjunction.add(Restrictions.like("productcity", "%"+searchProductAppServiceIB.getSearchCity()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchPin()))	
			disjunction.add(Restrictions.like("productpin", "%"+searchProductAppServiceIB.getSearchPin()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchType()))	
			disjunction.add(Restrictions.like("producttype", "%"+searchProductAppServiceIB.getSearchType()+"%"));
		if(StringUtils.isNotEmpty(searchProductAppServiceIB.getSearchSubType()))	
			disjunction.add(Restrictions.like("subproducttype", "%"+searchProductAppServiceIB.getSearchSubType()+"%"));

		completeCondition = disjunction;
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
		productsDBBean.setStatus(ProductStatus.DELETED.toString());
		template.delete(productsDBBean);
		ProductsDBBean productsDBBean2 = new ProductsDBBean();
		CommonUtility.copyBean(productsDBBean, productsDBBean2);
		return productsDBBean2;
	}

	public List<ProductsDBBean> getProductListByIdsString(List<String> productIds)
	{
		List<ProductsDBBean> productsDBBeans = null;
		List<Integer> integers = new ArrayList<Integer>();
		for(String productId : productIds)
		{
			integers.add(Integer.parseInt(productId));
		}
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
				.add(Restrictions.in("productid", integers));
		productsDBBeans=criteria.list();
		return productsDBBeans;
	}
	public List<ProductsDBBean> getProductListByIdsInteger(List<Integer> productIds)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
				.add(Restrictions.in("productid", productIds));
		productsDBBeans=criteria.list();
		return productsDBBeans;
	}

	public void editProduct(ProductManagementAppServiceIB productManagementAppServiceIB)
	{
		ProductsDBBean productsDBBean = new ProductsDBBean();

		CommonUtility.copyBean(productManagementAppServiceIB, productsDBBean);
		productsDBBean.setProductid(Integer.parseInt(productManagementAppServiceIB.getProductId()));
		if(null!= productManagementAppServiceIB.getImageIdsList() && productManagementAppServiceIB.getImageIdsList().size()>=1)
		{
			String imageIdsConcat = "";

			for(String imageId :productManagementAppServiceIB.getImageIdsList())
			{
				imageIdsConcat= imageIdsConcat+imageId+"|";
			}
			productsDBBean.setImages(imageIdsConcat);

		}
		String pinConcat = "";
		for(String pin : productManagementAppServiceIB.getProductpin().split(",") )
		{
			pinConcat = pinConcat+pin+"|";
		}
		productsDBBean.setProductpin(pinConcat);
		productsDBBean.setUsername(productManagementAppServiceIB.getUsername());
		productsDBBean.setApprovalStatus(ProductStatus.PENDING.toString());

		try{
			template.update(productsDBBean);
		}catch (Exception exception)
		{
		}
	}

	public void changeApprovalStatus(String productId, String approvalStatus)
	{
		ProductsDBBean productsDBBean =template.get(ProductsDBBean.class, Integer.parseInt(productId));
		productsDBBean.setApprovalStatus(approvalStatus);
		template.update(productsDBBean);
	}
	
	public List<ProductsDBBean> viewPendingProducts()
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class);
		Criterion completeCondition = null;
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like("approvalStatus", ProductStatus.PENDING.toString()));
		completeCondition = disjunction;
		criteria.add(completeCondition);
		productsDBBeans = criteria.list();
		return productsDBBeans;
	}
}
