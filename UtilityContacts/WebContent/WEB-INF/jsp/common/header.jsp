
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>


	<div class="top_bg">
		<div class="container">
			<div class="header_top">
				<div class="top_left">
					<h2>
						<a href="<s:url  action='helpInput'/>">Contact Us</a> for any
						queries and suggestions.
					</h2>
				</div>
				<div class="top_right">
					<ul class="dropdown">

						<s:if
							test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) }">


							<li class="drop"><a href="#">My Places</a>
								<ul class="sub_menu">
									<li><a href="<s:url action='addPlacesInput'/>">Add
											Place</a></li>
									<li><a href="<s:url action='myPlaces'/>">My Places</a></li>
								</ul></li>
							<%--
							<li class="drop"><a href="#">Orders</a>
								<ul class="sub_menu">
									<li><a href="<s:url action='viewOrdersVendor'/>">Order
											History</a></li>
									<li><a href="<s:url  action='getPaymentsForUser'/>">Payment
											History</a></li>
									<li><a
										href="<s:url  action='viewMyCurrentHoldingsVendor'/>">My
											Holdings</a></li>

								</ul></li>
								--%>
						</s:if>

						<%--

						<s:if
							test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }">

							<li class="drop"><a href="#">Orders</a>
								<ul class="sub_menu">
									<li><a href="<s:url action='viewOrders'/>">Order
											History</a></li>
									<li><a href="<s:url  action='getPaymentsForUser'/>">Payment
											History</a></li>
									<li><a
										href="<s:url action='viewMyCurrentHoldingsCustomer'/>">My
											Holdings</a></li>

								</ul></li>
						</s:if>

						<s:if
							test="%{ null != #attr.userProfile && 'SERVICEPROVIDER'.equalsIgnoreCase(#attr.userProfile.userType) }">

							<li class="drop"><a href="#">Services</a>
								<ul class="sub_menu">
									<li><a href="<s:url action='getServicesForProvider'/>">My
											Services</a></li>
									<li><a href="<s:url  action='addServiceInput'/>">Add
											Service</a></li>
								</ul></li>
						</s:if>

						--%>
						<s:if
							test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">


							<%-- <li class="drop"><a href="#">Services</a>
								<ul class="sub_menu">
									<li><a href="<s:url  action='getServicesForAdmin'/>">All
											Services </a></li>
									<li><a href="<s:url  action='getServiceRequestForAdmin'/>">Service Request</a></li>
								</ul></li>

							<li class="drop"><a href="#">Orders</a>
								<ul class="sub_menu">
									<li><a href="<s:url action='getOrdersForAdmin'/>">Order
											History</a></li>
									<li><a href="<s:url  action='getPaymentsAdmin'/>">Payment
											History</a></li>
								</ul></li> --%>
							<li class="drop"><a href="<s:url action='pendingPLaces'/>">Pending
									Places</a></li>
						</s:if>

						<%-- <s:if
							test="%{ null != #attr.userProfile && #attr.userProfile.mobiledevice 
							&& ('' == #attr.userProfile.userName 
											|| null == #attr.userProfile.userName)}">
							<li class="drop" style="color: #00405d">Dummy Text</li>
						</s:if> --%>

						<li class="drop">
							<div id="loginContainer">
								<s:if
									test="%{ null == #attr.userProfile || '' == #attr.userProfile.userName 
											|| null == #attr.userProfile.userName }">
									<a href="#" id="loginButton"><span>Login</span></a>

									<s:if
										test="%{ null != #attr.userProfile && #attr.userProfile.mobiledevice == 'true' 
																	&& ('' == #attr.userProfile.userName 
																|| null == #attr.userProfile.userName)}">
										<div id="loginBoxMobile">
									</s:if>
									<s:else>
										<div id="loginBox">
									</s:else>


									<form id="loginForm">
										<fieldset id="body">
											<fieldset>
												<label for="email">Email Address</label> <input type="text"
													name="username" id="email">
											</fieldset>
											<fieldset>
												<label for="password">Password</label> <input
													type="password" name="password" id="password">
											</fieldset>
											<label for="checkbox"><input type="checkbox"
												name="rememberMe" id="rememberMe"> <i>Remember
													me</i></label> <input id="login1" value="Sign in"
												onclick="doAjaxPost()"
												style="background-color: #eebf05; color: white;"
												type="button">
											<div id="loginError" style="color: red; display: none;"></div>
											<input id="loginFB" type="button"
												style="margin-top: 5px; background-color: #354F88; color: white; border: none; cursor: pointer"
												value="Sign in using Facebook"
												onclick="top.location.href='http://www.facebook.com/dialog/oauth?scope=email&client_id=841162669353192&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunction'">
											<input id="loginGoogle" type="button"
												style="margin-top: 5px; background-color: #de3b17; color: white; border: none; cursor: pointer"
												value="Sign in using Google"
												onclick="top.location.href='https://accounts.google.com/o/oauth2/auth?scope=email&response_type=code&client_id=968847956660-7cs0n3ke5m69hj96hp9sfmqql34gsd4s.apps.googleusercontent.com&approval_prompt=auto&redirect_uri=http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/loginFunctionGoogle'">

										</fieldset>
										<span><a href="forgotPasswordInput">Forgot your
												password?</a></span>
									</form>
							</div> </s:if> <s:else>
								<li class="drop"><a href="#"> ${userProfile.firstName}</a>
									<ul class="sub_menu">
										<li><a href="<s:url  action='logoutFunction'/>">Logout</a></li>
										<li><a href="<s:url  action='profileManagementInput'/>">Edit
												Profile</a></li>
										<li><a href="<s:url  action='myTestimonial'/>">My Testimonial</a></li>
									</ul></li>

							</s:else>
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