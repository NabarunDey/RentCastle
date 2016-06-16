package addToCart.appService;

import com.dao.UsersDao;

import addToCart.projector.outputBeans.AddToCartProjectorOB;


/**
 * @author nd29794
 *
 */
public class AddToCartAppService {
	
	AddToCartProjectorOB addToCartProjectorOB;
	UsersDao usersDao;
	public AddToCartProjectorOB getAddToCartProjectorOB() {
		return addToCartProjectorOB;
	}
	public void setAddToCartProjectorOB(AddToCartProjectorOB addToCartProjectorOB) {
		this.addToCartProjectorOB = addToCartProjectorOB;
	}
	public UsersDao getUsersDao() {
		return usersDao;
	}
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	
}
