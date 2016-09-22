<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="/Struts2Example/struts/xhtml/styles.css"
	type="text/css" />
</head>
<body>



	<div class="container">
		<div class="main">
			<!-- start registration -->
			<div class="registration">
				<div class="registration_left">
					<h2>
						new user? <span> create a shoppe account </span>
					</h2>
					
					<!-- [if IE] 
		    < link rel='stylesheet' type='text/css' href='ie.css'/>  
		 [endif] -->

					<!-- [if lt IE 7]>  
		    < link rel='stylesheet' type='text/css' href='ie6.css'/>  
		<! [endif] -->
					<script>
						(function() {

							// Create input element for testing
							var inputs = document.createElement('input');

							// Create the supports object
							var supports = {};

							supports.autofocus = 'autofocus' in inputs;
							supports.required = 'required' in inputs;
							supports.placeholder = 'placeholder' in inputs;

							// Fallback for autofocus attribute
							if (!supports.autofocus) {

							}

							// Fallback for required attribute
							if (!supports.required) {

							}

							// Fallback for placeholder attribute
							if (!supports.placeholder) {

							}

							// Change text inside send button on submit
							var send = document
									.getElementById('register-submit');
							if (send) {
								send.onclick = function() {
									this.innerHTML = '...Sending';
								}
							}

						})();
					</script>
					<div class="registration_form">
						<!-- Form -->
						<form id="registration_form"
							action="userRegistrationAdditionalInfo" method="post">
							<div>
								<label> <input name="firstname"
									placeholder="first name:" type="text" tabindex="1" required
									autofocus>
								</label>
							</div>
							<div>
								<label> <input name="lastname" placeholder="last name:"
									type="text" tabindex="2" required autofocus>
								</label>
							</div>
							<div>
								<label> <input name="username"
									placeholder="email address:" type="email" tabindex="3" required>
								</label>
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
							<div>
								<label> <s:select label="User Type" headerKey="-1"
										list="#{'USERTYPE':'Select User Type','CUSTOMER':'Customer', 'VENDOR':'Vendor'}"
										name="usertype" value="#{'usertype'}" />
								</label>
							</div>
							<div>
								<input type="submit" value="create an account"
									id="register-submit">
							</div>
							<div class="sky-form">
								<label class="checkbox"><input type="checkbox"
									name="checkbox"><i></i>i agree to shoppe.com &nbsp;<a
									class="terms" href="#"> terms of service</a> </label>
							</div>
						</form>
						<!-- /Form -->
					</div>
				</div>
				<div class="registration_left">
					<h2>existing user</h2>
					<a
						href="http://www.facebook.com/dialog/oauth?client_id=841162669353192&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunction&scope=email">
						<div class="reg_fb">
							<img src="images/facebook.png" alt=""><i>sign in using
								Facebook</i>
							<div class="clear"></div>
						</div>
					</a>
					<div class="registration_form">
						<!-- Form -->
						<form id="registration_form" action="contact.php" method="post">
							<div>
								<label> <input placeholder="email:" type="email"
									tabindex="3" required>
								</label>
							</div>
							<div>
								<label> <input placeholder="password" type="password"
									tabindex="4" required>
								</label>
							</div>
							<div>
								<input type="submit" value="sign in" id="register-submit">
							</div>
							<div class="forget">
								<a href="#">forgot your password</a>
							</div>
						</form>
						<!-- /Form -->
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- end registration -->
		</div>
	</div>




</body>
</html>