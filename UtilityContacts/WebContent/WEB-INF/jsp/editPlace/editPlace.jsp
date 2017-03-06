<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>RentCastle - Edit Place</title>
<script type="text/javascript" src="js/editPlace/editPlace.js"></script>

</head>


<style>
.fileinput-new .thumbnail {
	background-color: floralwhite;
}
</style>
<div class="container">
	<div class="main">
		<h1 style="">Edit Place</h1>

		<div id="errorUpdatePlace" style="display: none; color: #ff0000;">
			Error Updating Details.</div>
		<div id="successUpdatePlace" style="display: none; color: #17de69;">
			<img src="images/checkmark.png" width="30" height="30">Details
			updates successfully.
		</div>

		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" id="editPlaceSubmitForm">
			<div class="form-group">
				<label for="productName" class="col-sm-2 control-label">Place
					Name</label>
				<div class="col-sm-4">
					<s:textfield name="placename" cssClass="form-control"
						id="placename" value="%{context.placesDBBean.placename}" />
					<%-- <s:fielderror fieldName="productName"></s:fielderror> --%>
				</div>
			</div>
			<div class="form-group">
				<label for="placetype" class="col-sm-2 control-label">Place
					Type</label>
				<div class="col-sm-4">
					<s:select list="{'Gym','SwimmingPool'}" name="placetype"
						value="%{context.placesDBBean.placetype}" cssClass="form-control"></s:select>
				</div>
			</div>

			<%-- 	<div class="form-group">
				<label class="col-sm-2 control-label">Profile Image</label>
				<div class="col-sm-10">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<div class="fileinput-new thumbnail"
							style="width: 200px; height: 150px;">
							<img src="<s:property value="%{context.placesDBBean.profileImage}"/>" id="previewImage1" class="img-thumbnail">
						</div>
						<div class="fileinput-preview fileinput-exists thumbnail"
							style="width: 200px; height: 150px;"></div>
						
					</div>
				</div>
			</div> --%>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">Status</label>
				<div class="col-sm-4">
					<s:select list="{'AVAILABLE','NOTAVAILABLE'}" name="status"
						value="%{context.placesDBBean.status}" cssClass="form-control"></s:select>
				</div>
			</div>


			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description</label>
				<div class="col-sm-4">
					<s:textarea name="description" cssClass="form-control"
						value="%{context.placesDBBean.description}" id="description" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">City</label>
				<div class="col-sm-4">
					<s:textfield name="city" cssClass="form-control" id="city"
						value="%{context.placesDBBean.city}" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Pin</label>
				<div class="col-sm-4">
					<s:textfield name="pin" cssClass="form-control" id="pin"
						value="%{context.placesDBBean.pin}" />
					<%-- 					<s:fielderror fieldName="deliveryCharge"></s:fielderror>
 --%>
				</div>
			</div>
			<div class="form-group">
				<label for="productState" class="col-sm-2 control-label">Address</label>
				<div class="col-sm-4">
					<s:textarea name="address" cssClass="form-control" id="address"
						value="%{context.placesDBBean.address}" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Days
					Open</label>
				<div class="col-sm-4">
					<s:textfield name="daysOpen" cssClass="form-control" id="daysOpen" value="%{context.placesDBBean.daysOpen}" />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Working
					Hours</label>
				<div class="col-sm-4">
					<s:textfield name="timing" cssClass="form-control" id="timing" value="%{context.placesDBBean.timing}"  />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Contact
					No 1</label>
				<div class="col-sm-4">
					<s:textfield name="contactno1" cssClass="form-control"
						id="contactno1" value="%{context.placesDBBean.contactno1}"  />
				</div>
			</div>
			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Contact
					No 2</label>
				<div class="col-sm-4">
					<s:textfield name="contactno2" cssClass="form-control" value="%{context.placesDBBean.contactno2}" 
						id="contactno2" />
				</div>
			</div>

			<div class="form-group">
				<label for="security" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<s:textfield name="email" cssClass="form-control" id="email" value="%{context.placesDBBean.email}" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-md-2 col-md-offset-2">
					<input  value="Submit"  class="form-control btn btn-success"
						onclick=editPlaceSubmit()>

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