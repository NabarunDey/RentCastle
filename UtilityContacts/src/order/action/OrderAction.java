package order.action;

import order.OrderAppContext;
import order.appService.OrderAppService;
import order.projector.outputBeans.OrderProjectorOB;



public class OrderAction   {
	
	OrderAppService orderAppService;
	OrderAppContext context;
	
	public String getOrderInput()
	{
		OrderProjectorOB orderProjectorOB = orderAppService.getCartOrderInput();
		context.setOrderProjectorOB(orderProjectorOB);
		return "success";
	}

	public OrderAppService getOrderAppService() {
		return orderAppService;
	}

	public void setOrderAppService(OrderAppService orderAppService) {
		this.orderAppService = orderAppService;
	}

	public OrderAppContext getContext() {
		return context;
	}

	public void setContext(OrderAppContext context) {
		this.context = context;
	}

}
