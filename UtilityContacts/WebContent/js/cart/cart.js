function removeFromCart(productIdX,rentOfferIdX) {

	$.ajax({
		type: "POST",
		url: "removeFromCart",
		data: { productId: productIdX,rentOfferId : rentOfferIdX } ,
		success: function(response){
			$('#cart'+productIdX+'-'+rentOfferIdX).hide();
			alert('Item sucessfully removed from cart.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}


