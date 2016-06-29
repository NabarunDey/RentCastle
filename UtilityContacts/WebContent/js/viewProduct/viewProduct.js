function addToCart() {

	$.ajax({
		type: "POST",
		url: "addToCart",
		data: { productId: $('#productId').val(),rentOfferId : $('#rentOfferId').val() } ,
		success: function(response){
			
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