package order;

import order.projector.outputBeans.OrderProjectorOB;




public class OrderAppContext {
	
	private OrderProjectorOB orderProjectorOB;

	public OrderProjectorOB getOrderProjectorOB() {
		return orderProjectorOB;
	}

	public void setOrderProjectorOB(OrderProjectorOB orderProjectorOB) {
		this.orderProjectorOB = orderProjectorOB;
	}
	
	
}
