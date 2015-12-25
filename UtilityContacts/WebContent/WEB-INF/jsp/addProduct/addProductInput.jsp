<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form action="addProductInput" namespace="/" method="post">
		<s:textfield name="type" label="Type"></s:textfield>
		<s:textfield name="name" label="Name"></s:textfield>
		<s:textfield name="location" label="Location"></s:textfield>
		<s:textfield name="city" label="City"></s:textfield>
		<s:textfield name="state" label="State"></s:textfield>
		<s:textfield name="mobile" label="Mobile"></s:textfield>


		<s:submit value="addContact"></s:submit>
	</s:form>

</body>
</html>