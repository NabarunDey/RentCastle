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
					<tr id="cart<s:property value='productId'/>" >
						<td><s:property value="productName" /></td>
						<td>Rs. <s:property value="securityMoney" /></td>
						<td>Rs. <s:property value="rentAmount" /></td>
						<td>Rs. </td>
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
			<input type="button" value="Place Order" class="btn-primary" />
				<a href="<s:url action='placeCartOrder'/>" >Confirm Order</a>
			</div>
			
		</div>

	</div>
</div>
</html>
