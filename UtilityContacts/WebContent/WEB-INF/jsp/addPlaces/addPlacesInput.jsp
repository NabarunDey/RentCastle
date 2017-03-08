<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>i-Fit - Add Place</title>
</head>


<style>
.fileinput-new .thumbnail {
	background-color: floralwhite;
}
</style>
<div class="container">
	<div class="main">
		<h1 style="">Add Place</h1>
		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" action="addPlacesSubmit">
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Place
					Name</label>
				<div class="col-sm-4">
					<s:textfield name="placename" cssClass="form-control"
						id="placename" />
					<%-- <s:fielderror fieldName="productName"></s:fielderror> --%>
				</div>
			</div>
			<div class="form-group">
				<label for="placetype" class="col-sm-2 control-label">Place
					Type</label>
				<div class="col-sm-4">
					<s:select list="{'Gym','SwimmingPool'}" name="placetype"
						cssClass="form-control"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Profile Image</label>
				<div class="col-sm-10">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img src="" id="previewImage1" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						<div>
							<span class="btn btn-default btn-file"><span
								class="fileinput-new">Select image</span><span
								class="fileinput-exists">Change</span> <s:file id="image1"
									name="imageFile" /></span> <a href="#"
								class="btn btn-default fileinput-exists"
								data-dismiss="fileinput">Remove</a>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">Status</label>
				<div class="col-sm-4">
					<s:select list="{'AVAILABLE','NOTAVAILABLE'}" name="status"
						cssClass="form-control"></s:select>
				</div>
			</div>


			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-4">
					<s:textarea name="description" cssClass="form-control"
						id="description" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">City</label>
				<div class="col-sm-4">
					<s:textfield name="city" cssClass="form-control" id="city" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Pin</label>
				<div class="col-sm-4">
					<s:textfield name="pin" cssClass="form-control" id="pin" />
					<%-- 					<s:fielderror fieldName="deliveryCharge"></s:fielderror>
 --%>
				</div>
			</div>
			<div class="form-group">
				<label for="productState" class="col-sm-2 control-label">Address</label>
				<div class="col-sm-4">
					<s:textarea name="address" cssClass="form-control" id="address" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Days Open</label>
				<div class="col-sm-4">
					<s:textfield name="daysOpen" cssClass="form-control" id="daysOpen" />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Working Hours</label>
				<div class="col-sm-4">
					<s:textfield name="timing" cssClass="form-control" id="timing" />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Contact No 1</label>
				<div class="col-sm-4">
					<s:textfield name="contactno1" cssClass="form-control" id="contactno1" />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Contact No 2</label>
				<div class="col-sm-4">
					<s:textfield name="contactno2" cssClass="form-control" id="contactno2" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<s:textfield name="email" cssClass="form-control" id="email" />
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