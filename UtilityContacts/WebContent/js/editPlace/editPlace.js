
function editPlaceSubmit() {
	var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
	$('#successUpdatePlace').hide();
	$('#errorUpdatePlace').hide();
	$.ajax({
		type: "POST",
		url: "editPlaceSubmit",
		data: $('#editPlaceSubmitForm').serialize() ,
		success: function(response){
			$('#successUpdatePlace').show();
		},
		error: function(e){
			$('#errorUpdatePlace').show();
		}
	});
	lb.close();
	document.body.scrollTop = document.documentElement.scrollTop = 0;
}



