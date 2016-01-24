<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<!-- your webpage info goes here -->

<title>My First Website</title>

<meta name="author" content="your name" />
<meta name="description" content="" />

<!-- you should always add your stylesheet (css) in the head tag so that it starts loading before the page html is being displayed -->
<link rel="stylesheet" href="style.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="js/addProduct/addProduct.js"></script>
<script type="text/javascript">
	
</script>
<style>
/*
* multi-line comment
*/
p {
	line-height: 1em;
}

h1, h2, h3, h4 {
	color: orange;
	font-weight: normal;
	line-height: 1.1em;
	margin: 0 0 .5em 0;
}

h1 {
	font-size: 1.7em;
}

h2 {
	font-size: 1.5em;
}

a {
	color: black;
	text-decoration: none;
}

a:hover, a:active {
	text-decoration: underline;
}

/* you can structure your code's white space so that it is as readable for when you come back in the future or for other people to read and edit quickly */
body {
	font-family: arial;
	font-size: 80%;
	line-height: 1.2em;
	width: 100%;
	margin: 0;
	background: #eee;
}
/* you can put your code all in one line like above */
#page {
	margin: 20px;
}

/* or on different lines like below */
#logo {
	width: 35%;
	margin-top: 5px;
	font-family: georgia;
	display: inline-block;
}
/* but try and be as concise as possible */
#nav {
	width: 60%;
	display: inline-block;
	text-align: right;
	float: right;
}

#nav ul {
	
}

#nav ul li {
	display: inline-block;
	height: 62px;
}

#nav ul li a {
	padding: 20px;
	background: orange;
	color: white;
}

#nav ul li a:hover {
	background-color: #ffb424;
	box-shadow: 0px 1px 1px #666;
}

#nav ul li a:active {
	background-color: #ff8f00;
}

#content {
	margin: 80px 0;
	background: white;
	padding: 140px;
	clear: both;
	border: 1px double #3090C7; -
	-border-style: dashed 2px #3090C7; -
	-outline: 1px solid darkblue;
}

#footer {
	bottom: 1px #ccc solid;
	margin-bottom: 10px;
}

#footer p {
	text-align: right;
	text-transform: uppercase;
	font-size: 80%;
	color: grey;
}

/* multiple styles seperated by a , */
#content, ul li a {
	box-shadow: 0px 1px 1px #999;
}
</style>

</head>
<body>

	<!-- webpage content goes here in the body -->

	<div id="page">
		<div id="logo">
			<h1>
				<a href="/" id="logoLink">He He He!!</a>
			</h1>
		</div>
		<div id="nav">
			<ul>
				<li><a href="#/home.html">Home</a></li>
				<li><a href="#/about.html">About</a></li>
				<li><a href="#/contact.html">Contact</a></li>
			</ul>
		</div>
		<div id="content">
			<h1 style="">Add Product</h1>


			<s:form theme="xhtml" method="post" enctype="multipart/form-data"
				action="addProductRecap">
				<table>

					<tr>
						<s:textfield key="Product Id " name="from" />
					</tr>
					<tr>
						<s:textfield key="Product Type" name="from" />
						<s:select id="productTypeId" name="productTypeId"
							list="context.addProductProjectorOB.productTypeMap" listKey="key"
							listValue="key" />
						
					</tr>
					<tr>
						<s:textfield key="Username " name="from" />
					</tr>
					<tr>
						<s:textfield key="Quantity" name="from" />
					</tr>
					<tr>
						<td>Image :</td>
						<td><s:label for="attachment" value="upload your image" /> <s:file
								id = "image" name="image" onchange="previewImage(this)"/></td>
								<img id="previewImage" src="#" style="height: 100px;">
					</tr>
					<tr>
						<s:textfield key="status  " name="from" />
					</tr>
					<tr>
						<s:textfield key="Security Money " name="from" />
					</tr>
					<tr>
						<td><s:submit type="button" name="submit" theme="simple" />
							<s:reset type="button" name="reset" theme="simple" /></td>
					</tr>
				</table>
			</s:form>

		</div>
		<div id="footer">
			<marquee direction="left">
				<font color="red">testing 
			</marquee>
			</font>
			<p>
				Webpage made by <a href="/" target="_blank">[Abhisek Ojha]</a>
			</p>
		</div>
	</div>
</body>
</html>