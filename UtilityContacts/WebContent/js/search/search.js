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
		resultsLength = results.length;
		currentIndex = noOfResults;
		results.hide();
		results.slice(0, noOfResults).show(); 
		checkButton();
		
		btnMore.click(function (e) { 
		    e.preventDefault();
		    $(".result:lt("+(currentIndex+noOfResults)+")").slideDown("slow",function(){
		    	if(currentIndex != resultsLength)
				    currentIndex += noOfResults;
				    checkButton();
		    });
		    
		});

		btnLess.click(function (e) { 
		    e.preventDefault();
		    $(".result:gt("+(currentIndex-noOfResults-1)+")").slideUp( "slow",function(){
		    	if(currentIndex != noOfResults)
				    currentIndex -= noOfResults;
				    checkButton();
		    });  
		    
		});
		
		$('#total').html(resultsLength+" items");
		
		function checkButton() {
		    var currentLength = $(".result:visible").length;
		    if(currentLength<resultsLength)
		    	btnMore.show();
		    if(currentLength==resultsLength)
		    	btnMore.hide();
		    if(currentLength<=noOfResults)
		    	btnLess.hide();
		    if(currentLength>noOfResults)
		    	btnLess.show();
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
				$(".result").each(function(i){
					if ($.inArray(products[i].productLocation, values) == -1 )
					{
						$(this).remove();
					}
				});
			}
			productsMoreLess(1);
		}
    });
	
});
