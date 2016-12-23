<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>RentCastle - Payments</title>
</head>
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
						<th>Delivery Charges</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.paymentProjectorOB.paymentsDBBeans">
						<tr id="payment<s:property value='paymentid'/>">
							<td>PMT00<s:property value="paymentid" /></td>
							<td>ORD00<s:property value="orderid" /></td>
							<td>
							<s:if test="%{ null != #attr.userProfile && fromusername.equalsIgnoreCase(#attr.userProfile.userName) }">
							Me
							</s:if>
							<s:else>
							RentCastle
							</s:else>
							</td>
							<td><s:if test="%{ null != #attr.userProfile && tousername.equalsIgnoreCase(#attr.userProfile.userName) }">
							Me
							</s:if>
							<s:else>
							RentCastle
							</s:else>
							</td>
							<td><s:property value="datetime" /></td>
							<td><s:property value="securitymoney" /></td>
							<td><s:property value="rentamount" /></td>
							<td><s:property value="deliveryCharge" /></td>
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