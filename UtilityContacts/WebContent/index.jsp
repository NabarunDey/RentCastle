<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Hello World</title>
</head>
<body>

	<h1>Hello World From Struts2 - Spring integration</h1>

	
	<s:form action="login" namespace="/loginPackage" method="post">
		<s:textfield name="username" label="Username"></s:textfield>
		<s:textfield name="password" label="Password"></s:textfield>
		<s:submit value="login"></s:submit>
	</s:form>
 
	<s:form action="addContact" namespace="/contactPackage" method="post">
		<s:textfield name="type" label="Type"></s:textfield>
		<s:textfield name="name" label="Name"></s:textfield>
		<s:textfield name="location" label="l=Location"></s:textfield>
		<s:textfield name="city" label="City"></s:textfield>
		<s:textfield name="state" label="State"></s:textfield>
		<s:textfield name="mobile" label="Mobile"></s:textfield>


		<s:submit value="addContact"></s:submit>
	</s:form>

</body>
</html>