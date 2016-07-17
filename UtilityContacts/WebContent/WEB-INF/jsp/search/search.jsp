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
.reset-icon,.reset-filter{
	cursor:pointer;
}
</style>
</head>
<body>
	
	<div class="container">
		<div class="women_main">
			<!-- start sidebar -->
			<div class="col-md-3">
				<div class="w_sidebar filter">
					<h3 style="margin-top: 10px;">filter by
						<span class="glyphicon glyphicon-filter pull-right reset-filter" aria-hidden="true"></span>
					</h3>
					<section class="sky-form">
					<h4>Product Type<span class="glyphicon glyphicon-repeat pull-right reset-icon" aria-hidden="true"></span></h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio"
								name="productType" value="Furniture"><i></i>Furniture</label>
							<label class="radio"><input type="radio"
								name="productType" value="Electronics"><i></i>Electronics</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>Product Sub Type<span class="glyphicon glyphicon-repeat pull-right reset-icon" aria-hidden="true"></span></h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio"
								name="productSubtype" value="Bed"><i></i>Bed</label>
							<label class="radio"><input type="radio"
								name="productSubtype" value="Almirah"><i></i>Almirah</label>
								<label class="radio"><input type="radio"
								name="productSubtype" value="Refrigerator"><i></i>Refrigerator</label>
							<label class="radio"><input type="radio"
								name="productSubtype" value="WashingMachine"><i></i>WashingMachine</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>Location<span class="glyphicon glyphicon-repeat pull-right reset-icon" aria-hidden="true"></span></h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio" class="productLocation"
								name="productLocation" value="Kestopur"><i></i>Kestopur</label>
							<label class="radio"><input type="radio" class="productLocation"
								name="productLocation" value="Newtown"><i></i>New Town</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>City<span class="glyphicon glyphicon-repeat pull-right reset-icon" aria-hidden="true"></span></h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio"
								name="productCity" value="Kolkata"><i></i>Kolkata</label> 
							<label class="radio"><input type="radio"
								name="productCity" value="Siliguri"><i></i>Siliguri</label>
						</div>
					</div>
					</section>
					<section class="sky-form">
					<h4>State<span class="glyphicon glyphicon-repeat pull-right reset-icon" aria-hidden="true"></span></h4>
					<div class="row1 scroll-pane">
						<div class="col col-4">
							<label class="radio"><input type="radio"
								name="productState" value="West Bengal"><i></i>West Bengal</label>
						</div>
					</div>
					</section>
					
				</div>
			</div>
			<!-- start content -->
			<div class="col-md-9 w_content">
				<div class="women">
					<a href="#"><h4>
							Total - <span id="total"><s:property value="context.searchProductProjectorOBs.size()" /> items</span>
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
				<div class="results" style="min-height:300px">
				<s:iterator value="context.searchProductProjectorOBs">
					<div class="col-md-3 col-sm-6 result">
						<div class="content_box" >
						<input type="hidden" id="product<s:property value="productId"/>"  value="<s:property value="getProductJson()"/>" />
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
							<h4><a href="<s:url  action='viewProduct'><s:param name="productId" value="productId"></s:param></s:url>"><s:property value="productName"/></a></h4>
							<p>Rs. <s:property value="rentAmount"/> / <s:property value="periodValue"/> <s:property value="periodUnit"/></p>
						</div>
						<s:if test="context.editable">
							<a href="<s:url  action='editProductInputFunction'><s:param name="productId" value="productId"></s:param></s:url>">Edit</a>
							<a href="<s:url  action='deleteProductFunction'><s:param name="productId" value="productId"></s:param></s:url>">Delete</a>
						</s:if>
						<s:if test="context.admin">
							<a href="<s:url  action='editProductInputFunction'><s:param name="productId" value="productId"></s:param></s:url>">Edit</a>
							<a href="<s:url  action='deleteProductFunction'><s:param name="productId" value="productId"></s:param></s:url>">Delete</a>
							<a href="<s:url  action='deleteProductFunction'><s:param name="productId" value="productId"></s:param></s:url>">Delete</a>
						</s:if>
					</div>
				</s:iterator>	
				
				
					<div class="clearfix"></div>

				</div>
				<!-- end grids_of_4 -->
				<div class="row col-md-3 pull-right ">
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