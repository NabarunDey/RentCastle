function doAjaxPost() {
	  var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
	$.ajax({
		type: "POST",
		url: "loginFunction",
		data: $('#loginForm').serialize() ,
		success: function(response){
			 lb.close();

			if(response.loginProjectorOB.userNotExist)
			{
				$('#loginError').show();
				document.getElementById('loginError').innerHTML ="User does not exist. Please resgister."
				return;
			}
			if(response.loginProjectorOB.invalidCredentials)
			{
				$('#loginError').show();
				document.getElementById('loginError').innerHTML ="UserName and password does not match.";
				return;
			}
			
			
			if(response.loginProjectorOB.loginFailure)
			{
				$('#loginError').show();
				document.getElementById('loginError').innerHTML ="Fail to login."
				return;
			}
		
			window.location = response.loginProjectorOB.refererUrl;
			
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
}

function forgotPasswordSubmit() {
	  var lb = new $.LoadingBox({loadingImageSrc: "images/default.gif",});
	$.ajax({
		type: "POST",
		url: "forgotPasswordSubmit",
		data: $('#ForgotPassword_form').serialize() ,
		success: function(response){
			if (response.loginProjectorOB.userNotExist) {
				$('#errorUserNotExist').show();
				return;
			}
			if (!response.loginProjectorOB.mailSent) {
				$('#errorMailNotSent').show();
				return;
			}
			$('#successForgotPassword').show();
		},
		error: function(e){
			alert('Error: ' + e);
		}
	});
	lb.close();
}


var maxHeight = 400;

$(function(){

    $(".dropdown > li").hover(function() {
    
         var $container = $(this),
             $list = $container.find("ul"),
             $anchor = $container.find("a"),
             height = $list.height() * 1.1,       // make sure there is enough room at the bottom
             multiplier = height / maxHeight;     // needs to move faster if list is taller
        
        // need to save height here so it can revert on mouseout            
        $container.data("origHeight", $container.height());
        
        // so it can retain it's rollover color all the while the dropdown is open
        $anchor.addClass("hover");
        
        // make sure dropdown appears directly below parent list item    
        $list
            .show()
            .css({
                paddingTop: $container.data("origHeight")
            });
        
        // don't do any animation if list shorter than max
        if (multiplier > 1) {
            $container
                .css({
                    height: maxHeight,
                    overflow: "hidden"
                })
                .mousemove(function(e) {
                    var offset = $container.offset();
                    var relativeY = ((e.pageY - offset.top) * multiplier) - ($container.data("origHeight") * multiplier);
                    if (relativeY > $container.data("origHeight")) {
                        $list.css("top", -relativeY + $container.data("origHeight"));
                    };
                });
        }
        
    }, function() {
    
        var $el = $(this);
        
        // put things back to normal
        $el
            .height($(this).data("origHeight"))
            .find("ul")
            .css({ top: 0 })
            .hide()
            .end()
            .find("a")
            .removeClass("hover");
    
    });  
    
});


