<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RentCastle - Contact Us</title>

<script type="text/javascript" src="js/help/help.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<div class="container">
		<div class="main">
			<div class="contact">
				<div class="contact-form">
					<h2>Contact Us</h2>
					<h5>For any queries, suggestions, complaints, etc please write to us.</h5>
					<div id="errorRequestSubmit"
									style="display: none; color: #ff0000;">Error! Request not delivered.</div>
					<div id="successRequestSubmit"
									style="display: none; color: #17de69;">Your request has been submitted. We'll get back to you soon.</div>
					<form id = "helpRequest_form">
						<div>
							<span><label>Name</label></span> <span><input
								name="name" type="text" class="textbox" value="<s:property value = 'context.helpProjectorOB.name' />"></span>
						</div>
						<div>
							<span><label>E-mail</label></span> <span><input
								name="email" type="text" class="textbox" value="<s:property value = 'context.helpProjectorOB.email' />"></span>
						</div>
						<div>
							<span><label>Mobile</label></span> <span><input
								name="mobile" type="text" class="textbox"></span>
						</div>
						<div>
							<span><label>Category</label></span>
								<s:select list="{'COMPLAINT','FEEDBACK','SUGGESTION'}" name="category"
											cssClass="form-control"></s:select>
						</div>
						<div>
							<span><label>Subject</label></span> <span><textarea
									name="message"> </textarea></span>
						</div>
						<div>
							<span><input onclick="helpRequestSubmit()" type="button" class="" value="Send"></span>
						</div>
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

</body>
</html>