<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<div class="container">
		<div class="main">
			<div class="content">
				<div class="content_text">
					<h2>Featured Places</h2>
				</div>
				<!-- grids_of_3 -->
				<div class="row grids">

					<s:iterator value="context.placeManagementProjectorOBs">
						<div class="col-md-3 grid1 roundBorder">
							<a
								href="viewPlace?placeId=<s:property value="placesDBBean.placeid"/>">
								<img src="<s:property value="profileImagePath"/>"
								class="img-responsive" alt=""
								style="width: 262.5px !important; height: 220px !important;" />
								<div class="look" >
								<h4><s:property value="placesDBBean.placename"/></h4>
								</div>
							</a>
							
						</div>

					</s:iterator>
				</div>
				<!-- end grids_of_3 -->
			</div>
		</div>
	</div>
</body>
</html>