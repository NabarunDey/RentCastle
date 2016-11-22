function endRent(holdingId) {

	var r= confirm("Do you really want to return this product?");
	if (r== true){
		$.ajax({
			type: "POST",
			url: "endCurrentHolding",
			data: { holdingId: holdingId } ,
			success: function(response){
				$('#holding'+holdingId).hide();
				alert('End request has been submitted.')
			},
			error: function(e){
				alert('Error: ' + e);
			}
		});
	}
}

