<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Rent Offer</title>
<script type="text/javascript" src="js/addProduct/addRentOffers.js"></script>
<style type="text/css">
.offerno{
	display:inline-block;
}
.panelFooter{
	padding:20px 15px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header_top">
			<h3 class="text-center">Please add rent details</h3>
		</div>
		<form method="post" enctype="multipart/form-data"
			class="form-horizontal" action="addRentOffersSubmit">
			<div class="panel panel-primary multioffers">
				<div class="panel-heading">Offers</div>
				<div class="panel-body offers">
					<div class="panel panel-primary offer">
						<div class="panel-heading">
							Offer: <label class="offerno">1</label>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="periodunit" class="col-sm-2 control-label">Period
									Unit</label>
								<div class="col-sm-4">
									<s:select list="{'Days','Months','Years'}" name="periodunit"
										cssClass="form-control"></s:select>
								</div>
							</div>
							<div class="form-group">
								<label for="periodvalue" class="col-sm-2 control-label">Period
									Value</label>
								<div class="col-sm-4">
									<s:textfield name="periodvalue" cssClass="form-control" id="periodvalue"></s:textfield>
								</div>
							</div>
							<div class="form-group">
								<label for="rentAmount" class="col-sm-2 control-label">Rent
									Amount</label>
								<div class="col-sm-4">
									<s:textfield name="rentAmount" cssClass="form-control" id="rentAmount"></s:textfield>
								</div>
							</div>
							<button type="button" class="btn btn-danger remove">Remove
								Offer</button>
						</div>
					</div>
				</div>
				<div class="panelFooter">
					<button type="button" class="btn btn-primary add">Add
						Offer</button>
				</div>
				<div class="panelFooter ">
					<s:submit type="button" name="submit" theme="simple"
							cssClass="btn btn-success btn-lg" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>