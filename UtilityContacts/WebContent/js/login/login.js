function doAjaxPost() {

	$.ajax({
		type: "POST",
		url: "loginFunction",
		data: $('#loginForm').serialize() ,
		success: function(response){
			if (!response.loginProjectorOB.invalidCredentials) {
				$('#loginBox').hide();
				$('#loginButton').hide();
				$('#createAccount').hide();
				$('#loggedin').text("Welcome "+response.loginProjectorOB.userProfile.firstName);
				$('#loggedin').show();
				$('#logout').show();
				$('#buyButton').show();
				$('#addToCartButton').show();
				$('#paymentHistory').show();
				if(response.loginProjectorOB.userProfile.userType == "VENDOR")
				{
					$('#addProductButton').show();
					$('#getProductListByVendor').show();
				}
				if(response.loginProjectorOB.userProfile.userType == "CUSTOMER")
				{
					$('#orderHistory').show();
				}
				if(response.loginProjectorOB.userProfile.userType == "ADMIN")
				{
					$('#getOrdersForAdmin').show();
				}
			}
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}