<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<!-- jQuery (necessary JavaScript plugins) -->
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">



</head>
<body>
	<!-- header_top -->
	<!-- header -->

	<!-- content -->
	<div class="container">
		<div class="main">
			<div class="row content_top">
				<div class="col-md-8 content_left">
					<!-- start slider -->
					<div id="fwslider">
						<div class="slider_container">
							<div class="slide">
								<!-- Slide image -->
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('sliderImage1')"/>'
									class="img-responsive" alt="" />
								<!-- /Slide image -->
							</div>
							<!-- /Duplicate to create more slides -->
							<div class="slide">
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('sliderImage2')"/>'
									class="img-responsive" alt="" />
							</div>
							<div class="slide">
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('sliderImage3')"/>'
									class="img-responsive" alt="" />
							</div>
							<!--/slide -->
						</div>
						<div class="timers"></div>
						<div class="slidePrev">
							<span></span>
						</div>
						<div class="slideNext">
							<span></span>
						</div>
					</div>

					<!-- end  slider -->
				</div>

				<div class="col-md-3 sidebar">
					<div class="grid_list">
						<a
							href='http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionUrl1')"/>'>
							<div class="grid_img">
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionImage1')"/>'
									class="img-responsive" alt="" />
							</div>
							<div class="grid_text left">
								<h3>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionHeader1')" />
								</h3>
								<p>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionText1')" />
								</p>
							</div>
							<div class="clearfix"></div>

						</a>
					</div>
					<div class="grid_list">
						<a
							href='http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionUrl2')"/>'>
							<div class="grid_img">
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionImage2')"/>'
									class="img-responsive" alt="" />
							</div>
							<div class="grid_text left">
								<h3>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionHeader2')" />
								</h3>
								<p>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionText2')" />
								</p>
							</div>
							<div class="clearfix"></div>
						</a>
					</div>
					<div class="grid_list">
						<a
							href='http://<%=request.getServerName() %>:<%=request.getServerPort()%>${pageContext.request.contextPath}/<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionUrl3')"/>'>
							<div class="grid_img">
								<img
									src='<s:property value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionImage3')"/>'
									class="img-responsive" alt="" />
							</div>
							<div class="grid_text left">
								<h3>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionHeader3')" />
								</h3>
								<p>
									<s:property
										value="context.adsSectionProjectorOB.dynamicContentsMap.get('adsSectionText3')" />
								</p>
							</div>
							<div class="clearfix"></div>
						</a>
					</div>
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>

</body>
</html>