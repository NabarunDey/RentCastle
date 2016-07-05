$(document).ready(function(){
	var total = 0;
	$('.orders table tbody tr').each(function(){
		total += parseInt($('td:eq(1)',this).html().substring(4))+parseInt($('td:eq(2)',this).html().substring(4));
		$('td:eq(3)',this).html('Rs. '+(parseInt($('td:eq(1)',this).html().substring(4))+parseInt($('td:eq(2)',this).html().substring(4))));
	});
	$('.orders table tfoot tr td:eq(3)').html('Total Amount: Rs. '+total);
});