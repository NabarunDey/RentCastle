package viewProduct.appService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import viewProduct.appService.inputBeans.ViewProductAppServiceIB;
import viewProduct.projector.ViewProductProjector;
import viewProduct.projector.outputBeans.ViewProductProjectorOB;

import com.dao.ImagesDao;
import com.dao.ProductsDao;
import com.dao.RentOffersDao;
import com.databaseBeans.ImagesDBBean;
import com.databaseBeans.ProductsDBBean;
import com.databaseBeans.RentOffersDBBean;



/**
 * @author nd29794
 *
 */
public class ViewProductAppService {
	
	ProductsDao productsDao;
	RentOffersDao rentOffersDao;
	ImagesDao imagesDao;
	ViewProductProjector viewProductProjector;
	
	public ViewProductProjectorOB viewProduct(ViewProductAppServiceIB viewProductAppServiceIB) {

		ProductsDBBean productsDBBean = productsDao.getProductDetails(viewProductAppServiceIB.getProductId());
		List<RentOffersDBBean> rentOffersDBBeans =rentOffersDao.getAllRentOffersForProduct(viewProductAppServiceIB.getProductId());
		String images = productsDBBean.getImages();
		if(StringUtils.isNotEmpty(images))
		{
			String[] imagesArray= images.split("\\|");
			List<String> imagesList = new ArrayList<String>(Arrays.asList(imagesArray));
			List<ImagesDBBean> imagesDBBeans = imagesDao.getImagesByIdList(imagesList);
			viewProductAppServiceIB.setImagesDBBeans(imagesDBBeans);
		}
		viewProductAppServiceIB.setProductsDBBean(productsDBBean);
		viewProductAppServiceIB.setRentOffersDBBeans(rentOffersDBBeans);
		ViewProductProjectorOB viewProductProjectorOB = viewProductProjector.viewProduct(viewProductAppServiceIB);
		return viewProductProjectorOB;

	}

	public ProductsDao getProductsDao() {
		return productsDao;
	}

	public void setProductsDao(ProductsDao productsDao) {
		this.productsDao = productsDao;
	}

	public RentOffersDao getRentOffersDao() {
		return rentOffersDao;
	}

	public void setRentOffersDao(RentOffersDao rentOffersDao) {
		this.rentOffersDao = rentOffersDao;
	}

	public ViewProductProjector getViewProductProjector() {
		return viewProductProjector;
	}

	public void setViewProductProjector(ViewProductProjector viewProductProjector) {
		this.viewProductProjector = viewProductProjector;
	}

	public ImagesDao getImagesDao() {
		return imagesDao;
	}

	public void setImagesDao(ImagesDao imagesDao) {
		this.imagesDao = imagesDao;
	}
	
	
	
}
