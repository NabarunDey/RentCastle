<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/addProduct/addProduct.js"></script>
<style>
.fileinput-new .thumbnail {
	background-color: floralwhite;
}
</style>
<div class="container">
	<div class="main">
		<h1 style="">Edit Product</h1>
		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" action="editProductSubmitFunction">
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Product
					Name</label>
				<div class="col-sm-4">
					<s:textfield name="productName" cssClass="form-control"
						id="productName"
						value="%{context.viewProductProjectorOB.productsDBBean.productname}" />
				</div>
			</div>
			<div class="form-group">
				<label for="productType" class="col-sm-2 control-label">Product
					Type</label>
				<div class="col-sm-4">
					<s:select id="productType" name="productType"
						list="context.viewProductProjectorOB.productTypeMap" listKey="key"
						listValue="key" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group" id="subProductTypePlaceholder">
				<label id="subProductTypeLabel" for="subProductType"
					class="col-sm-2 control-label">Sub Product Type</label>
				<div class="col-sm-4" id="subProductTypeDropdown">
					<s:iterator value="context.viewProductProjectorOB.productTypeMap">
						<s:if test="value.size>=1">
							<s:select id="%{'subProductType' + #attr['key']}"
								name="subProductType" list="value" cssClass="form-control"
								onchange="selectSubProductTypeValue(this.value)"
								style="display: none" />
						</s:if>
					</s:iterator>
				</div>
			</div>
			<s:textfield type="hidden" id="subProductTypeSelected"
				name="subProductTypeSelected" />
			<div class="form-group">
				<label for="quantity" class="col-sm-2 control-label">Quantity</label>
				<div class="col-sm-4">
					<s:textfield name="quantity" cssClass="form-control" id="quantity"
						value="%{context.viewProductProjectorOB.productsDBBean.quantity}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Image</label>
				<div class="col-sm-10">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img
								src="<s:property value="%{context.viewProductProjectorOB.productImagesList.get(0)}"/>"
								id="previewImage1" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <s:file id="image1"
									name="image" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img
								src="<s:property value="%{context.viewProductProjectorOB.productImagesList.get(1)}"/>"
								id="previewImage2" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <s:file id="image2"
									name="image" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img
								src="<s:property value="%{context.viewProductProjectorOB.productImagesList.get(2)}"/>"
								id="previewImage3" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <s:file id="image3"
									name="image" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img
								src="<s:property value="%{context.viewProductProjectorOB.productImagesList.get(3)}"/>"
								id="previewImage4" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <s:file id="image4"
									name="image" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">Status</label>
				<div class="col-sm-4">
					<s:select list="{'Available','NotAvailable'}" name="status"
						cssClass="form-control"
						value="%{context.viewProductProjectorOB.productsDBBean.status}"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">Security
					Money</label>
				<div class="col-sm-4">
					<s:textfield name="securityMoney" cssClass="form-control"
						id="securityMoney"
						value="%{context.viewProductProjectorOB.productsDBBean.securitymoney}" />
				</div>
			</div>
			<div class="form-group">
				<label for="productState" class="col-sm-2 control-label">Select
					State</label>
				<div class="col-sm-4">

					<s:select list="{'West Bengal','Assam'}" name="productState"
						cssClass="form-control"
						value="%{context.viewProductProjectorOB.productsDBBean.productstate}"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="productCity" class="col-sm-2 control-label">Select
					City</label>
				<div class="col-sm-4">

					<s:select list="{'Kolkata', 'Siliguri'}" name="productCity"
						cssClass="form-control"
						value="%{context.viewProductProjectorOB.productsDBBean.productcity}"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="productPin" class="col-sm-2 control-label">Select
					Location</label>
				<div class="col-sm-4">

					<s:textfield name="productPin" cssClass="form-control" />

				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2 col-md-offset-2">
					<s:submit type="button" name="submit" theme="simple"
						cssClass="form-control btn btn-success" />
				</div>
				<div class="col-md-2">
					<s:reset type="button" name="reset" theme="simple"
						cssClass="form-control btn btn-info" />
				</div>
			</div>
		</form>
	</div>

</div>
</html>