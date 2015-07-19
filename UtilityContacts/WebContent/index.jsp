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

	<s:form action="login" namespace="" method="post" >
		<s:textfield name="firstName" label="First Name :"></s:textfield>
		<s:textfield name="lastName" label="Last Name :"></s:textfield>
		<s:submit value="login"></s:submit>
	</s:form>

</body>
</html>