$(document).ready(function(){
	var dropdown = document.getElementById("productTypeId");
	dropdown.onchange = function(event){
		alert("Your message");
	}
	var image1=document.getElementById("image1");
	var image2=document.getElementById("image2");
	var image3=document.getElementById("image3");
	var image4=document.getElementById("image4");
	var image5=document.getElementById("image5");
	
	
	image1.onchange = function(event){
		if (image1.files && image1.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage1').attr('src', e.target.result);
			}
			reader.readAsDataURL(image1.files[0]);
		}
	}
	
	image2.onchange = function(event){
		if (image2.files && image2.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage2').attr('src', e.target.result);
			}
			reader.readAsDataURL(image2.files[0]);
		}
	}
	
	image3.onchange = function(event){
		if (image3.files && image3.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage3').attr('src', e.target.result);
			}
			reader.readAsDataURL(image3.files[0]);
		}
	}
	
	image4.onchange = function(event){
		if (image4.files && image4.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage4').attr('src', e.target.result);
			}
			reader.readAsDataURL(image4.files[0]);
		}
	}
	
	image5.onchange = function(event){
		if (image5.files && image5.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage5').attr('src', e.target.result);
			}
			reader.readAsDataURL(image5.files[0]);
		}
	}
	
});

