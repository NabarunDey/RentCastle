var placeOrderEnable=false;

function placeCartOrder()
{
	if (placeOrderEnable==false)
		{
			alert('Please check delivery address before placing order');
			return;
		}
	location.href='placeCartOrder.action';
}

function checkPin() {
	 var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
	placeOrderEnable = true;
	$.ajax({
		type: "POST",
		url: "checkIfDeliveryAvailable",
		data: { addressId: $('#addressId').val(), pin: $('#pin').val(),state: $('#state').val() ,city : $('#city').val(),address: $('#address').val(),title: $('#title').val()} ,
		success: function(response){
			
			for (i = 0; i < response.orderProjectorOB.cartItems.length; i++) {
				$('.errorProductId'+response.orderProjectorOB.cartItems[i].productId).hide();
				$('.successProductId'+response.orderProjectorOB.cartItems[i].productId).hide();

				if (!response.orderProjectorOB.cartItems[i].deliveryAvailable) 
				{
					placeOrderEnable=false;
					$('.errorProductId'+response.orderProjectorOB.cartItems[i].productId).show();
				}
				else
				{
					$('.successProductId'+response.orderProjectorOB.cartItems[i].productId).show();
				}
			}
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
	lb.close();
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

	var orderstatus=$('#orderstatus'+orderid).val();
	$.ajax({
		type: "POST",
		url: "changeOrderSatus",
		data: { orderId: orderid,orderStatus: orderstatus} ,
		success: function(response){
			alert('Orderstatus changed successfully.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}