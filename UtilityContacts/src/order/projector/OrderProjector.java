package order.projector;

import cart.projector.outputBeans.CartItem;
import order.dao.outputBeans.OrderDaoOB;
import order.projector.outputBeans.OrderProjectorOB;




public class OrderProjector {
	
	public OrderProjectorOB getOrderInput(OrderDaoOB orderDaoOB)
	{
		OrderProjectorOB orderProjectorOB = new OrderProjectorOB();
		orderProjectorOB.setCartItems(orderDaoOB.getCartItems());
		int total= 0;
		for(CartItem cartItem : orderDaoOB.getCartItems())
		{
			total = total + Integer.parseInt(cartItem.getSecurityMoney()) + Integer.parseInt(cartItem.getRentAmount());
		}
			
		orderProjectorOB.setTotal(orderProjectorOB.toString());
		return orderProjectorOB;
	}

}
