package addProduct.appService;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import addProduct.appService.inputBeans.AddProductAppServiceIB;
import addProduct.dao.outputBeans.AddProductDaoOB;
import addProduct.projector.AddProductProjector;
import addProduct.projector.outputBeans.AddProductProjectorOB;

import com.dao.ProductsDao;
import com.sessionBeans.UserProfile;
import com.structures.userTypes.UserType;
import com.util.ApplicationContextProvider;


public class AddProductAppService {

	private AddProductProjector addProductProjector;
	private ProductsDao productsDao;

	public AddProductProjectorOB getInputDetails(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB = null;
		UserProfile userProfile = null;
		try{
			
			ApplicationContextProvider appContext = new ApplicationContextProvider();
			userProfile = appContext.getApplicationContext().getBean("userProfile", UserProfile.class);
			
			if(UserType.VENDOR.equals(userProfile.getUserType()))
			{
				addProductProjectorOB = addProductProjector.getAddProductInput(addProductAppServiceIB);
			}
		}catch(Exception exception)
		{

		}
		return addProductProjectorOB;
	}

	public AddProductProjectorOB getRecapDetails(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductProjectorOB addProductProjectorOB =new AddProductProjectorOB();
		String contextPath =  ServletActionContext.getServletContext().getRealPath("/images") ;
		 File destFile  = new File(contextPath+"images", "abcd.jpg");
    	 try {
			FileUtils.copyFile(addProductAppServiceIB.getFileBeans().get(0).getFile(), destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return addProductProjectorOB;
	}

	public AddProductProjectorOB addProduct(AddProductAppServiceIB addProductAppServiceIB)
	{
		AddProductDaoOB addProductDaoOB = productsDao.addProduct(addProductAppServiceIB);
		AddProductProjectorOB addProductProjectorOB =null;
		return addProductProjectorOB;
	}




	public AddProductProjector getAddProductProjector() {
		return addProductProjector;
	}
	public void setAddProductProjector(AddProductProjector addProductProjector) {
		this.addProductProjector = addProductProjector;
	}

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}



}
