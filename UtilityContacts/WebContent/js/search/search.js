$(function(){
	var results = $(".result");
	var btnMore = $("#seeMoreRecords");
	var btnLess = $("#seeLessRecords");
	var resultsLength = results.length;
	var currentIndex = 1;
	var actualResult = results;
	
	productsMoreLess(1);

	function productsMoreLess(noOfResults){
		results = $(".result");
		currentIndex = noOfResults;
		results.hide();
		results.slice(0, noOfResults).show(); 
		checkButton(noOfResults);
		
		btnMore.click(function (e) { 
		    e.preventDefault();
		    $(".result").slice(currentIndex, currentIndex + noOfResults).slideDown("slow");
		    currentIndex += noOfResults;
		    checkButton(noOfResults);
		});

		btnLess.click(function (e) { 
		    e.preventDefault();
		    $(".result").slice(currentIndex - noOfResults, currentIndex).slideUp( "slow");         
		    currentIndex -= noOfResults;
		    checkButton(noOfResults);
		});
		
		function checkButton(noOfResults) {
		    var currentLength = $(".result:visible").length;
		    
		    if (currentLength >= resultsLength) {
		        btnMore.hide();            
		    } else {
		        btnMore.show();   
		    }
		    
		    if (resultsLength > noOfResults && currentLength > noOfResults) {
		        btnLess.show();
		    } else {
		        btnLess.hide();
		    }
		    
		}
	}


	
	
	//Filter Code
	
	$('div.filter input[type=radio]').change(function() {
		var sectionIndex = $('section.sky-form').index($(this).parents('section'));
		if(sectionIndex == 2){
			var products = [];
			$(".result").remove();
			$('.results').append(actualResult);
			$('input[type=hidden]').each(function(){
				products.push(JSON.parse($(this).val()));
			});
			var values = $('input:radio:checked.location').map(function () {
				  return this.value;
				}).get();
			if(values.length != 0){
				for(var i=0;i<products.length;i++){
					if ($.inArray(products[i].productLocation, values) == -1 )
					{
						$(".result:eq("+i+")").remove();
					}
				}
			}
			productsMoreLess(1);
		}
    });
	
});
