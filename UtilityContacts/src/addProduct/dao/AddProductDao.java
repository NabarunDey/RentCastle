package addProduct.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;

import com.databaseBeans.ProductsDBBean;
import com.util.CommonUtility;

public class AddProductDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	public void saveContacts(ProductsDBBean productsDBBean){  
	    template.save(productsDBBean);  
	}  
	public void updateContacts(ProductsDBBean productsDBBean){  
	    template.update(productsDBBean);  
	}  
	public void deleteContacts(ProductsDBBean productsDBBean){  
	    template.delete(productsDBBean);  
	}  
		
	
	public AddProductDaoOB addProduct(
			AddProductAppServiceIB addProductAppServiceIB) {

		ProductsDBBean productsDBBean = new  ProductsDBBean();
		CommonUtility.copyBean(addProductAppServiceIB, productsDBBean);
		
		
		saveContacts(productsDBBean);
		AddProductDaoOB addProductDaoOB =new AddProductDaoOB();
		return addProductDaoOB;
	}

}
