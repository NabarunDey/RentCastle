$(function(){
	var results = $(".result");
	var btnMore = $("#seeMoreRecords");
	var btnLess = $("#seeLessRecords");
	var resultsLength = results.length;
	var currentIndex = 4;

	results.hide();
	results.slice(0, 4).show(); 
	checkButton();

	btnMore.click(function (e) { 
	    e.preventDefault();
	    $(".result").slice(currentIndex, currentIndex + 4).slideDown("slow");
	    currentIndex += 4;
	    checkButton();
	});

	btnLess.click(function (e) { 
	    e.preventDefault();
	    $(".result").slice(currentIndex - 4, currentIndex).slideUp( "slow");         
	    currentIndex -= 4;
	    checkButton();
	});

	function checkButton() {
	    var currentLength = $(".result:visible").length;
	    
	    if (currentLength >= resultsLength) {
	        btnMore.hide();            
	    } else {
	        btnMore.show();   
	    }
	    
	    if (resultsLength > 4 && currentLength > 4) {
	        btnLess.show();
	    } else {
	        btnLess.hide();
	    }
	    
	}
});
