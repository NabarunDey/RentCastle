$(document).ready(function(){
	var dropdown = document.getElementById("productTypeId");
	dropdown.onchange = function(event){
		alert("Your message");
	}
	var image=document.getElementById("image");
	image.onchange = function(event){
		if (image.files && image.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage').attr('src', e.target.result);
			}
			reader.readAsDataURL(image.files[0]);
		}
	}
});

