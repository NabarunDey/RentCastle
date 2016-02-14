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

<s:form action="userRegistrationConfirm">

<table >
<tr><s:textfield key="Email Id"  name="username"/></tr>
<tr><s:textfield key="First Name"  name="firstname"/></tr>
<tr><s:textfield key="Last Name" name="lastname" /></tr>
<tr><s:password key="Password" name="password" /></tr>
<tr><s:password key="Re-enter Password" name="rePassword" /></tr>
<tr><s:select label="User Type" headerKey="-1"  list="#{'CUSTOMER':'Customer', 'VENDOR':'Vendor'}" name="usertype" value = "#{'usertype'}"/></tr>     
<tr><s:select label="Gender" headerKey="-1"  list="#{'Gender1':'Male', 'Gender2':'Female'}" name="yourName" value = "#{'Gender'}"/></tr>     
<s:textarea label="Address" name="address" />
<tr><s:select label="City" headerKey="-1" list="#{'Kolkata':'Kolkata', 'Siliguri':'Siliguri'}" name="city" value = "#{'city'}"/></tr>  
<tr><s:select label="State" headerKey="-1"  list="#{'West Bengal':'West Bengal', 'Assam':'Assam'}" name="state" value = "#{'state'}"/></tr>
<tr><s:textfield key="Pincode" name = "pincode" /></tr>
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