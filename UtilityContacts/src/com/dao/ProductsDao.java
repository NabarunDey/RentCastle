package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.orm.hibernate4.HibernateTemplate;
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

	boolean indexed = false;

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
				if(StringUtils.isNotEmpty(pin))
					pinConcat = pinConcat+pin+"|";
			}
		}

		if(StringUtils.isEmpty(productsDBBean.getDeliveryCharge()))
		{
			productsDBBean.setDeliveryCharge("0");
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

		String[] querryParts  = searchString.split("[^.\\w]");


		Disjunction disjunction = Restrictions.disjunction();

		for(String part : querryParts)
		{
			disjunction.add(Restrictions.like("productname", "%"+part.trim()+"%"));
			disjunction.add(Restrictions.like("description", "%"+part.trim()+"%"));
		}


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
		if(null!= productIds && productIds.size()>0)
		{
			Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class)
					.add(Restrictions.in("productid", productIds));
			productsDBBeans=criteria.list();
		}
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
			if(StringUtils.isNotEmpty(pin))
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

	public List<ProductsDBBean> getProductListSortedById(int n, List<Integer> productIdsToBeNeglected)
	{
		List<ProductsDBBean> productsDBBeans = null;
		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(ProductsDBBean.class);
		criteria.setMaxResults(n);
		criteria.addOrder(Order.asc("productid"));

		if(null!= productIdsToBeNeglected)
			criteria.add(Restrictions.not(Restrictions.in("id", productIdsToBeNeglected)));

		productsDBBeans = criteria.list();
		return productsDBBeans;
	}

	private  void doIndex() throws InterruptedException {

		FullTextSession fullTextSession = Search.getFullTextSession(template.getSessionFactory().getCurrentSession());
		fullTextSession.createIndexer().startAndWait();
	}

	public  List<ProductsDBBean> searchProductIndexed(String queryString) {
		try {
			if(!indexed)
			{
				doIndex();
				indexed=true;

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ProductsDBBean> productsDBBeans =null;
		try{
			FullTextSession fullTextSession = Search.getFullTextSession(template.getSessionFactory().getCurrentSession());

			QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(ProductsDBBean.class).get();
			//	org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("productname").matching(queryString).createQuery();

			String[] querryParts  = queryString.split("[^.\\w]");


			org.apache.lucene.search.Query luceneQuery =queryBuilder.bool()
					.should( queryBuilder.keyword().wildcard().onField("productname").ignoreFieldBridge().matching("*"+queryString+"*").createQuery() )
					.should( queryBuilder.keyword().wildcard().onField("description").ignoreFieldBridge().matching("*"+queryString+"*").createQuery() )
					.createQuery();

			// wrap Lucene query in a javax.persistence.Query
			org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, ProductsDBBean.class);

			productsDBBeans = fullTextQuery.list();
		}catch(Exception e)
		{
			productsDBBeans = new ArrayList<ProductsDBBean>();
		}

		return productsDBBeans;
	}

}
