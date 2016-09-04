<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/payment/payment.js"></script>

<div class="container">
	<div class="main">
		<h1 style="">Admin Payments</h1>

		<div class="orders">
			<table class="table">
				<thead>
					<tr>
						<th>PaymentId</th>
						<th>OrderId</th>
						<th>From</th>
						<th>To</th>
						<th>Date</th>
						<th>SecurityMoney</th>
						<th>Rent Amount</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.paymentProjectorOB.paymentsDBBeans">
						<tr id="payment<s:property value='paymentid'/>">
							<td>PMT00<s:property value="paymentid" /></td>
							<td><s:property value="orderid" /></td>
							<td><s:property value="fromusername" /></td>
							<td><s:property value="tousername" /></td>
							<td><s:property value="datetime" /></td>
							<td>Rs. <s:property value="securitymoney" /></td>
							<td>Rs. <s:property value="rentamount" /></td>
							<td><select id="paymentstatus${paymentid}"
								class="form-control">
									<option value="PENDING">PENDING</option>
									<option value="COMPLETED">COMPLETED</option>
									<option value="UPCOMING">UPCOMING</option>
							</select></td>
							<td><input type="button" class="btn btn-primary"
								value="Save"
								onclick="changePaymentStatus(${paymentid})" /></td>

						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
						<td colspan=7>&nbsp;</td>
						<td style="color: #ff0000;">&nbsp;</td>
					</tr>
				</tfoot>
			</table>

		</div>
	</div>

</div>
</html>