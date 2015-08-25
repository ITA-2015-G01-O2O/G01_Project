$(function(){
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
	alert("hi");
	
//	$.ajax({
//		
//		type : "post",
//		url : "../usercenter/getAllUser.do",
//		cache : false,
//		data : {
//			
//		},
//		error : function(error) {
//			alert("error");
//		}
//	}).done(function(json) {
//		alert(json.length);
//		if (json != "") {
//			alert("success");
//		}
//	});
//	
	

	$("#changePsd").on("click",function(){
		var flag = confirm("do you really want to change psd?");
		if(flag){
			$.ajax({
				
				type : "post",
				url : "../usercenter/changeUserProfile.do",
				cache : false,
				data : {
					
				},
				error : function(error) {
					alert("error");
				}
			}).done(function(json) {
				alert();
				if (json != "") {
					alert("success");
				}
			});
			
		}
		
		
	});
	
	
	$("#charge").on("click",function(){
		var flag = confirm("do you really want to change psd?");
		if(flag){
			$.ajax({
				
				type : "post",
				url : "../usercenter/chargeUserFund.do",
				cache : false,
				data : {
					
				},
				error : function(error) {
					alert("error");
				}
			}).done(function(json) {
				alert();
				if (json != "") {
					alert("success");
				}
			});
			
		}
		
		
	});
	
	
});