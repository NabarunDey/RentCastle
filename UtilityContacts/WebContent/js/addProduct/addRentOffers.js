$(document).ready(function () {
	$('.multioffers').each(function() {
	    var $wrapper = $('.offers', this);
	    $(".add", $(this)).click(function(e) {
	        $('.offer:first-child', $wrapper).clone(true).appendTo($wrapper).find('input').val('');;
	        setOfferNo();
	    });
	    $('.offer .remove', $wrapper).click(function() {
	        if ($('.offer', $wrapper).length > 1)
	            $(this).parents('.offer').slideUp('slow', function () {
	                $(this).remove(); setOfferNo();
	            });
	        	//$(this).parents('.step').remove();
	        
	    });
	});
});
function setOfferNo(){
	$('div.offers div.panel-heading label').each(function(index){
		var no = index + 1;
		$(this).html(no);
	});
}