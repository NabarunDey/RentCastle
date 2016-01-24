<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tiles:importAttribute name="jsList" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="jsfile" items="${jsList}">
		<script src="<c:url value="${jsfile}"/>"></script>
	</c:forEach>

	hello from base layout

	<hr />
	<tiles:insertAttribute name="menu" />
	<br />
	<hr />
	<tiles:insertAttribute name="body" />
	<br />
	<hr />
	<br />
</body>
</html>