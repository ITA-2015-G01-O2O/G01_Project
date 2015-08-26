function loadMyInfo(){
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
		if (json != "") {
			$("#userInfo_uname").text(json.uname);
			$("#userInfo_password").data("userInfo_password",json.password);
			$("#userInfo_fund").text("￥："+json.fund);
		}
	});
	
}


function loadMyFav(){
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
		
		if (json != "") {
			$("#messages").children().remove();
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
	$("#showStorePic").attr("src","../file/img/"+data.logoPicUrl);
	s.find("#resVoname").text(data.storeName);
	s.find("#resVophone").text(data.phone);
	s.find("#resVodetailLocation").text(data.detailLocation);
	s.find("#resVopoint").text(data.avgPoint);
	s.find("#resVoAmount").text(data.orderAmount);
	s.find("#resVoColAmount").text(data.collectAmount);
	s.find("button[name=cancelfav]").on("click",function(){
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

