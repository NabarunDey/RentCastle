$(document).ready(function(){
   alert('abc');
   var dropdown = document.getElementById("productTypeId");
  
   debugger;
   dropdown.onchange = function(event){
        alert("Your message");
   }
});


$('#productTypeId').change(function (event) {
alert('changed');
  });

