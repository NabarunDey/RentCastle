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

<s:if test="context.loginProjectorOB.userNotExist">
Provided Username does not Exist.
</s:if>
<s:elseif test="context.loginProjectorOB.invalidCredentials">
Incorrect Passoword
</s:elseif>


	<s:form action="loginFunction" namespace="/" method="post">
		<s:textfield name="username" label="Username"></s:textfield>
		<s:password name="password" label="Password"></s:password>
		<s:submit value="loginFunction"></s:submit>
	</s:form>

</body>
</html>