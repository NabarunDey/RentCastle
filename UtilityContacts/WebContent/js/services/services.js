function changeApprovalStatus(serviceid) {

	var approvalStatus=$('#approvalStatus'+serviceid).val();
	$.ajax({
		type: "POST",
		url: "changeServiceProviderStatus",
		data: { serviceId: serviceid,approvalStatus: approvalStatus} ,
		success: function(response){
			alert('Service Status changed successfully.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function changeServiceRequestStatus(servicereqid) {

	var status=$('#status'+servicereqid).val();
	$.ajax({
		type: "POST",
		url: "changeServiceRequestStatus",
		data: { serviceRequestId: servicereqid,serviceRequestStatus: status} ,
		success: function(response){
			alert('Service Request Status changed successfully.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}