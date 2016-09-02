<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
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
							<td>
								<select id="%{'status' + ordersDBBean.orderid}" class="form-control"> 
									<option value="INITIATED">INITIATED</option>
									<option value="PROCESSING">PROCESSING</option>
									<option value="COMPLETE">COMPLETE</option>
								</select>
							</td>
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