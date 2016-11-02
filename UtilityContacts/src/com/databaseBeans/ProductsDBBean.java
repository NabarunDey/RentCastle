package com.databaseBeans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

@Entity
public class ProductsDBBean {

	private int productid;
	private String productname;
	private String producttype;
	private String subproducttype;
	private String username;
	private String quantity;
	private String description;
	private String images;
	private String status;
	private String securitymoney;
	private String productstate;
	private String productcity;
	private String productpin;
	private String approvalStatus;
	private String deliveryCharge;
	

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
    @Id
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
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
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getSecuritymoney() {
		return securitymoney;
	}
	public void setSecuritymoney(String securitymoney) {
		this.securitymoney = securitymoney;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubproducttype() {
		return subproducttype;
	}
	public void setSubproducttype(String subproducttype) {
		this.subproducttype = subproducttype;
	}
	public String getProductstate() {
		return productstate;
	}
	public void setProductstate(String productstate) {
		this.productstate = productstate;
	}
	public String getProductcity() {
		return productcity;
	}
	public void setProductcity(String productcity) {
		this.productcity = productcity;
	}
	public String getProductpin() {
		return productpin;
	}
	public void setProductpin(String productpin) {
		this.productpin = productpin;
	}

	public String getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("ProductName: ").append(this.getProductname()).append(" | Description:").append(this.getDescription()).append(" | ProductType:").append(this.getProducttype()).append(" | SubproductType:").append(this.getSubproducttype());

		return stringBuilder.toString();
	}

}
