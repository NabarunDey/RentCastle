package currentHoldings.appService.inputBeans;




public class CurrentHoldingsAppServiceIB {
	
	private String currentHoldinsId;
	private String username;
	private int orderid;
	private int productid;
	private int rentOfferid;
	private String itemreceiveddate;
	private String rentexpirydate;
	private String status;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getRentOfferid() {
		return rentOfferid;
	}
	public void setRentOfferid(int rentOfferid) {
		this.rentOfferid = rentOfferid;
	}
	public String getItemreceiveddate() {
		return itemreceiveddate;
	}
	public void setItemreceiveddate(String itemreceiveddate) {
		this.itemreceiveddate = itemreceiveddate;
	}
	public String getRentexpirydate() {
		return rentexpirydate;
	}
	public void setRentexpirydate(String rentexpirydate) {
		this.rentexpirydate = rentexpirydate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentHoldinsId() {
		return currentHoldinsId;
	}
	public void setCurrentHoldinsId(String currentHoldinsId) {
		this.currentHoldinsId = currentHoldinsId;
	}
	
}
