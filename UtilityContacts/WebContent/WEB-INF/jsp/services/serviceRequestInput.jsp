<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>


	<div class="container">
		<div class="main">
		<br>
			<h1 style="">Request Service</h1>

			<h4>
				Get services at your doorstep.<br />
			</h4>

			<form action="serviceRequestSubmit" method="post">
				<br />
				<div class="col-md-8">
					<label class="col-md-4">Choose the service you need</label>
					<div class="col-md-8">
						<select name="servicetype" class="form-control">
							<option value="BIKESERVICE">Bike Servicing</option>
							<option value="CARSERVICE">Car Servicing</option>
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=customerMobile />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Address</label>
					<div class="col-md-8">
						<textarea class="form-control" name=address></textarea>
					</div>
				</div>
				<br /> <br /> <br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Additional Details regarding the
						service (if any)</label>
					<div class="col-md-8">
						<textarea class="form-control" name=description></textarea>
					</div>
				</div>
				<br /> <br /> <br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">City</label>
					<div class="col-md-8">
						<select name="city" class="form-control">
							<option value="Kolkata">Kolkata</option>
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Pin Code</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=pin />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">Price regarding a particular service
					will be mentioned in the call. You can confirm/decline accordingly.
				</div>
				<br /> <br />
				<div class="col-md-8">
					<div class="col-md-offset-4 col-md-8">

						<s:if
							test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<s:submit type="button" cssClass="btn btn-primary" theme="simple"
								value="Call Me" />
						</s:if>

						<s:else>
							<input type="button" class="btn btn-primary" onclick="alert('Please login to continue.');" 
								value="Call Me" />
						</s:else>
						<s:reset type="button" cssClass="btn btn-danger" theme="simple" />

					</div>
				</div>
				<br /> <br />
			</form>
		</div>
	</div>

</body>
</html>