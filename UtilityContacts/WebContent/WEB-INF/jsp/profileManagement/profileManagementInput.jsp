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

			<form action="profileManagementConfirm" class="basic-grey">
				<br /> <br />

				<div class="col-md-8">
					<label class="col-md-4">First Name</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=firstname
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.firstname'/>" />
					</div>
				</div>

				<div class="col-md-8">
					<label class="col-md-4">Last Name</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=lastname
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.lastname'/>" />
					</div>
				</div>


				<div class="col-md-8">
					<label class="col-md-4">Gender : </label>
					<div class="col-md-8">
						<ul>
							<li><label class="radio left"><input type="radio"
									name="sex" value="Male" checked=""><i></i>Male</label></li>
							<li><label class="radio"><input type="radio"
									name="sex" value="Female"><i></i>Female</label></li>
						</ul>
					</div>
				</div>


				<s:if
					test="%{ null == context.profileManagementProjectorOB.usersDBBean.email || ''.equalsIgnoreCase(context.profileManagementProjectorOB.usersDBBean.email) }">


					<div class="col-md-8">
						<label class="col-md-4">Email : </label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="email" />
						</div>
					</div>
					<br />
					<br />
				</s:if>


				<div class="col-md-8">
					<label class="col-md-4">Phone Number</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name="phoneno"
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.phoneno'/>" />
					</div>
				</div>
				<br /> <br />

				<div class="col-md-8">
					<label class="col-md-4">Mobile 1</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobileno1
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.mobileno1'/>" />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Mobile 2</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=mobileno2
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.mobileno2'/>" />
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Address</label>
					<div class="col-md-8">
						<textarea class="form-control" name=address><s:property
								value='context.profileManagementProjectorOB.usersDBBean.address' /></textarea>
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
						</select>
					</div>
				</div>
				<br /> <br />
				<div class="col-md-8">
					<label class="col-md-4">Pin Code</label>
					<div class="col-md-8">
						<input type="text" class="form-control" name=pinno
							value="<s:property value = 'context.profileManagementProjectorOB.usersDBBean.pinno'/>" />
					</div>
				</div>
				<div class="col-md-8">
					<br />

					<div class="col-md-offset-4 col-md-8">
						<s:submit type="button" cssClass="btn btn-primary" theme="simple" />
						<s:reset type="button" cssClass="btn btn-danger" theme="simple" />

					</div>
				</div>
				<br /> <br />
			</form>

			<form action="changePasswordSubmit" class="basic-grey">
			
			<div class="col-md-8">
				<br> <br>

				<div class="line-separator"></div>
				<br> <label class="col-md-4">Password :</label>
				<div class="col-md-8">
					<input type="password" class="form-control" name=password
						value="<s:property value = 'context.profileManagementProjectorOB.userLoginDBBean.password'/>" />
				</div>
			</div>
			<div class="col-md-8">
				<label class="col-md-4">Retype Password :</label>
				<div class="col-md-8">
					<input type="password" class="form-control" name=retypepassword
						value="<s:property value = 'context.profileManagementProjectorOB.userLoginDBBean.password'/>" />
				</div>
			</div>

			<div class="col-md-8">
				<br />
				<div class="col-md-offset-4 col-md-8">
					<s:submit type="button" cssClass="btn btn-primary" theme="simple" />
					<s:reset type="button" cssClass="btn btn-danger" theme="simple" />

				</div>
			</div>
			</form>

		</div>
	</div>

</body>
</html>