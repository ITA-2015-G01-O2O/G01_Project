$(function(){
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
	
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
			$("#myordermodel").removeClass("hidden");
			for(var i = 0;i<json.length;i++){
				var s = addUserOrder(json[i]);
				$("#home").append(s).show();
			}
		}
		$("#myordermodel").addClass("hidden");
	});
	
	

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
					$("#userInfo_password").text(json.password);
				}
			});
			
		}
		
		
	});
	
	
	$("#charge").on("click",function(){
		var flag = confirm("do you really want to charge ?");
		if(flag){
			$.ajax({
				
				type : "post",
				url : "../usercenter/chargeUserFund.do",
				cache : false,
				data : {
					
				},
				error : function(error) {
					alert(error);
				}
			}).done(function(json) {
				alert(json.length);
				if (json != "") {
					alert("success");
					$("#userInfo_fund").text("￥："+json.fund);
					
				}
			});
			
		}
		
		
	});
	function addUserOrder(data){
		var s = $("#myordermodel").clone();
		setRomdomNameandId(s);
		
		return s;
	}
	function setRomdomNameandId($element) {
		$element.prop('name', $element.prop("name") + "_"
				+ Math.floor(Math.random() * (1000000)));
		$element.prop('id', $element.prop("id") + "_"
				+ Math.floor(Math.random() * (1000000)));
	}
	
});