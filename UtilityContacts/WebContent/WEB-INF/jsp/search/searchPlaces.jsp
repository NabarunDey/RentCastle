<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords"
	content="Rent,Kolkata,<s:property value="searchType"/>, <s:property value="searchSubType"/>">
<meta name="description"
	content="Rent <s:property value="searchType"/> <s:property value="searchSubType"/> in Kolkata at RentCastle.in<s:property value="searchType"/> <s:property value="searchSubType"/> on rent in Kolkata.Delivery at your doorstep.">
<title>Rent <s:property value="searchType" /> <s:property
		value="searchSubType" /> in Kolkata at RentCastle.in
</title>
<script type="text/javascript" src="js/search/searchPlace.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();

	});
</script>
<style type="text/css">
.result {
	margin: 10px 0;
}

.reset-icon, .reset-filter {
	cursor: pointer;
}
</style>
</head>
<body>

	<div class="container">
		<div class="women_main">
			<!-- start sidebar -->
			<div class="col-md-3">
				<div class="w_sidebar filter">
					<h3 style="margin-top: 10px;">
						filter by <span
							class="glyphicon glyphicon-filter pull-right reset-filter"
							aria-hidden="true"></span>
					</h3>
					<section class="sky-form">
					<h4>
						Place Type<span
							class="glyphicon glyphicon-repeat pull-right reset-icon "
							aria-hidden="true"
							style="font-size: 14px; color: #aaaaaa; text-transform: capitalize;">Reset</span>
					</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio" name="placetype"
								value="Gym"><i></i>Gym</label> <label class="radio"><input
								type="radio" name="placetype" value="SwimmingPool"><i></i>Swimming
								Pool</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>
						Category<span
							class="glyphicon glyphicon-repeat pull-right reset-icon"
							aria-hidden="true"
							style="font-size: 14px; color: #aaaaaa; text-transform: capitalize;">Reset</span>
					</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio" name="quality"
								value="Premium"><i></i>Premium</label> <label class="radio"><input
								type="radio" name="quality" value="Regular"><i></i>Regular</label>
							<label class="radio"><input type="radio" name="quality"
								value="Economy"><i></i>Economy</label>
						</div>
					</div>
					</section>

				</div>
			</div>
			<!-- start content -->
			<div class="col-md-9 w_content">
				<div class="women">
					<h4>
						Total - <span id="total"><s:property
								value="context.placeManagementProjectorOBs.size()" /> items</span>
					</h4>
					<!-- <ul class="w_nav">
						<li>Sort :</li>
						<li><a class="active" href="#">popular</a></li>
						<li><a href="#">new </a></li>
						<li><a href="#">discount</a></li>
						<li><a href="#">price: Low High </a></li>
						<div class="clear"></div>
					</ul> -->
					<div class="row col-md-4 pull-right ">
						<div class="col-md-7" style="padding-right: 0">
							<input class="form-control" id="pincode"
								placeholder="Check Pincode" type="text" />
						</div>
						<div class="col-md-5">
							<button class="form-control btn btn-warning" id="checkPincode"
								type="button" class="">Check</button>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>



				<!-- grids_of_4 -->
				<div class="results" style="min-height: 300px">
					<s:iterator value="context.placeManagementProjectorOBs">
						<div class="col-md-3 col-sm-6 result">
							<div class="content_box">
								<input type="hidden"
									id="place<s:property value="placesDBBean.placeid"/>"
									value="<s:property value="getPlaceJson()"/>" /> <a
									href="<s:url  action='viewPlace'><s:param name="placeId" value="placesDBBean.placeid"></s:param></s:url>">
									<div class="view view-fifth">
										<img src="<s:property value="profileImagePath"/>"
											style="width: 230px; height: 200px" class="img-responsive"
											alt="" />
										<div class="mask">
											<div class="info">Quick View</div>
										</div>
									</div>
								</a>
							</div>
							<div class="caption">
								<h4>
									<a
										href="<s:url  action='viewPlace'><s:param name="placeId" value="placesDBBean.placeid"></s:param></s:url>"><s:property
											value="placesDBBean.placename" /></a>
								</h4>
								<p>
									<s:property value="placesDBBean.placetype" />
									-
									<s:property value="placesDBBean.address" />
								</p>
							</div>
							<s:if test="editable">
								<a class="btnEdit btn-blue"
									href="<s:url  action='editPlace'><s:param name="placeid" value="placesDBBean.placeid"></s:param></s:url>">Edit</a>
								<s:if test="placesDBBean.status.equals('DELETED')">Deleted</s:if>
								<s:else>
									<a class="btnEdit btn-red"
										href="<s:url  action='deletePlace'><s:param name="placeid" value="placesDBBean.placeid"></s:param></s:url>">Delete</a>
								</s:else>
							</s:if>
						</div>
					</s:iterator>


					<div class="clearfix"></div>

				</div>
				<!-- end grids_of_4 -->

				<div class="row col-md-3 pull-right ">
					<input type="button" id="seeMoreRecords" value="More"> <input
						type="button" id="seeLessRecords" value="Less">
				</div>
			</div>
			<div class="clearfix"></div>

			<!-- end content -->
		</div>
	</div>

</body>
</html>