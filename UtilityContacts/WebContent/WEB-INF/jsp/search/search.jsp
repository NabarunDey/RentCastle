<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/search/search.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();
		
	});
</script>
<style type="text/css">
.result {margin: 10px 0;}
</style>
</head>
<body>

	<div class="container">
		<div class="women_main">
			<!-- start sidebar -->
			<div class="col-md-3">
				<div class="w_sidebar">
					<div class="w_nav1">
						<h4>All</h4>
						<ul>
							<li><a href="women.html">women</a></li>
							<li><a href="#">new arrivals</a></li>
							<li><a href="#">trends</a></li>
							<li><a href="#">boys</a></li>
							<li><a href="#">girls</a></li>
							<li><a href="#">sale</a></li>
						</ul>
					</div>
					<h3>filter by</h3>
					<section class="sky-form">
					<h4>Product Type</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Furniture</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Electronics</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>Product Sub Type</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Bed</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Almirah</label>
								<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Refrigerator</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>WashingMachine</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>State</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Kolkata</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>City</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Kolkata</label> 
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Siliguri</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>Location</h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>Kestopur</label>
							<label class="checkbox"><input type="checkbox"
								name="checkbox" checked=""><i></i>New Town</label>
						</div>
					</div>
					</section>
				</div>
			</div>
			<!-- start content -->
			<div class="col-md-9 w_content">
				<div class="women">
					<a href="#"><h4>
							Total - <span><s:property value="context.searchProductProjectorOBs.size()" /> items</span>
						</h4></a>
					<ul class="w_nav">
						<li>Sort :</li>
						<li><a class="active" href="#">popular</a></li>
						<li><a href="#">new </a></li>
						<li><a href="#">discount</a></li>
						<li><a href="#">price: Low High </a></li>
						<div class="clear"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<!-- grids_of_4 -->
				<div class="results">
				<s:iterator value="context.searchProductProjectorOBs">
					<div class="col-md-3 col-sm-6 result">
						<div class="content_box" >
							<a href="<s:url  action='viewProduct'><s:param name="productId" value="productId"></s:param></s:url>">
								<div class="view view-fifth">
									<img src="<s:property value="imageUrl"/>" style="width: 230px; height: 200px" class="img-responsive" alt="" />
									<div class="mask">
										<div class="info">Quick View</div>
									</div>
								</div>
							</a>
						</div>
						<div class="caption">
							<h4><a href="details.html"><s:property value="productName"/></a></h4>
							<p>Rs. <s:property value="rentAmount"/> / <s:property value="periodValue"/> <s:property value="periodUnit"/></p>
						</div>
						<s:if test="context.editable">
							<a href="<s:url  action='deleteProductFunction'><s:param name="productId" value="productId"></s:param></s:url>">Delete</a>
						</s:if>
					</div>
				</s:iterator>	
				
				
					<div class="clearfix"></div>

				</div>
				<!-- end grids_of_4 -->
				<div class="row pull-right">
					<input type="button" id="seeMoreRecords" value="More">
				<input type="button" id="seeLessRecords" value="Less">
				</div>
			</div>
			<div class="clearfix"></div>

			<!-- end content -->
		</div>
	</div>

</body>
</html>