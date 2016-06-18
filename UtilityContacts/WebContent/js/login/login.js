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
                 $('#logout').show();
                 if(response.loginProjectorOB.userProfile.userType == "VENDOR")
                	 {
                	 $('#addProductButton').show();
                	 $('#getProductListByVendor').show();
                	 }
             }
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}