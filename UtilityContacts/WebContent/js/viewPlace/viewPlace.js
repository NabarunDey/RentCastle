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
            x++; //text box increment
            $(wrapper1).append('<div><input type="text" name="price" style="width: 600px;"><a href="#" class="remove_field">Remove</a></div> <br> </div>'); //add input box
        }
    });
   
    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault(); $(this).parent('div').remove(); x--;
    })
});