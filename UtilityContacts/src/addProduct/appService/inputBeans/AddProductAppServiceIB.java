package addProduct.appService.inputBeans;

import java.util.List;

import com.structures.productTypes.ProductType;
import com.structures.status.ProductStatus;

public class AddProductAppServiceIB {
	
	String productname;
	ProductType producttype;
	String username;
	String quantity;
	List<FileBean> fileBeans;
	ProductStatus status;
	String securitymoney;
	List<String> imageIdsList;
	
	
	
	
	public List<String> getImageIdsList() {
		return imageIdsList;
	}
	public void setImageIdsList(List<String> imageIdsList) {
		this.imageIdsList = imageIdsList;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public ProductType getProducttype() {
		return producttype;
	}
	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSecuritymoney() {
		return securitymoney;
	}
	public void setSecuritymoney(String securitymoney) {
		this.securitymoney = securitymoney;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	public List<FileBean> getFileBeans() {
		return fileBeans;
	}
	public void setFileBeans(List<FileBean> fileBeans) {
		this.fileBeans = fileBeans;
	}
	
	
	



}
