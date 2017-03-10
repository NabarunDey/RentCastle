$(document).ready(function() {
	var max_fields      = 20; //maximum input boxes allowed
	var wrapper         = $("#facilitiesSection"); //Fields wrapper
	var add_button      = $("#addFacility"); //Add button ID

	var x = 1; //initlal text box count
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
		if(x < max_fields){ //max input box allowed
			x++; //text box increment
			$(wrapper).append('<div><input type="text" name="facilitiesDescription" style="width: 600px;"><a href="#" class="remove_field">Remove</a></div> <br> </div>'); //add input box
		}
	});

	var max_fields1      = 20; //maximum input boxes allowed
	var wrapper1         = $("#priceSection"); //Fields wrapper
	var add_button1      = $("#addPrice"); //Add button ID

	var x1 = 1; //initlal text box count
	$(add_button1).click(function(e){ //on add input button click
		e.preventDefault();
		if(x1 < max_fields1){ //max input box allowed
			x1++; //text box increment
			$(wrapper1).append('<div><input type="text" name="price" style="width: 600px;"><a href="#" class="remove_field1">Remove</a></div> <br> </div>'); //add input box
		}
	});

	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x--;
	})

	$(wrapper1).on("click",".remove_field1", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); x1--;
	})
	
});

function editFacility()
{
	$("#viewFacilitiesSection").hide();
	$("#editFacilitiesSection").show();
	$("#addFacilitiesSubmitButton").hide();
	$("#editFacilitySubmitButton").show();
	$("#facilitiesSection").hide();
	$("#addFacility").hide();


}

function editFacilitySubmit()
{
	var elements = document.getElementsByClassName("facilitieClassEdit");
	var ds = '';
	for(var i=0; i<elements.length; i++) {
		ds += elements[i].value+',';
	}

	
	location.href='updateFacilites?facilitiesDescription='+ds;
}

function editPrice()
{
	$("#viewPriceSection").hide();
	$("#editPriceSection").show();
	$("#addPriceSubmitButton").hide();
	$("#editPriceSubmitButton").show();
	$("#priceSection").hide();
	$("#addPrice").hide();


}

function editPriceSubmit()
{
	var elements = document.getElementsByClassName("priceClassEdit");
	var ds = '';
	for(var i=0; i<elements.length; i++) {
		ds += elements[i].value+',';
	}

	
	location.href='updatePrice?price='+ds;
}

function editPlace()
{
	var data=$("#placeId").val();
	location.href='editPlace?placeid='+data;
}

function deletePlace()
{
	var data=$("#placeId").val();
	location.href='deletePlace?placeid='+data;
}

function changePlaceApprovalStatus() {
	var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
	$.ajax({
		type: "POST",
		url: "changePlaceApprovalStatus",
		data: {placeid :$('#placeId').val(), approvalStatus : $('#approvalStatus').val() } ,
		success: function(response){
			alert('Approval status changed.')
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
	lb.close();
}

function deleteImage(imagePath,thumbId) {

	var r = confirm("Are you sure?");
	if (r == true) 
	{
		var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
		$.ajax({
			type: "POST",
			url: "deleteImage",
			data: {imagePath :imagePath } ,
			success: function(response){
			},
			error: function(e){
				alert('Error: ' + e);
			}
		});
		$('#myThumb'+thumbId).hide();
		lb.close();
	} 	
}


