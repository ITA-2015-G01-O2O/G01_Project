function loadMyInfo(){
	
	$.ajax({
		
		type : "post",
		url : "../usercenter/getUserProfile.do",
		cache : false,
		data : {
			
		},
		error : function(error) {
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
		}
	}).done(function(json) {
		
		if(json==""){
			$("#messages").children().remove();
			var str="<h1 >have no favorite vendors yet</h1>";
			$("#messages").append(str);
		}
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
	var storeId = data.storeId;
	s.find("#showStorePic").attr("src","../file/img/"+data.logoPicUrl);
	s.find("#resVoname").text(data.storeName);
	s.find("#resVophone").text(data.phone);
	s.find("#resVodetailLocation").text(data.detailLocation);
	s.find("#resVopoint").text(data.avgPoint);
	s.find("#resVoAmount").text(data.orderAmount);
	s.find("#resVoColAmount").text(data.collectAmount);
	s.find("button[name=cancelfav]").on("click",function(){
		var cancel = this;
		var yes = confirm("do you want to cancel?");
		if(yes){
			$.ajax({
				
				type : "post",
				url : "../usercenter/cancelUserFavVendor.do",
				cache : false,
				data : {
					storeId:storeId,
				},
				error : function(error) {
				}
			}).done(function(json) {
				if (json != "") {
					$(cancel).parent().parent().parent().parent().parent().remove();
				}
			});
		}	
	});
	s.find("#showStorePic").on("click",function(){
		var yes = confirm("do you want to enter this vendor?");
		if(yes){
			window.location.href="../consumer/getMerprosById.view?merId="+storeId;
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

