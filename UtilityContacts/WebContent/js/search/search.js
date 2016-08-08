$(function(){
	var results = $(".result");
	var btnMore = $("#seeMoreRecords");
	var btnLess = $("#seeLessRecords");
	var resultsLength = results.length;
	var currentIndex = 1;
	var actualResult = results;
	
	productsMoreLess(4);

	function productsMoreLess(noOfResults){
		results = $(".result");
		resultsLength = results.length;
		currentIndex = noOfResults;
		results.hide();
		results.slice(0, noOfResults).show(); 
		checkButton();
		btnMore.unbind('click');
		btnLess.unbind('click');
		
		btnMore.click(function (e) { 
		    e.preventDefault();
		    showLoader(more);
		    
		});

		btnLess.click(function (e) { 
		    e.preventDefault();
		    showLoader(less);
		    
		});
		
		function more(){
			$(".result:lt("+(currentIndex+noOfResults)+")").show();
		    if(currentIndex != resultsLength)
			    currentIndex += noOfResults;
			checkButton();
		}
		
		function less(){
			$(".result:gt("+(currentIndex-noOfResults-1)+")").hide();  
		    if(currentIndex != noOfResults)
			    currentIndex -= noOfResults;
			    checkButton();
		}
		
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

	function resetProducts(){
		$(".result").remove();
		$('.results').append(actualResult);
	}
	
	
	//Filter Code
	
	$('div.filter input[type=radio]').change(function() {
		showLoader(filter);
    });
	
	
	function filter(){
		
		resetProducts();
		$('input:radio:checked').each(function(){
			performFilter($(this).attr('name'));
		})
		$('#total').html($('.result').length+" items");
		productsMoreLess(1);
	}
	
	function performFilter(filterBy){
		var products = [];
		$('input[type=hidden]').each(function(){
			products.push(JSON.parse($(this).val()));
		});
		var values = $('input[name='+filterBy+']:radio:checked').map(function () {
			  return this.value;
			}).get();
		if(values.length != 0){
			$(".result").each(function(i){
				if ($.inArray(products[i][filterBy], values) == -1 )
				{
					$(this).remove();
				}
			});
		}
	}
	
	$('span.reset-icon').click(function(e){
		var index = $(this).index('span.reset-icon');
		$('section.sky-form:eq('+index+') input:radio').prop('checked', false);
		showLoader(filter);
	});
	
	$('span.reset-filter').click(function(e){
		$('section.sky-form input:radio').prop('checked', false);
		showLoader(filter);
	});
	
	$('#checkPincode').click(function(){
		showLoader(checkPincode);
	});
	
	function checkPincode(){
		resetProducts();
		var products = [];
		$('input[type=hidden]').each(function(){
			products.push(JSON.parse($(this).val()));
		});
		if($('#pincode').val() != ''){
			$(".result").each(function(i){
				console.log(products[i]["productPin"]);
				if ($.inArray($('#pincode').val(), products[i]["productPin"].split("|")) == -1 )
				{
					$(this).remove();
				}
			});
		}
		$('#total').html($('.result').length+" items");
		productsMoreLess(1);
	}
	
});
