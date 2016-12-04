function addToCart() {
	
	if("" == $("#rentOfferId").val())
		{
			alert("Please select a RentOffer");
			return;
		}
	
	$.ajax({
		type: "POST",
		url: "addToCart",
		data: { productId: $('#productId').val(),rentOfferId : $('#rentOfferId').val() } ,
		success: function(response){
			var itemImg = document.getElementById("imgId");
		    flyToElement($(itemImg), $('.profile_img'));
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
	
}

function selectRentId(rentId) {
	var z= rentId.split("rentOffer");
	var a=z[1];
	$("#rentOfferId").val(a);
}

function changeApprovalStatus() {

	$.ajax({
		type: "POST",
		url: "changeApprovalStatus",
		data: { productId: $('#productId').val(),approvalStatus : $('#approvalStatus').val() } ,
		success: function(response){
				alert('Item approved.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}


function flyToElement(flyer, flyingTo) {
    var $func = $(this);
    var divider = 3;
    var flyerClone = $(flyer).clone();
    $(flyerClone).css({position: 'absolute', top: $(flyer).offset().top + "px", left: $(flyer).offset().left + "px", opacity: 1, 'z-index': 1000});
    $('body').append($(flyerClone));
    var gotoX = $(flyingTo).offset().left + ($(flyingTo).width() / 2) - ($(flyer).width()/divider)/2;
    var gotoY = $(flyingTo).offset().top + ($(flyingTo).height() / 2) - ($(flyer).height()/divider)/2;
     
    $(flyerClone).animate({
        opacity: 0.4,
        left: gotoX,
        top: gotoY,
        width: $(flyer).width()/divider,
        height: $(flyer).height()/divider
    }, 700,
    function () {
        $(flyingTo).fadeOut('fast', function () {
            $(flyingTo).fadeIn('fast', function () {
                $(flyerClone).fadeOut('fast', function () {
                    $(flyerClone).remove();
                });
            });
        });
    });
}