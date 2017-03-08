<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>i-Fit - Orders</title>
</head>
<script type="text/javascript" src="js/order/order.js"></script>
<div class="container">
	<div class="main">
		<h1 style="">Orders Admin</h1>

		<div class="ordersAdmin">
			<table class="table">
				<thead>
					<tr>
						<th>OrderId</th>
						<th>ProductId</th>
						<th>ProductName</th>
						<th>RentOffer</th>
						<th>Date</th>
						<th>Status</th>
						<th>Address</th>
						<th>Pin</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.orderItems">
						<tr>
							<td>ORD00<s:property value="ordersDBBean.orderid" /></td>
							<td>PRD00<s:property value="productsDBBean.productid" /></td>
							<td><s:property value="productsDBBean.productname" /></td>
							<td><s:property value="rentOffersDBBean.periodvalue" /> <s:property value="rentOffersDBBean.periodunit" /> - Rs. <s:property value="rentOffersDBBean.amount" /></td>
							<td><s:property value="ordersDBBean.datetime" /></td>
							<td><s:select list="{'INITIATED','PROCESSING','COMPLETE'}"
									id="%{'orderstatus' + #attr['ordersDBBean.orderid']}"
									headerKey="%{ordersDBBean.orderstatus}"
									headerValue="%{ordersDBBean.orderstatus}" class="form-control"
									theme="simple">
								</s:select></td>
							<td><s:property value="ordersDBBean.address" /></td>
							<td><s:property value="ordersDBBean.pin" /></td>
							<td><input type="button" class="btn btn-primary"
								value="Save"
								onclick="changeOrderStatus(${ordersDBBean.orderid})" /></td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td style="color: #ff0000;">&nbsp;</td>
					</tr>
				</tfoot>
			</table>

		</div>

	</div>

</div>
</html>