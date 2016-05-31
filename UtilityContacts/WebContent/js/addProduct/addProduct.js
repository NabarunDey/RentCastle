$(document).ready(function(){
	var dropdown = document.getElementById("productType");
	dropdown.onchange = function(event){
		alert("Your message");
	}
	
	var images = $('input[id^="image"]');
	images.each(function(i){
		$(this).change(function(event){
			
			if (this.files && this.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$("#previewImage"+(i+1)).attr("src", e.target.result).css({height:'100px',margin:'5px'});
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
	});
});

