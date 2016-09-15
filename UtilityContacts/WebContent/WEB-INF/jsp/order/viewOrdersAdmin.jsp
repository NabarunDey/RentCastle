<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/order/order.js"></script>
<div class="container">
	<div class="main">
		<h1 style="">Orders Admin</h1>

		<div class="ordersAdmin">
			<table class="table">
				<thead>
					<tr>
						<th>OrderId</th>
						<th>Date</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.orderItems">
						<tr >
							<td>ORD00<s:property value="ordersDBBean.orderid" /></td>
							<td><s:property value="ordersDBBean.datetime" /></td>
							<td>
								<s:select list="{'INITIATED','PROCESSING','COMPLETE'}" id="%{'orderstatus' + #attr['ordersDBBean.orderid']}"   headerKey="%{ordersDBBean.orderstatus}" headerValue="%{ordersDBBean.orderstatus}" class="form-control" theme="simple"> 
								</s:select>
								</td>
							<td><input type="button" class="btn btn-primary" value="Save" onclick="changeOrderStatus(${ordersDBBean.orderid})"/></td>
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