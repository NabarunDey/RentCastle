<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>i-Fit - <s:property
		value="context.viewPlaceProjectorOB.placesDBBean.placename" /> <s:property
		value="context.viewPlaceProjectorOB.placesDBBean.placetype" /></title>

<script type="text/javascript"
	src="js/viewPlace/jssor.slider-22.2.11.mini.js"></script>
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

							<s:hidden id="placeId"
								value="%{context.viewPlaceProjectorOB.placesDBBean.placeid}"
								name="placeId" />
							<s:if
								test="%{ null != #attr.userProfile && 'ADMIN'.equalsIgnoreCase(#attr.userProfile.userType) }">
								<h4>
									Status :
									<s:property
										value="context.viewPlaceProjectorOB.placesDBBean.status" />
								</h4>
								<h4>
									<table>
										<tr>
											<td>Approval Status :</td>
											<td><s:select list="{'APPROVED','PENDING'}"
													name="approvalStatus" theme="simple"
													cssStyle="width : auto;"
													value="%{context.viewPlaceProjectorOB.placesDBBean.approvalStatus}"
													id="approvalStatus" cssClass="form-control"></s:select></td>
											<td><input value="Save Status"
												class="form-control btn btn-info" style="width: auto;"
												onclick="changePlaceApprovalStatus()"></td>
										</tr>
									</table>


								</h4>
								<input value="Edit" class="form-control btn btn-success"
									style="width: auto;" onclick=editPlace()>
								<input value="Delete" class="form-control btn btn-danger"
									style="width: auto;" onclick=deletePlace()>
							</s:if>
							<s:elseif
								test="%{ null != #attr.userProfile && 'VENDOR'.equalsIgnoreCase(#attr.userProfile.userType) && context.viewPlaceProjectorOB.placesDBBean.username.equalsIgnoreCase(#attr.userProfile.userName) }">

								<h4>
									Status :
									<s:property
										value="context.viewPlaceProjectorOB.placesDBBean.status" />
								</h4>

								<h4>
									Approval Status :
									<s:property
										value="context.viewPlaceProjectorOB.placesDBBean.approvalStatus" />
								</h4>
								<input value="Edit" class="form-control btn btn-success"
									style="width: auto;" onclick=editPlace()>
								<input value="Delete" class="form-control btn btn-danger"
									style="width: auto;" onclick=deletePlace()>
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
							<div data-u="slides" id="imgThumb"
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
						<br>
						<table align="left" width="60%">
							<tr>
								<td>Add more images</td>
								<form action="addGalleryImages" enctype="multipart/form-data"
									method="post">
									<td><input name="galleryImages" type="file" multiple
										class="btn btn-primary add" /></td>
									<td><input type="submit" value="Submit" name="Submit"
										class="btn btn-primary add" /></td>
								</form>
								<td><a href="<s:url  action='editGallery'/>"
									class="btn btn-primary add">Edit Gallery</a></td>
							</tr>
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

												<div id="viewFacilitiesSection">
													<s:iterator
														value="context.viewPlaceProjectorOB.facilitiesList">
														<div class="form-group">
															<s:property />
														</div>
													</s:iterator>
												</div>

												<s:if test="context.viewPlaceProjectorOB.vendor">

													<div id="editFacilitiesSection" style="display: none;">
														<s:iterator
															value="context.viewPlaceProjectorOB.facilitiesList">
															<div class="form-group" id="editFacilitiesId">

																<div>
																	<input type="text" class="facilitieClassEdit"
																		value="<s:property />" style="width: 600px;">
																</div>
																<br>
															</div>
														</s:iterator>
													</div>


													<div class="form-group" id="facilitiesSection">
														<input type="text" name="facilitiesDescription"
															style="width: 600px;"><br> <br>
													</div>
													<input value="Edit" class="form-control btn btn-info"
														style="width: auto;" onclick="editFacility()">

													<input value="Add More" id="addFacility"
														class="btn btn-primary add" />
													<input type="submit" value="Submit" name="Submit"
														id="addFacilitiesSubmitButton" class="btn btn-primary add" />
													<input value="Submit" class="form-control btn btn-info"
														id="editFacilitySubmitButton"
														style="width: auto; display: none;"
														onclick="editFacilitySubmit()">

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

												<div id="viewPriceSection">
													<s:iterator value="context.viewPlaceProjectorOB.priceList">
														<div class="form-group">
															<s:property />
														</div>
													</s:iterator>
												</div>

												<s:if test="context.viewPlaceProjectorOB.vendor">

													<div id="editPriceSection" style="display: none;">
														<s:iterator value="context.viewPlaceProjectorOB.priceList">
															<div class="form-group">

																<div>
																	<input type="text" class="priceClassEdit"
																		value="<s:property />" style="width: 600px;">
																</div>
																<br>
															</div>
														</s:iterator>
													</div>


													<div class="form-group" id="priceSection">
														<input type="text" name="price" style="width: 600px;"><br>
														<br>
													</div>

													<input value="Edit" class="form-control btn btn-info"
														style="width: auto;" onclick="editPrice()">

													<input value="Add More" id="addPrice"
														class="btn btn-primary add" />
													<input type="submit" value="Submit" name="Submit"
														id="addPriceSubmitButton" class="btn btn-primary add" />
													<input value="Submit" class="form-control btn btn-info"
														id="editPriceSubmitButton"
														style="width: auto; display: none;"
														onclick="editPriceSubmit()">
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
        jQuery(document).ready(function ($) {

            var jssor_1_SlideshowTransitions = [
              {$Duration:1200,x:0.3,$During:{$Left:[0.3,0.7]},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:-0.3,$SlideOut:true,$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:-0.3,$During:{$Left:[0.3,0.7]},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,$SlideOut:true,$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:0.3,$During:{$Top:[0.3,0.7]},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:-0.3,$SlideOut:true,$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:-0.3,$During:{$Top:[0.3,0.7]},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:0.3,$SlideOut:true,$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,$Cols:2,$During:{$Left:[0.3,0.7]},$ChessMode:{$Column:3},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,$Cols:2,$SlideOut:true,$ChessMode:{$Column:3},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:0.3,$Rows:2,$During:{$Top:[0.3,0.7]},$ChessMode:{$Row:12},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:0.3,$Rows:2,$SlideOut:true,$ChessMode:{$Row:12},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:0.3,$Cols:2,$During:{$Top:[0.3,0.7]},$ChessMode:{$Column:12},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,y:-0.3,$Cols:2,$SlideOut:true,$ChessMode:{$Column:12},$Easing:{$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,$Rows:2,$During:{$Left:[0.3,0.7]},$ChessMode:{$Row:3},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:-0.3,$Rows:2,$SlideOut:true,$ChessMode:{$Row:3},$Easing:{$Left:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,y:0.3,$Cols:2,$Rows:2,$During:{$Left:[0.3,0.7],$Top:[0.3,0.7]},$ChessMode:{$Column:3,$Row:12},$Easing:{$Left:$Jease$.$InCubic,$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,x:0.3,y:0.3,$Cols:2,$Rows:2,$During:{$Left:[0.3,0.7],$Top:[0.3,0.7]},$SlideOut:true,$ChessMode:{$Column:3,$Row:12},$Easing:{$Left:$Jease$.$InCubic,$Top:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,$Delay:20,$Clip:3,$Assembly:260,$Easing:{$Clip:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,$Delay:20,$Clip:3,$SlideOut:true,$Assembly:260,$Easing:{$Clip:$Jease$.$OutCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,$Delay:20,$Clip:12,$Assembly:260,$Easing:{$Clip:$Jease$.$InCubic,$Opacity:$Jease$.$Linear},$Opacity:2},
              {$Duration:1200,$Delay:20,$Clip:12,$SlideOut:true,$Assembly:260,$Easing:{$Clip:$Jease$.$OutCubic,$Opacity:$Jease$.$Linear},$Opacity:2}
            ];

            var jssor_2_options = {
              $AutoPlay: true,
              $SlideshowOptions: {
                $Class: $JssorSlideshowRunner$,
                $Transitions: jssor_1_SlideshowTransitions,
                $TransitionsOrder: 1
              },
              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
              },
              $ThumbnailNavigatorOptions: {
                $Class: $JssorThumbnailNavigator$,
                $Cols: 10,
                $SpacingX: 8,
                $SpacingY: 8,
                $Align: 360
              }
            };

            var jssor_2_slider = new $JssorSlider$("jssor_2", jssor_2_options);

            /*responsive code begin*/
            /*you can remove responsive code if you don't want the slider scales while window resizing*/
            function ScaleSlider() {
                var refSize = jssor_2_slider.$Elmt.parentNode.clientWidth;
                if (refSize) {
                    refSize = Math.min(refSize, 800);
                    jssor_2_slider.$ScaleWidth(refSize);
                }
                else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }
            ScaleSlider();
            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            /*responsive code end*/
        });
    </script>
	<style>
/* jssor slider arrow navigator skin 05 css */
/*
        .jssora05l                  (normal)
        .jssora05r                  (normal)
        .jssora05l:hover            (normal mouseover)
        .jssora05r:hover            (normal mouseover)
        .jssora05l.jssora05ldn      (mousedown)
        .jssora05r.jssora05rdn      (mousedown)
        .jssora05l.jssora05lds      (disabled)
        .jssora05r.jssora05rds      (disabled)
        */
.jssora05l, .jssora05r {
	display: block;
	position: absolute;
	/* size of arrow element */
	width: 40px;
	height: 40px;
	cursor: pointer;
	background: url('images/a17.png') no-repeat;
	overflow: hidden;
}

.jssora05l {
	background-position: -10px -40px;
}

.jssora05r {
	background-position: -70px -40px;
}

.jssora05l:hover {
	background-position: -130px -40px;
}

.jssora05r:hover {
	background-position: -190px -40px;
}

.jssora05l.jssora05ldn {
	background-position: -250px -40px;
}

.jssora05r.jssora05rdn {
	background-position: -310px -40px;
}

.jssora05l.jssora05lds {
	background-position: -10px -40px;
	opacity: .3;
	pointer-events: none;
}

.jssora05r.jssora05rds {
	background-position: -70px -40px;
	opacity: .3;
	pointer-events: none;
}
/* jssor slider thumbnail navigator skin 01 css */
/*.jssort01 .p            (normal).jssort01 .p:hover      (normal mouseover).jssort01 .p.pav        (active).jssort01 .p.pdn        (mousedown)*/
.jssort01 .p {
	position: absolute;
	top: 0;
	left: 0;
	width: 72px;
	height: 72px;
}

.jssort01 .t {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	border: none;
}

.jssort01 .w {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 100%;
}

.jssort01 .c {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 68px;
	height: 68px;
	border: #000 2px solid;
	box-sizing: content-box;
	background: url('images/t01.png') -800px -800px no-repeat;
	_background: none;
}

.jssort01 .pav .c {
	top: 2px;
	_top: 0px;
	left: 2px;
	_left: 0px;
	width: 68px;
	height: 68px;
	border: #000 0px solid;
	_border: #fff 2px solid;
	background-position: 50% 50%;
}

.jssort01 .p:hover .c {
	top: 0px;
	left: 0px;
	width: 70px;
	height: 70px;
	border: #fff 1px solid;
	background-position: 50% 50%;
}

.jssort01 .p.pdn .c {
	background-position: 50% 50%;
	width: 68px;
	height: 68px;
	border: #000 2px solid;
}

* html .jssort01 .c, * html .jssort01 .pdn .c, * html .jssort01 .pav .c
	{ /* ie quirks mode adjust */
	width /**/: 72px;
	height /**/: 72px;
}
</style>

	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h2>Gallery</h2>
			</div>
			<div class="modal-body">
				<div id="jssor_2"
					style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 800px; height: 456px; overflow: hidden; visibility: hidden; background-color: #24262e;">
					<!-- Loading Screen -->
					<div data-u="loading"
						style="position: absolute; top: 0px; left: 0px; background-color: rgba(0, 0, 0, 0.7);">
						<div
							style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
						<div
							style="position: absolute; display: block; background: url('images/loading.gif') no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
					</div>
					<div data-u="slides"
						style="cursor: default; position: relative; top: 0px; left: 0px; width: 800px; height: 356px; overflow: hidden;">


						<s:iterator value="context.viewPlaceProjectorOB.imagesList">
							<div>
								<img data-u="image" src="<s:property value = 'imagepath' />" />
								<img data-u="thumb" src="<s:property value = 'imagepath' />" />
							</div>
						</s:iterator>

					</div>
					<!-- Thumbnail Navigator -->
					<div data-u="thumbnavigator" class="jssort01"
						style="position: absolute; left: 0px; bottom: 0px; width: 800px; height: 100px;"
						data-autocenter="1">
						<!-- Thumbnail Item Skin Begin -->
						<div data-u="slides" style="cursor: default;">
							<div data-u="prototype" class="p">
								<div class="w">
									<div data-u="thumbnailtemplate" class="t"></div>
								</div>
								<div class="c"></div>
							</div>
						</div>
						<!-- Thumbnail Item Skin End -->
					</div>
					<!-- Arrow Navigator -->
					<span data-u="arrowleft" class="jssora05l"
						style="top: 158px; left: 8px; width: 40px; height: 40px;"></span>
					<span data-u="arrowright" class="jssora05r"
						style="top: 158px; right: 8px; width: 40px; height: 40px;"></span>
				</div>
			</div>
			<!-- <div class="modal-footer">
				<h3>Modal Footer</h3>
			</div> -->
		</div>

	</div>


	<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("imgThumb");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>



	<script type="text/javascript">
		jssor_1_slider_init();
	</script>
</body>
</html>