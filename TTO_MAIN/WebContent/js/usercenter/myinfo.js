function loadMyInfo(){
	alert("I'm in MyInfo");
	
	
	$.ajax({
		
		type : "post",
		url : "../usercenter/getUserProfile.do",
		cache : false,
		data : {
			
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		alert(json.uname);
		alert(json.password);
		alert(json.fund);
		if (json != "") {
			alert("success");
			$("#userInfo_uname").text(json.uname);
			$("#userInfo_password").text(json.password);
			$("#userInfo_fund").text("￥："+json.fund);
		}
	});
	
}


function loadMyFav(){
	alert("I'm in my fav");
	
	$.ajax({
		
		type : "post",
		url : "../usercenter/getUserFavVendor.do",
		cache : false,
		data : {
			
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		
		alert(json.length);
		if (json != "") {
			$("#myfavinfo").removeClass("hidden");
			for(var i = 0;i<json.length;i++){
				var s = addUserFav(json[i]);
				$("#messages").append(s);
			}			
			$("#myfavinfo").addClass("hidden");
		}
	});
}

function addUserFav(data){
	var s = $("#myfavinfo").clone();
	s.find("button[name=cancelfav]").on("click",function(){
		alert("i am in s's cancel");
		var cancel = $(this);
		var yes = confirm("do you want to cancel?");
		if(yes){
			
			$.ajax({
				
				type : "post",
				url : "../usercenter/cancelUserFavVendor.do",
				cache : false,
				data : {
					
				},
				error : function(error) {
					alert("error");
				}
			}).done(function(json) {
				var cancel1 = cancel;
				if (json != "") {
					$(cancel1).parent().parent().parent().parent().parent().remove();
					alert("success");
				}
			});
		}
	});
	setRomdomNameandId(s);
	
	return s;
}
function setRomdomNameandId($element) {
	$element.prop('name', $element.prop("name") + "_"
			+ Math.floor(Math.random() * (1000000)));
	$element.prop('id', $element.prop("id") + "_"
			+ Math.floor(Math.random() * (1000000)));
}

