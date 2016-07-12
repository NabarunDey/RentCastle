<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/order/order.js"></script>
<div class="container">


	<div class="main">
		<div class="shoping_bag">
			<h4>
				<img src="images/bag1.png">Order Preview
			</h4>
			<div class="clearfix"></div>
		</div>
		<s:textarea id="address"></s:textarea>
		<select id="state" cssClass="form-control" onchange="populateCity()">
			<option value="West Bengal">West Bengal</option>
			<option value="Assam">Assam</option>
		</select> <select id="city" cssClass="form-control">
			<option value="Kolkata">Kolkata</option>
			<option value="Siliguri">Siliguri</option>
		</select>
		<s:textfield id="pin"></s:textfield>
		<input type="button" value="Check" onclick=checkPin() />
		<div class="orders">
			<table class="table">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Security Money</th>
						<th>Rent Amount</th>
						<th>Total Amount</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.cartItems">
						<tr id="cart<s:property value='productId'/>">
							<td><s:property value="productName" /></td>
							<td>Rs. <s:property value="securityMoney" /></td>
							<td>Rs. <s:property value="rentAmount" /></td>
							<td>Rs.</td>
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
			<div class="form-group pull-right">
				<input type="button" value="Place Order" class="btn-primary"
					onclick="javascript:location.href='placeCartOrder.action';" />
			</div>

		</div>

	</div>
</div>
</html>
