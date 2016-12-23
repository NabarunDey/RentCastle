<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentCastle - User Registration</title>
</head>
<body>



	<div class="container">
		<div class="main">
			<!-- start registration -->
			<div class="registration">
				<div class="registration_left">
					<h2>
						new user? <span> create a rentcastle account </span>
					</h2>

					<div class="registration_form">
						<!-- Form -->
						<s:form id="registration_form"
							action="userRegistrationAdditionalInfo" method="post"
							validate="true" theme="simple">
							<div>
								<s:textfield name="firstname" id="firstname"
									placeholder="first name:" type="text" tabindex="1">
								</s:textfield>
								<s:fielderror fieldName="firstname"></s:fielderror>
							</div>
							<div>
								<s:textfield name="lastname" id="lastname"
									placeholder="last name:" type="text" tabindex="2">
								</s:textfield>
								<s:fielderror fieldName="lastname"></s:fielderror>
							</div>
							<div>
								<s:textfield name="username" id="username"
									placeholder="email address:" type="email" tabindex="3">
								</s:textfield>
								<s:fielderror fieldName="username"></s:fielderror>

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
								<s:textfield name="password" placeholder="password"
									type="password" tabindex="4">
								</s:textfield>
							</div>
							<div>
								<s:textfield placeholder="retype password" type="password"
									name="cnfPassword" tabindex="4" id ="cnfPassword">
								</s:textfield>
								<s:fielderror fieldName="cnfPassword"></s:fielderror>
							</div>
							<div>
								<label> <s:select label="User Type" headerKey="-1"
										list="#{'USERTYPE':'Select User Type','CUSTOMER':'Customer', 'VENDOR':'Vendor','SERVICEPROVIDER':'Service Provider'}"
										name="usertype" value="#{'usertype'}" id="usertype" />
								</label>
								<s:fielderror fieldName="usertype"></s:fielderror>
							</div>
							<div>
								<input type="submit" value="create an account"
									id="register-submit">
							</div>
							<div class="sky-form">
								<label class="checkbox"><input type="checkbox"
									name="checkbox"><i></i>i agree to rentcastle.in &nbsp;<a
									class="terms" href="#"> terms of service</a> </label>
							</div>
						</s:form>
						<!-- /Form -->
					</div>
				</div>
				<div class="registration_left">
					<h2>existing user</h2>
					<a target="_top"
						href="http://www.facebook.com/dialog/oauth?client_id=841162669353192&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunction&scope=email">
						<div class="reg_fb">
							<img src="images/facebook.png" alt=""><i>sign in using
								Facebook</i>
							<div class="clear"></div>
						</div>
					</a>
				</div>
				<div class="registration_left">
					<a target="_top"
						href="https://accounts.google.com/o/oauth2/auth?scope=email&response_type=code&client_id=968847956660-7cs0n3ke5m69hj96hp9sfmqql34gsd4s.apps.googleusercontent.com&approval_prompt=auto&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunctionGoogle">
						<img src="images/google-plus-sign-in.jpg" alt=""
						style="width: 508px; height: 50px">
						<div class="clear"></div>
					</a>
				</div>
				<div class="clearfix"></div>
			</div>

		</div>
	</div>




</body>
</html>