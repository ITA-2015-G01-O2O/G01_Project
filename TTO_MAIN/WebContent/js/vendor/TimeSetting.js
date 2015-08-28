$(document).ready(function() {
	var i=0;
	$.get("/TTO_MAIN/vendor/jmsController/jms.do", function(data) {
		if ($.isEmptyObject(data) == false) {
			var str=eval(data);
            $(".badge").text(str.length);
            $(".badge").css("background-color","red");
            setInterval(function() {
        		$.get("/TTO_MAIN/vendor/jmsController/jms.do", function(data) {
        			if ($.isEmptyObject(data) == false) {
        				var str=eval(data);
                        $(".badge").text(str.length);
                        $(".badge").css("background-color","red");
        			}
        		});

        	}, 1000);
		}
	});
	
	
	
});


//style="background-color: red">2
//$(".colordiv div").css("background-color","red");