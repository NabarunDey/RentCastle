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

function enableAutoRenew(holdingId) {

	$.ajax({
		type: "POST",
		url: "enableAutoRenew",
		data: { holdingId: holdingId } ,
		success: function(response){
			alert('Auto Renew Enabled.');
			$('#enableAutoRenewId'+holdingId).hide();
			$('#disableAutoRenewId'+holdingId).show();
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function disableAutoRenew(holdingId) {

	$.ajax({
		type: "POST",
		url: "diableAutoRenew",
		data: { holdingId: holdingId } ,
		success: function(response){
			alert('Auto Renew Disabled.');
			$('#disableAutoRenewId'+holdingId).hide();
			$('#enableAutoRenewId'+holdingId).show();
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}
