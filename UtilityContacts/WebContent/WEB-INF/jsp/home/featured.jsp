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
					<h3>Featured Products</h3>
				</div>
				<!-- grids_of_3 -->
				<div class="row grids">

					<s:iterator value="context.featuredProducts">
						<div class="col-md-3 grid1">
							<a href="viewProduct.action?productId=<s:property value="productId"/>"> <img
								src="<s:property value="imageUrl"/>" class="img-responsive" alt="" style="width: 260px; height: 260px" />
								<div class="look">
									<p>View</p>
								</div></a>
						</div>

					</s:iterator>
				</div>
				<!-- end grids_of_3 -->
			</div>
		</div>
	</div>
</body>
</html>