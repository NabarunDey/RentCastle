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
				$('#paymentHistory').show();editProfile
				$('#editProfile').show();
				
				if(response.loginProjectorOB.userProfile.userType == "VENDOR")
				{
					$('#orderHistoryVendor').show();
					$('#addProductButton').show();
					$('#getProductListByVendor').show();
				}
				if(response.loginProjectorOB.userProfile.userType == "CUSTOMER")
				{
					$('#myCart').show();
					$('#orderHistory').show();
				}
				if(response.loginProjectorOB.userProfile.userType == "ADMIN")
				{
					$('#getOrdersForAdmin').show();
					$('#getPendingProducts').show();
				}
			}
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function forgotPasswordSubmit() {

	$.ajax({
		type: "POST",
		url: "forgotPasswordSubmit",
		data: $('#ForgotPassword_form').serialize() ,
		success: function(response){
			if (response.loginProjectorOB.userNotExist) {
				$('#errorUserNotExist').show();
				return;
			}
			if (!response.loginProjectorOB.mailSent) {
				$('#errorMailNotSent').show();
				return;
			}
			$('#successForgotPassword').show();
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

