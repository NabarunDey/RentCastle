function addToCart() {

	$.ajax({
		type: "POST",
		url: "addToCart",
		data: { productId: $('#productId').innerHtml} ,
		success: function(response){
			
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}