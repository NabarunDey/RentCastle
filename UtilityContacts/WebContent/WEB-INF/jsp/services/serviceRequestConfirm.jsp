<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>RentCastle - Services</title>
</head>
<div class="container">
	<div class="main">
	<br>
			<h4>
				<img src="images/checkmark.png" width="30" height="30">Thank
				You for placing request. You will soon get a call from our team.<br />
				Service Request Id SRVRQ00
				<s:property value="context.serviceReqId" />
				<br />
			</h4>
	</div>
	<div class="clearfix"></div>
</div>
</html>