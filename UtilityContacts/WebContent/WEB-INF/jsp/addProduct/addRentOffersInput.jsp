<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Rent Offer</title>

</head>
<body>
	<div class="container">
		<div class="main">Please add rent details</div>
		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" action="addRentOffersSubmit">
			<s:submit type="button" name="submit" theme="simple"
				cssClass="form-control btn btn-success" />
		</form>

	</div>
</body>
</html>