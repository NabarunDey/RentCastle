<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="/Struts2Example/struts/xhtml/styles.css" type="text/css"/> 
<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
</head>
<body>

<s:form>

<table >

<tr><s:textfield key="First Name"  /></tr>
<tr><s:textfield key="Last Name"  /></tr>
<tr><s:password key="password" /></tr>
<tr><s:select label="Gender" headerKey="-1" headerValue="Gender" list="#{'Gender1':'Male', 'Gender2':'Female'}" name="yourName" value = "#{'Gender'}"/></tr>     
<s:textarea label="Address" name="address" />
<tr><s:select label="city" headerKey="-1" headerValue="city" list="#{'city1':'kolkata', 'city2':'delhi'}" name="yourName" value = "#{'city'}"/></tr>  
<tr><s:select label="state" headerKey="-1" headerValue="state" list="#{'state1':'west bengal', 'state2':'delhi'}" name="yourName" value = "#{'state'}"/></tr>
<tr><s:textfield key="Pincode"  /></tr>
<tr>
<td><s:submit type="button" name="submit" theme="simple" />
<s:reset type="button" name="reset" theme="simple" /></td>

</tr>
<tr>
</tr>


</table>
</s:form>

</body>
</html>