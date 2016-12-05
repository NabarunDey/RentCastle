function changePaymentStatus(paymentid) {

	var paymentstatus=$('#paymentstatus'+paymentid).val();
	debugger;

	$.ajax({
		type: "POST",
		url: "changePaymentStatus",
		data: { paymentid: paymentid,paymentstatus: paymentstatus} ,
		success: function(response){
			alert('Payment Status Changed Successfully');
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}