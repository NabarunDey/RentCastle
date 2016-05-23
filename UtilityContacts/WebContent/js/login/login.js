function doAjaxPost() {

	$.ajax({
		type: "POST",
		url: "loginFunction",
		data: $('#loginForm').serialize() ,
		success: function(response){

		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}