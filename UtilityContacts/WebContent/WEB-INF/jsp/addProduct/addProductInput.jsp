<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
 <script type="text/javascript" src="js/addProduct/addProduct.js"></script>
 
<div class="container">
	<div class="main">
		<h1 style="">Add Product</h1>

		<table>
			<s:form theme="xhtml" method="post" enctype="multipart/form-data"
				action="addProductConfirm">


				<tr>
					<td>Product Name :</td>
					<s:textfield name="productName" />
				</tr>
				<tr>
					<td>Product Type :</td>
					<td><s:select id="productType" name="productType"
							list="context.addProductProjectorOB.productTypeMap" listKey="key"
							listValue="key" /></td>
				</tr>

				<tr>
					<td>Sub Product Type :</td>

					<s:iterator value="context.addProductProjectorOB.productTypeMap">
						<td><s:select id="subProductType" name="subProductType"
								list="value"  /></td>
					</s:iterator>
				</tr>
				
				<tr>
					<td>Quantity :</td>
					<s:textfield name="quantity" />
				</tr>
				<tr>
					<td>Image :</td>
					<td><s:file id="image1" name="image" /> <s:file id="image2"
							name="image" /> <s:file id="image3" name="image" /> <s:file
							id="image4" name="image" /> <s:file id="image5" name="image" />

					</td>
					<img id="previewImage1" src="#" style="height: 100px;">
					<img id="previewImage2" src="#" style="height: 100px;">
					<img id="previewImage3" src="#" style="height: 100px;">
					<img id="previewImage4" src="#" style="height: 100px;">
					<img id="previewImage5" src="#" style="height: 100px;">
					<%--Add Product Input action hit twice on using empty <img src> tag --%>
				</tr>
				<tr>
					<td>Status :</td>
					<s:textfield name="status" />
				</tr>
				<tr>
					<td>Security Money :</td>
					<s:textfield name="securityMoney" />
				</tr>
				<tr>
					<td><s:submit type="button" name="submit" theme="simple" /> <s:reset
							type="button" name="reset" theme="simple" /></td>
				</tr>
			</s:form>
		</table>

	</div>

</div>
</html>