<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>i-Fit - Forgot Password</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div class="main">
			<!-- start registration -->
			<div class="registration">
				<div class="registration_left">
					<div class="registration_form">
						<h1>Forgot Password</h1>
						<!-- Form -->
						<form id="ForgotPassword_form" method="post">
							<div>Enter Email Id
								<label> <input placeholder="email:" type="email" 	name="username"
									tabindex="3" required>
								</label>
							</div>

							<div>
								<input type="button" value="Submit" id="register-submit" onclick=forgotPasswordSubmit()>
							</div>
							<div id="errorUserNotExist"
									style="display: none; color: #ff0000;">User doesnot exist.</div>
							<div id="errorMailNotSent"
									style="display: none; color: #ff0000;">Mail cannot be sent to the user. Contact Support team.</div>
							<div id="successForgotPassword"
									style="display: none; color: #17de69;">Email has been sent successfully</div>
						</form>
						<!-- /Form -->
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>