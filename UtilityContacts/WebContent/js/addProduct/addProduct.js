$(document).ready(function(){
	$('#subProductType'+$('#productType').val()).show();
	selectSubProductTypeValue($('#subProductType'+$('#productType').val()).val());
	$('#productType').change(function(){
		$('#subProductTypeDropdown').children().hide();
		$('#subProductType'+$('#productType').val()).show();
		selectSubProductTypeValue($('#subProductType'+$('#productType').val()).val());
	});
});

function selectSubProductTypeValue(value){
	$('#subProductTypeSelected').val(value);
}