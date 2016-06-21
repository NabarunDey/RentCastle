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

	<div class="header_bg">
		<div class="container">
			<div class="header">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="" /> </a>
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
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c2" href="#"> </a>
							<ul class="sub-icon1 list">
								<li><h3>shopping cart empty</h3>
									<a href="viewCart.action"></a></li>
								<li><p>
										if items in your wishlit are missing, <a href="">login to
											your account</a> to view them
									</p></li>
							</ul></li>
					</ul>
					<ul class="icon1 sub-icon1 profile_img">
						<li><a class="active-icon c1" href="#"> </a>
							<ul class="sub-icon1 list">
								<li><h3>wishlist empty</h3>
									<a href=""></a></li>
								<li><p>
										if items in your wishlit are missing, <a href="">login to
											your account</a> to view them
									</p></li>
							</ul></li>
					</ul>
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
					<li class="grid"><a class="color2" href="#">Electronics</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>Items</h4>
										<ul>
											<li><a href="women.html">Refrigerator</a></li>
											<li><a href="women.html">Washing Machine</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li class="active grid"><a class="color4" href="#">Furniture</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>Items</h4>
										<ul>
											<li><a href="women.html">Bed</a></li>
											<li><a href="women.html">Almirah</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li><a class="color5" href="#">accessories</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>shop</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">brands</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>help</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>account</h4>
										<ul>
											<li><a href="women.html">login</a></li>
											<li><a href="women.html">create an account</a></li>
											<li><a href="women.html">create wishlist</a></li>
											<li><a href="women.html">my shopping bag</a></li>
											<li><a href="women.html">brands</a></li>
											<li><a href="women.html">create wishlist</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>popular</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col2"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
							</div>
						</div></li>
					<li><a class="color6" href="#">kids</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>shop</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">brands</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>help</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>account</h4>
										<ul>
											<li><a href="women.html">login</a></li>
											<li><a href="women.html">create an account</a></li>
											<li><a href="women.html">create wishlist</a></li>
											<li><a href="women.html">my shopping bag</a></li>
											<li><a href="women.html">brands</a></li>
											<li><a href="women.html">create wishlist</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>popular</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col2"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
							</div>
						</div></li>
					<li><a class="color7" href="#">brands</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>shop</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">brands</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>help</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>account</h4>
										<ul>
											<li><a href="women.html">login</a></li>
											<li><a href="women.html">create an account</a></li>
											<li><a href="women.html">create wishlist</a></li>
											<li><a href="women.html">my shopping bag</a></li>
											<li><a href="women.html">brands</a></li>
											<li><a href="women.html">create wishlist</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>popular</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col2"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
							</div>
						</div></li>
					<li><a class="color8" href="#">trends</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>shop</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">brands</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>help</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>account</h4>
										<ul>
											<li><a href="women.html">login</a></li>
											<li><a href="women.html">create an account</a></li>
											<li><a href="women.html">create wishlist</a></li>
											<li><a href="women.html">my shopping bag</a></li>
											<li><a href="women.html">brands</a></li>
											<li><a href="women.html">create wishlist</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>popular</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col2"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
							</div>
						</div></li>
					<li><a class="color9" href="#">sale</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>shop</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">brands</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>help</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>account</h4>
										<ul>
											<li><a href="women.html">login</a></li>
											<li><a href="women.html">create an account</a></li>
											<li><a href="women.html">create wishlist</a></li>
											<li><a href="women.html">my shopping bag</a></li>
											<li><a href="women.html">brands</a></li>
											<li><a href="women.html">create wishlist</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>my company</h4>
										<ul>
											<li><a href="women.html">trends</a></li>
											<li><a href="women.html">sale</a></li>
											<li><a href="women.html">style videos</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
								<div class="col1">
									<div class="h_nav">
										<h4>popular</h4>
										<ul>
											<li><a href="women.html">new arrivals</a></li>
											<li><a href="women.html">men</a></li>
											<li><a href="women.html">women</a></li>
											<li><a href="women.html">accessories</a></li>
											<li><a href="women.html">kids</a></li>
											<li><a href="women.html">style videos</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col2"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
								<div class="col1"></div>
							</div>
						</div></li>
					<li><a class="color10" href="contact.html">Contact</a>
						<div class="megapanel">
							<div class="row">
								<div class="col3">
									<div class="h_nav">
										<h4>contact us</h4>
									</div>
									<form class="contact">
										<label for="name">Name</label> <input id="name" type="text" />
										<label for="email">E-mail</label> <input id="email"
											type="text" /> <label for="message">Message</label>
										<textarea rows="8" id="message"></textarea>
										<input type="submit" value="Send" />
									</form>
								</div>
								<div class="col3"></div>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>