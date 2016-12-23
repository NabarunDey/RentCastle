<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentCastle - Services</title>

</head>
<body>


	<div class="container">
		<div class="main">
			<h1 style="">Add Service</h1>
			<form action="addServiceSubmit" method="post">
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Service Name</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name="title" />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile 1</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobile1 />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile 2</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobile2 />
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
					<label class="col-md-4">Description</label>
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

				<div class="col-md-8">
					<label class="col-md-4">Service Type</label>
					<div class="col-md-8">
						<select name="servicetype" class="form-control">
							<option value="BIKESERVICE">Bike Servicing</option>
							<option value="CARSERVICE">Car Servicing</option>
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<div class="col-md-offset-4 col-md-8">
						<s:submit type="button" cssClass="btn btn-primary" theme="simple" />
						<s:reset type="button" cssClass="btn btn-danger" theme="simple" />

					</div>
				</div>
				<br /> <br />
			</form>
		</div>
	</div>

</body>
</html>