<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.jpg" />
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<script type='text/javascript' src='js/jquery.LoadingBox.js'></script>


<script>
	$(document).ready(function() {
		var lb = new $.LoadingBox({
			loadingImageSrc : "images/default.gif",
		});
		setTimeout(function() {
			lb.close();
		}, 500);
	});
</script>
<title>OAuth Demo</title>
</head>
<body>
	<div style="margin-left: 10px">
		<h1>OAuth Demo</h1>

		<h3>Step 1 : Auth Token Call</h3>

		<div style="margin-left: 50px">
			<h5>Google Auth URL : https://accounts.google.com/o/oauth2/auth</h5>
			<h5>Client_Id Param :
				9688479**********************mqql34gsd4s.apps.googleusercontent.com</h5>
			<h5 style="color: green">
				Response -> Auth Token :
				<s:property value="codeMasked" />
			</h5>
		</div>

		<h3>Step 2 : Access Token Call</h3>

		<div style="margin-left: 50px">
			<h5>Google Access URL :
				https://accounts.google.com/o/oauth2/token</h5>
			<h5>Client_Id Param :
				9688479**********************mqql34gsd4s.apps.googleusercontent.com</h5>
			<h5>Client_Secret Param :
				WUsImF6cCI6Ijk2Ozk1N****************VtNjloajk2aHA5c2ZtcXFs</h5>
			<h5>
				Auth Token Param :
				<s:property value="codeMasked" />
			</h5>
			<h5 style="color: green">
				Response -> Access Token :
				<s:property value="tokenMasked" />
			</h5>
		</div>


		<h3>Step 3 : UserInfo Call</h3>

		<div style="margin-left: 50px">
			<h5>Google Access URL :
				https://www.googleapis.com/oauth2/v1/userinfo</h5>
			<h5>Access_Token Param :
				9688479**********************mqql34gsd4s.apps.googleusercontent.com</h5>
			<h5>Client_Secret Param :
				WUsImF6cCI6Ijk2Ozk1N****************VtNjloajk2aHA5c2ZtcXFs</h5>
			<h5>
				Auth Token Param    :
				<s:property value="tokenMasked" />
			</h5>
			<h5 style="color: green">
				Response -><br>
				 Email_id :
				<s:property value="emailId" /><br>
				Name :
				<s:property value="name" />
			</h5>
		</div>

	</div>




</body>
</html>