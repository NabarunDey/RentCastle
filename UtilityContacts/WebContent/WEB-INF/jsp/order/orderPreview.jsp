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
			<label class="control-label col-md-3"><b>Address</b></label>
		</div>
		<br /> <br />
		<s:hidden name="addressId"
			value="%{context.orderProjectorOB.addressDBBean.addressid}"></s:hidden>

		<div class="col-md-6">
			<label class="control-label col-md-3">Title</label>
			<div class="col-md-9">
				<input name="addressId" type="text" class="form-control" id="title"
					value=<s:property value= "context.orderProjectorOB.addressDBBean.title"/>>
			</div>
		</div>
		<br /> <br />
		<div class="col-md-6">
			<label class="control-label col-md-3">Address</label>
			<div class="col-md-9">
				<input name="address" type="text" class="form-control" id="address"
					value=<s:property value= "context.orderProjectorOB.addressDBBean.address"/>>
			</div>
		</div>
		<br /> <br />
		<div class="col-md-6">
			<label class="control-label col-md-3">State</label>
			<div class="col-md-9">
					<s:select list="{'West Bengal'}"
						headerKey="%{context.orderProjectorOB.addressDBBean.state}"
						headerValue="%{context.orderProjectorOB.addressDBBean.state}"
						id="state" name="state" cssClass="form-control" theme="simple"
						onchange="populateCity()"></s:select>

			</div>
		</div>
		<br /> <br />
		<div class="col-md-6">
			<label class="control-label col-md-3">City</label>
			<div class="col-md-9">

					<s:select list="{'Kolkata','Siliguri'}"
						headerKey="%{context.orderProjectorOB.addressDBBean.city}"
						headerValue="%{context.orderProjectorOB.addressDBBean.city}"
						id="city" name="city" cssClass="form-control" theme="simple"></s:select>
			</div>
		</div>
		<div class="col-md-4">
			<label class="control-label col-md-4">Pincode</label>
			<div class="col-md-8">
				<div class="col-md-8">
					<input name="pin" type="text" class="form-control" id="pin"
						value=<s:property value= "context.orderProjectorOB.addressDBBean.pin"/>>
				</div>
				<div class="col-md-4">
					<input type="button" class="btn btn-primary" value="Check"
						onclick=checkPin() />
				</div>
			</div>
		</div>
		<br /> <br />

		<div class="orders">
			<table class="table">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Security Money</th>
						<th>Rent Amount</th>
						<th>Delivery Charge</th>
						<th>Total Amount</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.orderProjectorOB.cartItems">
						<tr id="cart<s:property value='productId'/>">
							<td><s:property value="productName" />
							<div class="errorProductId<s:property value='productId'/>"
									style="display: none; color: #ff0000;">This item cannot
									be delivered at the given Address.</div>
							<div class="successProductId<s:property value='productId'/>"
									style="display: none; color: #17de69;">Item available in given address.</div>		
									</td>
							<td>Rs. <s:property value="securityMoney" /></td>
							<td>Rs. <s:property value="rentAmount" /></td>
							<td>Rs. <s:property value="deliveryCharge" /></td>
							<td>Rs. <s:property value="itemTotal" /></td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td >&nbsp; <b>Grand Total : <s:property
								value="context.orderProjectorOB.total" /></b>
						</td>
					</tr>
				</tfoot>
			</table>
			<div class="form-group pull-right">
				<input type="button" value="Place Order" class="btn-primary"
					onclick=placeCartOrder() /> <%-- javascript:location.href='placeCartOrder';"--%>
			</div>

		</div>

	</div>
</div>
</html>
