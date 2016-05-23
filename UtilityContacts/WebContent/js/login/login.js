function doAjaxPost() {
	debugger;
	 /*   var name = $('#name').val();
	    var education = $('#education').val();*/
	    $.ajax({
	        type: "POST",
	        url: "loginFunction",
	        data: '',/*"name=" + name + "&education=" + education,*/
	        success: function(response){
	        console.info(response);
	        debugger;
	    },
	         error: function(e){
	             alert('Error: ' + e);
	         }
	    });
	}