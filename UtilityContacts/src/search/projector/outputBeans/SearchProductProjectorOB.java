package search.projector.outputBeans;
import com.google.gson.Gson;


public class SearchProductProjectorOB {

	private int productId;
	private String productName;
	private String rentAmount;
	private String periodValue;
	private String periodUnit;
	private String imageUrl;
	private String userName;
	private String productState;
	private String productCity;
	private String productPin;
	private String productType;
	private String productSubtype;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getPeriodValue() {
		return periodValue;
	}
	public void setPeriodValue(String periodValue) {
		this.periodValue = periodValue;
	}
	public String getPeriodUnit() {
		return periodUnit;
	}
	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getProductState() {
		return productState;
	}
	public void setProductState(String productState) {
		this.productState = productState;
	}
	public String getProductCity() {
		return productCity;
	}
	public void setProductCity(String productCity) {
		this.productCity = productCity;
	}
	public String getProductPin() {
		return productPin;
	}
	public void setProductPin(String productPin) {
		this.productPin = productPin;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductSubtype() {
		return productSubtype;
	}
	public void setProductSubtype(String productSubtype) {
		this.productSubtype = productSubtype;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getProductJson(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
