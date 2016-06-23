function showLoader(callback){
		var modalDiv  = '<div id="myModal" class="modal fade" tabindex="-1" role="dialog">'+
		  					'<div class="modal-dialog modal-sm">'+
		  						'<div class="modal-content loading style-2">'+
		  							'<div class="loading-wheel"></div>'+
		  						'</div>'+
		  					'</div>'+
		  				'</div>';
		$('body').append(modalDiv);
		$('#myModal').modal('show').delay(2000).queue(function(){
			$('#myModal').modal('hide');
			$(modalDiv).remove();
			callback();
			$.dequeue( this );
		});
	}