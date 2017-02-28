<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RentCastle - <s:property
		value="context.viewPlaceProjectorOB.placesDBBean.placename" /> <s:property
		value="context.viewPlaceProjectorOB.placesDBBean.placetype" /></title>

<script type="text/javascript"
	src="js/viewPlace/jssor.slider-22.2.8.min.js"></script>
<script type="text/javascript" src="js/viewPlace/viewPlace.js"></script>

<script type="text/javascript">
	jssor_1_slider_init = function() {

		var jssor_1_options = {
			$AutoPlay : true,
			$AutoPlaySteps : 4,
			$SlideDuration : 160,
			$SlideWidth : 200,
			$SlideSpacing : 3,
			$Cols : 4,
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$,
				$Steps : 4
			},
			$BulletNavigatorOptions : {
				$Class : $JssorBulletNavigator$,
				$SpacingX : 1,
				$SpacingY : 1
			}
		};

		var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

		/*responsive code begin*/
		/*you can remove responsive code if you don't want the slider scales while window resizing*/
		function ScaleSlider() {
			var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
			if (refSize) {
				refSize = Math.min(refSize, 809);
				jssor_1_slider.$ScaleWidth(refSize);
			} else {
				window.setTimeout(ScaleSlider, 30);
			}
		}
		ScaleSlider();
		$Jssor$.$AddEvent(window, "load", ScaleSlider);
		$Jssor$.$AddEvent(window, "resize", ScaleSlider);
		$Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
		/*responsive code end*/
	};
</script>
<style>
/* jssor slider bullet navigator skin 03 css */
/*
        .jssorb03 div           (normal)
        .jssorb03 div:hover     (normal mouseover)
        .jssorb03 .av           (active)
        .jssorb03 .av:hover     (active mouseover)
        .jssorb03 .dn           (mousedown)
        */
.jssorb03 {
	position: absolute;
}

.jssorb03 div, .jssorb03 div:hover, .jssorb03 .av {
	position: absolute;
	/* size of bullet elment */
	width: 21px;
	height: 21px;
	text-align: center;
	line-height: 21px;
	color: white;
	font-size: 12px;
	background: url('images/b03.png') no-repeat;
	overflow: hidden;
	cursor: pointer;
}

.jssorb03 div {
	background-position: -5px -4px;
}

.jssorb03 div:hover, .jssorb03 .av:hover {
	background-position: -35px -4px;
}

.jssorb03 .av {
	background-position: -65px -4px;
}

.jssorb03 .dn, .jssorb03 .dn:hover {
	background-position: -95px -4px;
}

/* jssor slider arrow navigator skin 03 css */
/*
        .jssora03l                  (normal)
        .jssora03r                  (normal)
        .jssora03l:hover            (normal mouseover)
        .jssora03r:hover            (normal mouseover)
        .jssora03l.jssora03ldn      (mousedown)
        .jssora03r.jssora03rdn      (mousedown)
        .jssora03l.jssora03ldn      (disabled)
        .jssora03r.jssora03rdn      (disabled)
        */
.jssora03l, .jssora03r {
	display: block;
	position: absolute;
	/* size of arrow element */
	width: 55px;
	height: 55px;
	cursor: pointer;
	background: url('images/a03.png') no-repeat;
	overflow: hidden;
}

.jssora03l {
	background-position: -3px -33px;
}

.jssora03r {
	background-position: -63px -33px;
}

.jssora03l:hover {
	background-position: -123px -33px;
}

.jssora03r:hover {
	background-position: -183px -33px;
}

.jssora03l.jssora03ldn {
	background-position: -243px -33px;
}

.jssora03r.jssora03rdn {
	background-position: -303px -33px;
}

.jssora03l.jssora03lds {
	background-position: -3px -33px;
	opacity: .3;
	pointer-events: none;
}

