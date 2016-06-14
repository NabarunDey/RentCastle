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
		<div class="header_top" >
			<h3 class="text-center">Please add rent details</h3>
		</div>
		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" action="addRentOffersSubmit">
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Period Unit</label>
				<div class="col-sm-4">
					<s:select list="{'Days','Months','Years'}" name ="periodunit" cssClass="form-control"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Period Value</label>
				<div class="col-sm-4">
					<s:textfield name = "periodvalue" cssClass="form-control"></s:textfield>
				</div>
			</div>
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Rent Amount</label>
				<div class="col-sm-4">
					<s:textfield name = "rentAmount" cssClass="form-control"></s:textfield>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-2">
					<s:submit type="button" name="submit" theme="simple"
				cssClass="btn btn-success btn-md" />
				</div>
			</div>
			
			
		</form>

	</div>
</body>
</html>