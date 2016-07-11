<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<div class="container">
	<div class="main">
		<h1 style="">My Payments</h1>

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
							<td><s:property value="securitymoney" /></td>
							<td><s:property value="rentamount" /></td>
							<td><s:property value="paymentStatus" /></td>
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