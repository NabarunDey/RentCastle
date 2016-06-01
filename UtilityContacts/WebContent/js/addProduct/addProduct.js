$(document).ready(function(){
	$('#subProductType'+$('#productType').val()).show();
	$('#productType').change(function(){
		$('#subProductTypeDropdown').children().hide();
		$('#subProductType'+$('#productType').val()).show();
	});
});

