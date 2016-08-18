$(document).ready(function(){
	var total = 0;
	$('.orders table tbody tr').each(function(){
		total += parseInt($('td:eq(1)',this).html().substring(4))+parseInt($('td:eq(2)',this).html().substring(4));
		$('td:eq(3)',this).html('Rs. '+(parseInt($('td:eq(1)',this).html().substring(4))+parseInt($('td:eq(2)',this).html().substring(4))));
	});
	$('.orders table tfoot tr td:eq(3)').html('Total Amount: Rs. '+total);
});

function checkPin() {

	$.ajax({
		type: "POST",
		url: "checkIfDeliveryAvailable",
		data: { pin: $('#pin').val(),state: $('#state').val() ,city : $('#city').val(),address: $('#address').val(),title: $('#title').val()} ,
		success: function(response){
			debugger;
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function populateCity() {

	var state = document.getElementById('state').value;
	var cityDropdown = document.getElementById('city');
	cityDropdown.innerHTML = "";
	if(state === "West Bengal")
	{
		var opt = document.createElement('option');
		opt.value = "Kolkata";
		opt.innerHTML = "Kolkata";
		cityDropdown.appendChild(opt);
		var opt1 = document.createElement('option');
		opt1.value = "Siliguri";
		opt1.innerHTML = "Siliguri";
		cityDropdown.appendChild(opt1);
	}
	if(state === "Assam")
	{
		var opt = document.createElement('option');
		opt.value = "Dhubri";
		opt.innerHTML = "Dhubri";
		cityDropdown.appendChild(opt);
		var opt1 = document.createElement('option');
		opt1.value = "Guwahati";
		opt1.innerHTML = "Guwahati";
		cityDropdown.appendChild(opt1);
	}
}

function changeOrderStatus(orderid) {

	var orderstatus=$('#status'+orderid).val();
	$.ajax({
		type: "POST",
		url: "changeOrderSatus",
		data: { orderId: orderid,orderStatus: orderstatus} ,
		success: function(response){
			debugger;
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}