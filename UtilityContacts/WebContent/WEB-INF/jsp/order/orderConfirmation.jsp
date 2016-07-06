<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/order/order.js"></script>
<div class="container">
	<div class="main">
		<div class="shoping_bag">
			<h4>
				<img src="images/checkmark.png" width="30" height="30">Thank You for placing order.	Your Order Ids are below.<br />

				<s:iterator value="context.orderProjectorOB.orderItems">
					<div style="padding-left:35px;"> ORD00<s:property value="ordersDBBean.orderid" /><br/></div>
				</s:iterator>
			</h4>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
</html>