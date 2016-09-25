<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<div class="header_bg">
		<div class="container">
			<div class="header">
				<div class="logo">
					<a href="loadIndex.action"><img src="images/RentCastleLogo.JPG" alt="" /> </a>
				</div>
				<!-- start header_right -->
				<div class="header_right">
					<s:if
						test="%{ null == #attr.userProfile || '' == #attr.userProfile.userName || null == #attr.userProfile.userName }">
						<div class="create_btn" id="createAccount">
							<a class="arrow" href="userRegistrationInput.action">create
								account <img src="images/right_arrow.png" alt="" />
							</a>
						</div>
					</s:if>
					<s:if
						test="%{ null != #attr.userProfile && 'CUSTOMER'.equalsIgnoreCase(#attr.userProfile.userType) }">
						<div id=myCart>
							<ul class="icon1 sub-icon1 profile_img">
								<li><a class="active-icon c2" href="viewCart.action"> </a></li>
							</ul>
						</div>
					</s:if>

					<div id=myCart style="display: none">
						<ul class="icon1 sub-icon1 profile_img">
							<li><a class="active-icon c2" href="viewCart.action"> </a></li>
						</ul>
					</div>
					<div class="search">
						<s:form action="searchAction">
							<input name="searchString" type="text" value=""
								placeholder="search...">
							<s:submit type="submit" value="" />
						</s:form>
					</div>
					<div class="clearfix"></div>
				</div>
				<!-- start header menu -->
				<ul class="megamenu skyblue">
					<li><a class="color1" href="loadIndex.action">Home</a></li>
					<li class="grid"><a class="color2"
						href="<s:url  action='searchByCriteria'><s:param name="searchType" value="'Electronics'"></s:param></s:url>">Electronics</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>Items</h4>
										<ul>
											<li><a
												href="<s:url  action='searchByCriteria'><s:param name="searchSubType" value="'Refrigerator'"></s:param></s:url>">Refrigerator</a></li>
											<li><a
												href="<s:url  action='searchByCriteria'><s:param name="searchSubType" value="'WashingMachine'"></s:param></s:url>">Washing
													Machine</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li class="active grid"><a class="color4"
						href="<s:url  action='searchByCriteria'><s:param name="searchType" value="'Furniture'"></s:param></s:url>">Furniture</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>Items</h4>
										<ul>
											<li><a
												href="<s:url  action='searchByCriteria'><s:param name="searchSubType" value="'Bed'"></s:param></s:url>">Bed</a></li>
											<li><a
												href="<s:url  action='searchByCriteria'><s:param name="searchSubType" value="'Almirah'"></s:param></s:url>">Almirah</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div></li>

				</ul>
			</div>
		</div>
	</div>
</body>
</html>