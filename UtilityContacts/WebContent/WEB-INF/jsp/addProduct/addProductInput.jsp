<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
 <script type="text/javascript" src="js/addProduct/addProduct.js"></script>
<script src="js/menu_jquery.js"></script>
<div class="container">
	<div class="main">
		<h1 style="">Add Product</h1>
			<form method="post" enctype="multipart/form-data" class="form-horizontal"
				action="addProductSubmit">
				<div class="form-group">
                        <label for="productName" class="col-sm-2 control-label">Product Name</label>
                        <div class="col-sm-4">
                        <s:textfield name="productName" cssClass="form-control" id="productName"/>
                        </div>
				</div>
				<div class="form-group">
                        <label for="productType" class="col-sm-2 control-label">Product Type</label>
                        <div class="col-sm-4">
                        <s:select id="productType" name="productType"
							list="context.addProductProjectorOB.productTypeMap" listKey="key"
							listValue="key" cssClass="form-control"/>
							</div>
				</div>	
				<div class="form-group">
                        <label for="subProductType" class="col-sm-2 control-label">Sub Product Type</label>
                        <div class="col-sm-4">
                        <s:iterator value="context.addProductProjectorOB.productTypeMap">
							<s:select id="subProductType" name="subProductType"
								list="value"  cssClass="form-control"/>
						</s:iterator>
						</div>
				</div>	
				<div class="form-group">
                        <label for="quantity" class="col-sm-2 control-label">Quantity</label>
                        <div class="col-sm-4">
                        <s:textfield name="quantity" cssClass="form-control" id="quantity"/>
                        </div>
				</div>
				<div class="form-group">
                        <label class="col-sm-2 control-label">Image</label>
                        <div class="col-sm-10">
                        <s:file id="image1" name="image" /> <s:file id="image2"
							name="image" /> <s:file id="image3" name="image" /> <s:file
							id="image4" name="image" /> <s:file id="image5" name="image" />
					<img id="previewImage1" src="" class="img-thumbnail">
					<img id="previewImage2" src="" class="img-thumbnail">
					<img id="previewImage3" src="" class="img-thumbnail">
					<img id="previewImage4" src="" class="img-thumbnail">
					<img id="previewImage5" src="" class="img-thumbnail">
					<%--Add Product Input action hit twice on using empty <img src> tag --%>
					</div>
				</div>
				<div class="form-group">
                        <label for="status" class="col-sm-2 control-label">Status</label>
                        <div class="col-sm-4">
                        <s:textfield name="status" cssClass="form-control" id="status"/>
                        </div>
				</div>
				<div class="form-group">
                        <label for="status" class="col-sm-2 control-label">Security Money</label>
                        <div class="col-sm-4">
                        <s:textfield name="securityMoney" cssClass="form-control" id="securityMoney"/>
                        </div>
				</div>
				<div class="form-group row">
					<div class="col-md-2 col-md-offset-2">
						<s:submit type="button" name="submit" theme="simple" cssClass="form-control btn btn-success" />
					</div>
					<div class="col-md-2">
                        <s:reset type="button" name="reset" theme="simple" cssClass="form-control btn btn-info" />
                   </div>
				</div>
			</form>
	</div>

</div>
</html>