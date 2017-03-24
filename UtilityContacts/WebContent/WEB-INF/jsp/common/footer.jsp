<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body  background="images/bg_img4_qe42z1_light.jpg">

	<div class="footer_top">
		<div class="container">

			<div class="span_of_4">
				<div class="span1_of_4">
					<h4>Gyms</h4>
					<ul class="f_nav">
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Premium'"></s:param><s:param name="category" value="'Gym'"></s:param></s:url>">Premium</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Regular'"></s:param><s:param name="category" value="'Gym'"></s:param></s:url>">Regular
						</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Economy'"></s:param><s:param name="category" value="'Gym'"></s:param></s:url>">Economy</a></li>


					</ul>
					<h4 class="top">Swimming Centers</h4>
					<ul class="f_nav">
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Premium'"></s:param><s:param name="category" value="'SwimmingPool'"></s:param></s:url>">Premium</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Regular'"></s:param><s:param name="category" value="'SwimmingPool'"></s:param></s:url>">Regular
						</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Economy'"></s:param><s:param name="category" value="'SwimmingPool'"></s:param></s:url>">Economy</a></li>
					</ul>
				</div>
				<div class="span1_of_4">
					<h4>Yoga Centers</h4>
					<ul class="f_nav">
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Premium'"></s:param><s:param name="category" value="'YogaCenter'"></s:param></s:url>">Premium</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Regular'"></s:param><s:param name="category" value="'YogaCenter'"></s:param></s:url>">Regular
						</a></li>
						<li><a
							href="<s:url  action='searchCategory'><s:param name="qt" value="'Economy'"></s:param><s:param name="category" value="'YogaCenter'"></s:param></s:url>">Economy</a></li>
					</ul>
				</div>
				<div class="span1_of_4">
					<h4>account</h4>
					<ul class="f_nav">
						<li><a href="#">login</a></li>
						<li><a href="userRegistrationInput">create an account</a></li>
						<li><a href="#">Frequently asked questions</a></li>
					</ul>
				</div>
				<div class="span1_of_4">
					<h4>Get in Touch</h4>
					<ul class="f_nav">
						<li><a href="<s:url  action='helpInput'/>">Contact Us</a></li>
						<li><a href="#">About Us</a></li>
						<li><a href="https://www.facebook.com/iFitIndiaPvtLtd/">Follow
								Us on Facebook</a></li>
						<li><a href="#">Follow Us on Youtube</a></li>
						<li><a href="#">Follow Us on Twitter</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>


			<!-- start span_of_2 -->
			<div class="span_of_2">
				<div class="span1_of_2">
					<h5>
						need help? <a href="<s:url  action='helpInput'/>">contact us <span>
								></span>
						</a>
					</h5>
					<p>(or) Call us: +91-7980149480</p>
					<p>mailto : support@i-fit.in</p>
				</div>

				<div class="span1_of_2">
					<h5>follow us</h5>
					<div class="social-icons">
						<ul>
							<li><a href="https://www.facebook.com/iFitIndiaPvtLtd/"
								target="_blank"></a></li>
							<li><a href="#" target="_blank"></a></li>
							<li><a href="#" target="_blank"></a></li>
							<li><a href="#" target="_blank"></a></li>
							<li><a href="#" target="_blank"></a></li>
						</ul>
					</div>
				</div>
				<div class="fb-page"
					data-href="https://www.facebook.com/iFitIndiaPvtLtd/"
					data-small-header="true" data-adapt-container-width="true"
					data-hide-cover="false" data-show-facepile="true">
					<blockquote cite="https://www.facebook.com/iFitIndiaPvtLtd/"
						class="fb-xfbml-parse-ignore">
						<a href="https://www.facebook.com/iFitIndiaPvtLtd/">i-Fit
							India</a>
					</blockquote>
				</div>
				<div class="fb-share-button"
					data-href="https://www.facebook.com/iFitIndiaPvtLtd/"
					data-layout="button_count" data-size="small"
					data-mobile-iframe="true">
					<a class="fb-xfbml-parse-ignore" target="_blank"
						href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fwww.facebook.com%2FiFitIndiaPvtLtd%2F&amp;src=sdkpreparse">Share</a>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="copy">
				<p class="link">&copy;A product by i-Fit India</p>
			</div>
		</div>
	</div>

</body>
</html>