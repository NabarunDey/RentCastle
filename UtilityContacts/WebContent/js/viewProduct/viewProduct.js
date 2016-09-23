function addToCart() {
	
	if("" == $("#rentOfferId").val())
		{
			alert("Please select a RentOffer");
			return;
		}
	
	$.ajax({
		type: "POST",
		url: "addToCart",
		data: { productId: $('#productId').val(),rentOfferId : $('#rentOfferId').val() } ,
		success: function(response){
				alert('Item sucessfully added to cart.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function selectRentId(rentId) {
	var z= rentId.split("rentOffer");
	var a=z[1];
	$("#rentOfferId").val(a);
}

function changeApprovalStatus() {

	$.ajax({
		type: "POST",
		url: "changeApprovalStatus",
		data: { productId: $('#productId').val(),approvalStatus : $('#approvalStatus').val() } ,
		success: function(response){
				alert('Item approved.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}