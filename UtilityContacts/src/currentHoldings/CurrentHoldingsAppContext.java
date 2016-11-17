package currentHoldings;

import order.appService.inputBeans.Address;
import order.projector.outputBeans.OrderProjectorOB;




public class CurrentHoldingsAppContext {
	
	private OrderProjectorOB orderProjectorOB;
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public OrderProjectorOB getOrderProjectorOB() {
		return orderProjectorOB;
	}

	public void setOrderProjectorOB(OrderProjectorOB orderProjectorOB) {
		this.orderProjectorOB = orderProjectorOB;
	}
	
	
}