.jssora03r.jssora03rds {
	background-position: -63px -33px;
	opacity: .3;
	pointer-events: none;
}
</style>


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
	jQuery(document).ready(function($) {

		$('#etalage').etalage({
			thumb_image_width : 300,
			thumb_image_height : 300,
			source_image_width : 900,
			source_image_height : 1200,
			show_hint : true,
			click_callback : function(image_anchor, instance_id) {

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
			<div class="row single">
				<div class="col-md-12">
					<div class="single_left">

						<div class="grid images_3_of_2">
							<ul id="etalage">
								<li><img class="etalage_thumb_image"
									src="<s:property value="context.viewPlaceProjectorOB.profileImage" />"
									class="img-responsive" /> <img class="etalage_source_image"
									src="<s:property value="context.viewPlaceProjectorOB.profileImage" />"
									class="img-responsive" title="" /></li>
							</ul>
						</div>

						<div class="desc1 span_3_of_2">
							<p class="money">
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.placename" />
							</p>
							<h4>
								Category :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.placetype" />
							</h4>
							<h4>
								Joining Amount: Rs.
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.joiningFees" />
							</h4>
							<h4>
								Address :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.address" />
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.city" />
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.pin" />
							</h4>

							<h4>
								Days Open :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.daysOpen" />
							</h4>

							<h4>
								Working Hours :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.timing" />
							</h4>

							<h4>
								Contact :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.contactno1" />
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.contactno2" />
							</h4>

							<h4>
								Email :
								<s:property
									value="context.viewPlaceProjectorOB.placesDBBean.email" />
							</h4>

							<s:if
								test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">

								<s:select id="approvalStatus" list="{'PENDING','APPROVED'}"
									headerKey="%{context.ViewProductProjectorOB.productsDBBean.approvalStatus}"
									headerValue="%{context.ViewProductProjectorOB.productsDBBean.approvalStatus}"></s:select>
								<input type="button" value="Save Status"
									onclick="changeApprovalStatus()">
							</s:if>
							<s:elseif
								test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) && context.ViewProductProjectorOB.productsDBBean.userName.equalsIgnoreCase(#attr.userProfile.userName) }">
								<h4>
									Status :
									<s:property
										value="context.viewPlaceProjectorOB.placesDBBean.approvalStatus" />
								</h4>
							</s:elseif>

						</div>
						<div class="clearfix"></div>
					</div>

					<div class="single-bottom1">
						<h6>Gallery</h6>
						<div id="jssor_1"
							style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 809px; height: 150px; overflow: hidden; visibility: hidden;">
							<!-- Loading Screen -->
							<div data-u="loading"
								style="position: absolute; top: 0px; left: 0px; background-color: rgba(0, 0, 0, 0.7);">
								<div
									style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
								<div
									style="position: absolute; display: block; background: url('images/loading.gif') no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
							</div>
							<div data-u="slides"
								style="cursor: default; position: relative; top: 0px; left: 0px; width: 809px; height: 150px; overflow: hidden;">


								<s:iterator value="context.viewPlaceProjectorOB.imagesList">
									<div>
										<img data-u="image" src="<s:property value = 'imagepath' />" />
									</div>
								</s:iterator>

							</div>
							<!-- Bullet Navigator -->
							<div data-u="navigator" class="jssorb03"
								style="bottom: 10px; right: 10px;">
								<!-- bullet navigator item prototype -->
								<div data-u="prototype" style="width: 21px; height: 21px;">
									<div data-u="numbertemplate"></div>
								</div>
							</div>
							<!-- Arrow Navigator -->
							<span data-u="arrowleft" class="jssora03l"
								style="top: 0px; left: 8px; width: 55px; height: 55px;"
								data-autocenter="2"></span> <span data-u="arrowright"
								class="jssora03r"
								style="top: 0px; right: 8px; width: 55px; height: 55px;"
								data-autocenter="2"></span>
						</div>
					</div>

					<s:if test="context.viewPlaceProjectorOB.vendor">

						<table align="left" width="50%">
							<tr>
								<td>Add more images</td>
								<form action="addGalleryImages" enctype="multipart/form-data"
									method="post">
									<td><input name="galleryImages" type="file" multiple
										class="btn btn-primary add" /></td>
									<td><input type="submit" value="Submit" name="Submit"
										class="btn btn-primary add" /></td>
								</form>
						</table>

						<div class="clearfix"></div>
					</s:if>



					<div class="single-bottom1">
						<h6>About Us</h6>
						<!-- 	<p class="prod-desc"> -->
						<s:property
							value="context.viewPlaceProjectorOB.placesDBBean.description" />
					</div>
					<div class="clearfix"></div>

					<div style="padding: 3% 0 0%;">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTwo"><span
										class="glyphicon glyphicon-th-list"> </span>Facilities</a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse">
								<div class="panel-body">
									<form action="addFacilites" method="post">
										<div class="row">
											<div class="col-md-6">

												<s:iterator
													value="context.viewPlaceProjectorOB.facilitiesList">
													<div class="form-group">
														<s:property />
													</div>
												</s:iterator>


												<s:if test="context.viewPlaceProjectorOB.vendor">
													<div class="form-group" id="facilitiesSection">
														<input type="text" name="facilitiesDescription"
															style="width: 600px;"><br> <br>
													</div>

													<input value="Add More" id="addFacility"
														class="btn btn-primary add" />
													<input type="submit" value="Submit" name="Submit"
														class="btn btn-primary add" />
												</s:if>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
					<div style="padding: 3% 0 0%;">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne"><span
										class="glyphicon glyphicon-th-list"> </span>Charges</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse">
								<div class="panel-body">
									<form action="addPrice" method="post">
										<div class="row">
											<div class="col-md-6">

												<s:iterator
													value="context.viewPlaceProjectorOB.priceList">
													<div class="form-group">
														<s:property />
													</div>
												</s:iterator>


												<s:if test="context.viewPlaceProjectorOB.vendor">
													<div class="form-group" id="priceSection">
														<input type="text" name="price"
															style="width: 600px;"><br> <br>
													</div>

													<input value="Add More" id="addPrice"
														class="btn btn-primary add" />
													<input type="submit" value="Submit" name="Submit"
														class="btn btn-primary add" />
												</s:if>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>


					</div>

				</div>

			</div>
			<!-- end content -->
		</div>

	</div>
	<script type="text/javascript">
		jssor_1_slider_init();
	</script>
</body>
</html>