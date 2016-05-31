function doAjaxPost() {

	$.ajax({
		type: "POST",
		url: "loginFunction",
		data: $('#loginForm').serialize() ,
		success: function(response){
			 if (!response.loginProjectorOB.invalidCredentials) {
                 $('#loginBox').hide();
                 $('#loginButton').hide();
                 $('#loggedin').text("Welcome "+response.loginProjectorOB.userProfile.firstName);
                 $('#loggedin').show();
             }
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}