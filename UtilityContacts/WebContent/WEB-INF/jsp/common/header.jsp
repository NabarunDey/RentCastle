
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
				<div class="top_right">
					<ul>
						<s:if
							test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id="addProductButton"><a
								href="<s:url  action='addProductInput'/>">Add Product</a></li>
							<li id="getProductListByVendor"><a
								href="<s:url  action='getProductListByVendor'/>">My Products</a></li>
						</s:if>
						<s:else>
							<li id="addProductButton" style="display: none"><a
								href="<s:url  action='addProductInput'/>">Add Product</a></li>
							<li id="getProductListByVendor" style="display: none"><a
								href="<s:url  action='getProductListByVendor'/>">My Products</a></li>
						</s:else>
						<s:if
							test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "orderHistory"><a href="<s:url  action='viewOrders'/>">Order History</a></li>
						</s:if>
						<s:else>
							<li id = "orderHistory" style="display: none"><a href="<s:url  action='viewOrders'/>">Order History</a></li>
						</s:else>
						
						<s:if
							test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "orderHistoryVendor"><a href="<s:url  action='viewOrdersVendor'/>">Order History</a></li>
						</s:if>
						<s:else>
							<li id = "orderHistoryVendor" style="display: none"><a href="<s:url  action='viewOrdersVendor'/>">Order History</a></li>
						</s:else>
						
						<s:if
							test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "getOrdersForAdmin"><a href="<s:url  action='getOrdersForAdmin'/>">Order History Admin</a></li>
						</s:if>
						<s:else>
							<li id = "getOrdersForAdmin" style="display: none"><a href="<s:url  action='getOrdersForAdmin'/>">Order History Admin</a></li>
						</s:else>
						
						<s:if
							test="%{ null != #attr.userProfile && ('CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) || 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "paymentHistory"><a href="<s:url  action='getPaymentsForUser'/>">Payment History</a></li>
						</s:if>
						<s:else>
							<li id = "paymentHistory" style="display: none"><a href="<s:url  action='getPaymentsForUser'/>">Payment History</a></li>
						</s:else>
						
						<s:if
							test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "paymentHistory"><a href="<s:url  action='getPaymentsAdmin'/>">Payment Admin</a></li>
						</s:if>
						<s:else>
							<li id = "paymentHistory" style="display: none"><a href="<s:url  action='getPaymentsAdmin'/>">Payment Admin</a></li>
						</s:else>
						
						
						<s:if
							test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<li id = "getPendingProducts"><a href="<s:url  action='getPendingProducts'/>">Pending Products</a></li>
						</s:if>
						<s:else>
							<li id = "getPendingProducts" style="display: none"><a href="<s:url  action='getPendingProducts'/>">Pending Products</a></li>
						</s:else>
						<li class="login">
							<div id="loginContainer">
								<s:if
									test="%{ null == #attr.userProfile || '' == #attr.userProfile.userName 
											|| null == #attr.userProfile.userName }">
									<a href="#" id="loginButton"><span>Login</span></a>
									<div id="loginBox">
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
												<input id="login" value="Sign in" onclick="doAjaxPost()">
												<input id="loginFB" style="margin-top:5px;background-color:#354F88;width:197px;height:35px;color:white;border:none;cursor:pointer" value="Sign in using Facebook" onclick="window.location.href='http://www.facebook.com/dialog/oauth?client_id=841162669353192&redirect_uri=http://localhost:8080/RentCastle/loginFunction&scope=email'">
											
												<label for="checkbox"><input type="checkbox"
													id="checkbox"> <i>Remember me</i></label>
											</fieldset>
											<span><a href="#">Forgot your password?</a></span>
										</form>
									</div>
									<div id="loggedin" style="display: none"></div>
									<div id="logout" style="display: none">
										<a href="<s:url  action='logoutFunction'/>">Logout</a>
									</div>
								</s:if>
								<s:else>
									<div id="loggedin">Welcome ${userProfile.firstName}</div>
									<div id="logout">
										<a href="<s:url  action='logoutFunction'/>">Logout</a>
									</div>
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