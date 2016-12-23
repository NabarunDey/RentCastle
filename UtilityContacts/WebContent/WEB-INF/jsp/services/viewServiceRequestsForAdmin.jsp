<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>RentCastle - Services</title>
<script type="text/javascript" src="js/services/services.js"></script>

</head>
<div class="container">
	<div class="main">
		<br>
		<h1 style="">View Services Request Admin</h1>

		<div class="myservices">
			<table class="table">
				<thead>
					<tr>
						<th>ServiceRequestId</th>
						<th>Service Type</th>
						<th>Service Id</th>
						<th>Customer</th>
						<th>Customer Mobile</th>
						<th>Provider</th>
						<th>Address</th>
						<th>Description</th>
						<th>RentCastleCut</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="context.serviceRequestDBBeans">
						<tr id="serviceRequest<s:property value='servicerequestid'/>">
							<td>SRVRQ00<s:property value="servicerequestid" /></td>
							<td><s:property value="servicetype" /></td>
							<td><s:property value="serviceid" /></td>

							<td><s:property value="customerusername" /></td>
							<td><s:property value="customermobile" /></td>
							<td><s:property value="providerrusername" /></td>

							<td><s:property value="address" />,<br> <s:property
									value="city" />-<s:property value="pin" /></td>
							<td><s:property value="description" /></td>
							<td><s:property value="rentcastlecut" /></td>
							<td><s:select list="{'INITIATED','COMPLETE'}"
									id="%{'status' + #attr['servicerequestid']}"
									headerKey="%{status}" headerValue="%{status}"
									class="form-control" theme="simple">
								</s:select></td>

							<td><input type="button" class="btn btn-primary"
								value="Save"
								onclick="changeServiceRequestStatus(${servicerequestid})" /></td>
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