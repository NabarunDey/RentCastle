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
<s:form>
<table >

<tr><s:textfield key="First Name" name="from" /></tr>
<tr><s:textfield key="Last Name" name="from" />
<s:select id= "productTypeId" name="productTypeId" list="context.addProductProjectorOB.productTypeMap" listKey="key" listValue="key" />

</tr>
<tr><s:textfield key="Username " name="from" /></tr>
<tr><s:textfield key="Quantity" name="from" /></tr>
<tr>
<td>Image :</td>
<td><s:label for="attachment" value="upload your image"/>
<s:file name="image"  /></td>
</tr>
<tr><s:textfield key="status  " name="from" /></tr>
<tr><s:textfield key="Security Money " name="from" /></tr>
<tr>
<td><s:submit type="button" name="submit" theme="simple"  />
<s:reset type="button" name="reset" theme="simple" /></td>
</tr>
</table>
</s:form>

</body>
</html>