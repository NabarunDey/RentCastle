<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RentCastle - <s:property value="context.viewPlaceProjectorOB.placesDBBean.placename" /> <s:property value="context.viewPlaceProjectorOB.placesDBBean.placetype" /></title>

<script type="text/javascript" src="js/viewProduct/viewPlace.js"></script>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--webfont-->
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />

<link rel="stylesheet" href="css/etalage.css">
<script>
	jQuery(document)
			.ready(
					function($) {

						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,
											source_image_width : 900,
											source_image_height : 1200,
											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												
											}
										});

					});
</script>
<!-- the jScrollPane script -->
<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();
		$('.rentOffer').click(function() {
			$('.rentOffer').removeClass('bg-danger').addClass('bg-primary');
			$(this).removeClass('bg-primary').addClass('bg-danger');
		})
	});
</script>
</head>
<body>
	<div class="container">
		<div class="women_main">
			<!-- start content -->
			<s:hidden id="productId"
				value="%{context.viewPlaceProjectorOB.placesDBBean.placeid}" />
				 <!-- <img id="imgId" src=<s:property value="context.viewPlaceProjectorOB.profileImage" />/> -->
			<div class="row single">
				<div class="col-md-12">
					<div class="single_left">
					
					<div class="grid images_3_of_2">
							<ul id="etalage">
									<li><a href="optionallink.html"> <img 
											class="etalage_thumb_image" src="<s:property value="context.viewPlaceProjectorOB.profileImage" />"
											class="img-responsive" /> <img class="etalage_source_image"
											src="<s:property value="context.viewPlaceProjectorOB.profileImage" />" class="img-responsive" title="" />
									</a></li>
							</ul>
							<div class="clearfix"></div>
						</div>
					
						<div class="desc1 span_3_of_2">
							<h3>
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.placename" />
							</h3>
							<p class="money">
								Joining Amount: Rs.
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.joiningFees" />
							</p>

							<s:if
								test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">

								<s:select id="approvalStatus" list="{'PENDING','APPROVED'}"
									headerKey="%{context.ViewProductProjectorOB.productsDBBean.approvalStatus}"
									headerValue="%{context.ViewProductProjectorOB.productsDBBean.approvalStatus}"></s:select>
								<input type="button" value="Save Status"
									onclick="changeApprovalStatus()">
							</s:if>
							<s:elseif test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) }">
							<h5><p class="money">
								Status : 
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.approvalStatus" />
							</p></h5>
							</s:elseif>

						</div>
						<div class="clearfix"></div>
					</div>
					<div class="single-bottom1">
						<h6>Details</h6>
						<p class="prod-desc">
							<s:property
								value="context.viewPlaceProjectorOB.placesDBBean.description" />
						</p>
					</div>

				</div>

				<div class="clearfix"></div>
			</div>
			<!-- end content -->
		</div>

	</div>

</body>
</html>