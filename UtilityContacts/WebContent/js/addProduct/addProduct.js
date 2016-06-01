$(document).ready(function(){
	var dropdown = document.getElementById("productType");
	dropdown.onchange = function(event){
        $('#subProductTypePlaceholder').show();
        $("#subProductTypePlaceholder").children().hide(); 
        $('#subProductTypeLabel').show();
        $('#subProductTypeDropdown').show();
        $("#subProductTypeDropdown").children().hide(); 
		$('#subProductType'+$('#productType').val()).show();
		
	}
});

