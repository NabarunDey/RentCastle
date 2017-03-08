<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>i-Fit - Services</title>
<script type="text/javascript" src="js/services/services.js"></script>

</head>
<div class="container">
	<div class="main">
		<br>
		<h1 style="">View Services Admin</h1>

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
						<th>i-FitCut</th>
						<th>ApprovalStatus</th>
						<th>Action</th>
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
							<td><s:property value="i-Fitcut" /></td>
							<td><s:select list="{'PENDING','APPROVED','DELETED'}"
									id="%{'approvalStatus' + #attr['serviceid']}"
									headerKey="%{approvalStatus}" headerValue="%{approvalStatus}"
									class="form-control" theme="simple">
								</s:select></td>

							<td><input type="button" class="btn btn-primary"
								value="Save"
								onclick="changeApprovalStatus(${serviceid})" /></td>
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