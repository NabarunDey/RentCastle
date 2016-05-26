
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="top_bg">
		<div class="container">
			<div class="header_top">
				<div class="top_left">
					<h2>
						<a href="#">50%off</a> use coupon code "big61" and get extra 33%
						off on orders above rs 2,229
					</h2>
				</div>
				<div class="top_right">
					<ul>
						<li><a href="<s:url  action='addProductInput'/>">Add Product</a></li>
						<li><a href="#">Recently viewed</a></li>|
						<li><a href="contact.html">Contact</a></li> |
						<li class="login">
							<div id="loginContainer">
								<a href="#" id="loginButton"><span>Login</span></a>
								<div id="loginBox">
									<form id="loginForm" >
										<fieldset id="body">
											<fieldset>
												<label for="email">Email Address</label> 
												<input type="text" name="username" id="email">
											</fieldset>
											<fieldset>
												<label for="password">Password</label>
												<input type="password" name="password" id="password">
											</fieldset>
											<input  id="login" value="Sign in" onclick="doAjaxPost()">
											 <label
												for="checkbox"><input type="checkbox" id="checkbox">
												<i>Remember me</i></label>
										</fieldset>
										<span><a href="#">Forgot your password?</a></span>
									</form>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

</body>
</html>