<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="/Struts2Example/struts/xhtml/styles.css" type="text/css"/> 
</head>
<body>


<div class="container">
<div class="main">
</div>
</div>

<form action="userRegistrationConfirm">
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">Phone Number</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name="phoneno" />
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">Mobile 1</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name=mobileno1 />
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">Mobile 2</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name=mobileno2 />
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">Address</label>
	<div class="col-md-8">
		<textarea class="form-control" name=address></textarea>
	</div>
</div>
<br/><br/><br/>
<div class="col-md-8">
	<label class="col-md-4">City</label>
	<div class="col-md-8">
		<select name="city" class="form-control">
			<option value="Kolkata">Kolkata</option>
			<option value="Siliguri">Siliguri</option>
		</select>	
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">State</label>
	<div class="col-md-8">
		<select name="state" class="form-control">
			<option value="West Bengal">West Bengal</option>
			<option value="Assam">Assam</option>
		</select>
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<label class="col-md-4">Pin Code</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name=pinno />
	</div>
</div>
<br/><br/>
<div class="col-md-8">
	<div class="col-md-offset-4 col-md-8">
		<s:submit type="button" cssClass="btn btn-primary" theme="simple" /> 
		<s:reset type="button"  cssClass="btn btn-danger" theme="simple" />
		
	</div>
</div>
<br/><br/>
</form>


</body>
</html>