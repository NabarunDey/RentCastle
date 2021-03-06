package cart.projector.outputBeans;



public class CartItem {

	private int productId;
	private int rentId;
	private String productName;
	private String rentAmount;
	private String periodValue;
	private String periodUnit;
	private String imageUrl;
	private String productState;
	private String productCity;
	private String productPin;
	private String productType;
	private String productSubtype;
	private String securityMoney;
	private String deliveryCharge;
	private boolean deliveryAvailable;
	private String itemTotal;
	
	public String getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(String itemTotal) {
		this.itemTotal = itemTotal;
	}
	public boolean isDeliveryAvailable() {
		return deliveryAvailable;
	}
	public void setDeliveryAvailable(boolean deliveryAvailable) {
		this.deliveryAvailable = deliveryAvailable;
	}
	public String getSecurityMoney() {
		return securityMoney;
	}
	public void setSecurityMoney(String securityMoney) {
		this.securityMoney = securityMoney;
	}
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
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public String getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
}
