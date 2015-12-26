<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<script>
$(document).ready(function() {
   $('#productType').change(function(event) {
      var country = $("select#productType").val();
      $.getJSON('ajaxAction', {
        countryName : country
      }, function(jsonResponse) {
        $('#ajaxResponse').text(jsonResponse.dummyMsg);
        var select = $('#category');
        select.find('option').remove();
        $.each(jsonResponse.stateMap, function(key, value) {
          $('<option>').val(key).text(value).appendTo(select);
        });
      });
      });
});
</script>
</head>
<body>

<center>
		<s:select id="productType" name="productType"
        list="{'Select Product Type','Electronics','Furniture'}" label="Select Product Type" />
        <br/>
        <br/>
        <s:select id="category" name="category" list="{'Select category'}"
        label="Select category" />
   <br />
   <br />
   <div id="ajaxResponse"></div>
</center>

</body>
</html>