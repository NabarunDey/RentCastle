function helpRequestSubmit() {

	$.ajax({
		type: "POST",
		url: "helpRequestSubmit",
		data: $('#helpRequest_form').serialize() ,
		success: function(response){
			$('#successRequestSubmit').hide();
			$('#errorRequestSubmit').hide();
			if (response.helpRequestSubmitSuccess) {
				$('#successRequestSubmit').show();
				return;
			}
			$('#errorRequestSubmit').show();
			return;
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}
