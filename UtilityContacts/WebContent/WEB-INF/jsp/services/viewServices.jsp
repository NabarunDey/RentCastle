<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<div class="container">
	<div class="main">
		<h1 style="">My Services</h1>

		<div class="myservices">
			<table class="table">
				<thead>
					<tr>
						<th>OrderId</th>
						<th>ProductId</th>
						<th>ProductName</th>
						<th>RentOffer</th>
						<th>Date</th>
						<th>Date</th>
						<th>Status</th>
						<s:if test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }"><th>Address</th></s:if>
						<th>Pin</th>
						<th>Payments</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.orderItems">
						<tr id="order<s:property value='ordersDBBean.orderid'/>">
							<td>ORD00<s:property value="ordersDBBean.orderid" /></td>
							<td>PRD00<s:property value="productsDBBean.productid" /></td>
							<td><s:property value="productsDBBean.productname" /></td>
							<td><s:property value="rentOffersDBBean.periodvalue" /> <s:property value="rentOffersDBBean.periodunit" /> - Rs. <s:property value="rentOffersDBBean.amount" /></td>
							<td><s:property value="ordersDBBean.datetime" /></td>
							<td><s:property value="ordersDBBean.orderstatus" /></td>
							<s:if test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<td><s:property value="ordersDBBean.address" /></td>
							</s:if>
							<td><s:property value="ordersDBBean.pin" /></td>
							<td><a href="getPaymentsForOrder?orderid=${ordersDBBean.orderid }">View Payments</a></td>
							
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
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