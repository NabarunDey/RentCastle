<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>i-Fit - My Testimonial</title>

<script type="text/javascript" src="js/testimonials/testimonials.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div class="main">
			<div class="contact">
				<div class="contact-form">
					<h2>My Testimonial</h2>
					<h5>Write a testimonial for about us and let us know your
						experience.</h5>
					<s:if test="!context.testimonialsProjectorOB.loggedIn">
						<div id="pleaseLogin" style="color: #ff0000;">Please
							login to write testimonial.</div>
					</s:if>
					<s:if
						test="testimonialAdded">
						<div id="successRequestSubmit"
							style="color: #17de69;">Thank You for
							writing about us. Your testimonial is processed for review.</div>
					</s:if>
					<s:form id="testimonial_form" action="addTestimonial" method="post"
						theme="simple" enctype="multipart/form-data">

						<div class="form-group">
							<label class="col-sm-2 control-label">Display Image</label>
							<div class="col-sm-10">
								<div class="fileinput fileinput-new" data-provides="fileinput">
									<div class="fileinput-new thumbnail"
										style="width: 200px; height: 150px;">
										<img src="" id="previewImage1" class="img-thumbnail">
									</div>
									<div class="fileinput-preview fileinput-exists thumbnail"
										style="width: 200px; height: 150px;"></div>
									<div>
										<span class="btn btn-default btn-file"><span
											class="fileinput-new">Select image</span><span
											class="fileinput-exists">Change</span> <s:file id="image1"
												name="profileImage" /></span> <a href="#"
											class="btn btn-default fileinput-exists"
											data-dismiss="fileinput">Remove</a>
									</div>
								</div>
							</div>
						</div>

						<div>
							<span><label>Full Name</label></span> <span><input
								name="displayName" type="text" class="textbox"
								value="<s:property value = 'context.testimonialsProjectorOB.testimonialsDBBean.displayName' />"></span>
						</div>
						<div>
							<span><label>My Comment </label></span> <span> <s:textarea
									name="comment" cssClass="form-control"
									value="%{context.testimonialsProjectorOB.testimonialsDBBean.comment}"
									id="comment" /></span>

						</div>
						<div>
							<span><s:submit value="Send"></s:submit></span>
						</div>
					</s:form>
				</div>
				<div class="clearfix"></div>
			</div>



		</div>
	</div>
</body>
</html>


