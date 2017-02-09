<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a target="_top"
				href="https://accounts.google.com/o/oauth2/auth?scope=email&response_type=code&client_id=968847956660-7cs0n3ke5m69hj96hp9sfmqql34gsd4s.apps.googleusercontent.com&approval_prompt=auto&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunctionStep1">
				<input type="button" value="Proceed" theme="simple"
				cssClass="form-control btn btn-success" />
			</a>

		</div>


	</div>


</body>
</html>