$(function(){
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
	alert("hi");
	
	$.ajax({
		
		type : "post",
		url : "../usercenter/getAllUser.do",
		cache : false,
		data : {
			
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		
		if (json != "") {
			alert("success");
		}
	});
	
	
	
});