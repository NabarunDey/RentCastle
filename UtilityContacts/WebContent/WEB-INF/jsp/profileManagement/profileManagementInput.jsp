<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div class="main">

			<form action="profileManagementConfirm">
				<br /> <br />

				<div class="col-md-8">
					<label class="col-md-4">First Name</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=firstname />
					</div>
				</div>

				<div class="col-md-8">
					<label class="col-md-4">Last Name</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=lastname />
					</div>
				</div>
				
				
				<div class="sky-form">
					<div class="sky_form1">
						<ul>
							<li><label class="radio left"><input type="radio"
									name="sex" value="Male" checked=""><i></i>Male</label></li>
							<li><label class="radio"><input type="radio"
									name="sex" value="Female"><i></i>Female</label></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div>
					<label> <input name="password" placeholder="password"
						type="password" tabindex="4" required>
					</label>
				</div>
				<div>
					<label> <input placeholder="retype password"
						type="password" tabindex="4" required>
					</label>
				</div>

				<div class="col-md-8">
					<label class="col-md-4">Phone Number</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name="phoneno" />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile 1</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobileno1 />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile 2</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobileno2 />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Address</label>
					<div class="col-md-8">
						<textarea class="form-control" name=address></textarea>
					</div>
				</div>
				<br /> <br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">City</label>
					<div class="col-md-8">
						<select name="city" class="form-control">
							<option value="Kolkata">Kolkata</option>
							<option value="Siliguri">Siliguri</option>
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">State</label>
					<div class="col-md-8">
						<select name="state" class="form-control">
							<option value="West Bengal">West Bengal</option>
							<option value="Assam">Assam</option>
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Pin Code</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobileno2 />
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