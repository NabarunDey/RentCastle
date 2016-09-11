<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<div class="container">
	<div class="main">
		<h1 style="">My Orders</h1>

		<div class="orders">
			<table class="table">
				<thead>
					<tr>
						<th>OrderId</th>
						<th>Date</th>
						<th>Status</th>
						<th>Payments</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.orderItems">
						<tr id="order<s:property value='ordersDBBean.orderid'/>">
							<td>ORD00<s:property value="ordersDBBean.orderid" /></td>
							<td><s:property value="ordersDBBean.datetime" /></td>
							<td><s:property value="ordersDBBean.orderstatus" /></td>
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