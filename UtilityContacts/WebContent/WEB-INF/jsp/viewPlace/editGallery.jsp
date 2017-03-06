<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>RentCastle - Edit Gallery</title>
<link href="css/thumbnail-gallery.css" rel='stylesheet' type='text/css' />
<script type="text/javascript" src="js/viewPlace/viewPlace.js"></script>

</head>


<div class="container">
	<div class="main">

		<a href="<s:url action = 'viewPlace' ></s:url>"><img alt="" src="images/backButton.png"
			 /></a>
		<h1 style="">Gallery</h1>

		<div class="row">

			<s:iterator value="context.viewPlaceProjectorOB.imagesList" status="status">
			<s:div id='%{"myThumb" + #status.count}'>
				<div class="col-lg-3 col-md-4 col-xs-6 thumb" id="<s:property value = 'imagepath' />" >
					<a class="thumbnail" href="#"> <img class="img-responsive"
						src="<s:property value = 'imagepath' />" />
					</a> <input class="form-control btn btn-success" value="Delete" 
						onclick=deleteImage('<s:property value = "imagepath" />','<s:property value = "#status.count" />') />
				</div>
				</s:div>
			</s:iterator>
		</div>

	</div>

</div>
</html>