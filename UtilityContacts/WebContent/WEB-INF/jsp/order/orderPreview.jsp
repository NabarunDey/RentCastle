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
		<div class="col-md-6">
			<label class="control-label col-md-3"><b>Enter Address</b></label>
		</div>
		<br/><br/>
		<div class="col-md-6">
			<label class="control-label col-md-3">Line 1</label>
			<div class="col-md-9">
				<input type="text" class="form-control" id="title"/>
			</div>
		</div>
		<br/><br/>
		<div class="col-md-6">
			<label class="control-label col-md-3">Line 2</label>
			<div class="col-md-9">
				<input type="text"  class="form-control"  id="address"/>
			</div>
		</div>
		<br/><br/>
		<div class="col-md-6">
			<label class="control-label col-md-3">State</label>
			<div class="col-md-9">
				<select id="state" class="form-control" onchange="populateCity()">
			<option value="West Bengal">West Bengal</option>
			<option value="Assam">Assam</option>
		</select>
			</div>
		</div>
		<br/><br/>
		<div class="col-md-6">
			<label class="control-label col-md-3">City</label>
			<div class="col-md-9">
				<select id="city" class="form-control">
			<option value="Kolkata">Kolkata</option>
			<option value="Siliguri">Siliguri</option>
		</select>
			</div>
		</div>
		<div class="col-md-4">
			<label class="control-label col-md-4">Pincode</label>
			<div class="col-md-8">
				<div class="col-md-8">
					<s:textfield id="pin" cssClass="form-control"></s:textfield>
				</div>
				<div class="col-md-4">
					<input type="button" class="btn btn-primary" value="Check" onclick=checkPin() />
				</div>
				
				
			</div>
		</div>
		<br/><br/>
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
