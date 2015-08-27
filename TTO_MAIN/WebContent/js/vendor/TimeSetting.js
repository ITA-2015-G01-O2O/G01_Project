$(document).ready(function() {
	var i=0;
	setInterval(function() {
		i=i+1;
		$.get("/TTO_MAIN/vendor/jmsController/jms.do", function(data) {
			if ($.isEmptyObject(data) == false) {
                $(".badge").text(i);
                $(".badge").css("background-color","red");
			}
		});

	}, 1000);
	
});


//style="background-color: red">2
//$(".colordiv div").css("background-color","red");