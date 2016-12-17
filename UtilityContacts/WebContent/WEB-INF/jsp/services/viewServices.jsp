<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<div class="container">
	<div class="main">
		<s:if test="context.serviceAdded">
			<h4>
				<br> <img src="images/checkmark.png" width="30" height="30">Service
				added successfully.<br />
			</h4>
		</s:if>
		<br>
		<h1 style="">My Services</h1>

		<div class="myservices">
			<table class="table">
				<thead>
					<tr>
						<th>ServiceId</th>
						<th>Service Type</th>
						<th>Title</th>
						<th>Mobile</th>
						<th>Address</th>
						<th>Description</th>
						<th>ApprovalStatus</th>
						<th>RentCastleCut</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.servicesDBBeans">
						<tr id="service<s:property value='serviceid'/>">
							<td>SRV00<s:property value="serviceid" /></td>
							<td><s:property value="servicetype" /></td>
							<td><s:property value="title" /></td>
							<td><s:property value="mobile1" /><br> <s:property
									value="mobile2" /></td>
							<td><s:property value="address" />,<br> <s:property
									value="city" />-<s:property value="pin" /></td>
							<td><s:property value="description" /></td>
							<td><s:property value="approvalStatus" /></td>
							<td><s:property value="rentcastlecut" /></td>
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