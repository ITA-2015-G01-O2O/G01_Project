var isName=false;
var isType=false;
var isAddr=false;
function verifyName(){
	var name=$("#inputName").val();
	if(name.match(/\w+/g)){
		isName=true;
		$("#namemsg").attr("style","display: none;");
	}else{
		isName=false;
		$("#namemsg").removeAttr("style");
	}
}
function verifyType(){
	var type=$("#inputType").text();
	if(!type.match("Choose")){
		isType=true;
		$("#typemsg").attr("style","display: none;");
	}else{
		isType=false;
		$("#typemsg").removeAttr("style");
	}
}
function verifyAddr(){
	var addr1=$("#inputAddr1").text();
	var addr2=$("#inputAddr2").val();
	if(!addr1.match("Choose")&&addr2.length>0){
		isAddr=true;
		$("#addrmsg").attr("style","display: none;");
	}else{
		isAddr=false;
		$("#addrmsg").removeAttr("style");
	}
}
function loadPlace(city){
	$.ajax({
		type:"post",
		url:"loadPlace.do",
		data:{"city":city},
		dataType: "json",
        success:function(data){
            var locations=data.data;
            for(var i in locations){
            	var l=locations[i].place;
            	$("#placeMenu").append("<li><a href=\"#\" id=\"place"+i+"\">"+l+"</a></li>");            
            }
            $("a[id^=place]").on("click",function(){
				var areatext=$(this).text();
				$("#inputPlace").text(areatext);
				
			});
        }
	});
}

function loadCity(area){
	$.ajax({
		type:"post",
		url:"loadCity.do",
		data:{"area":area},
		dataType: "json",
        success:function(data){
            var locations=data.data;
            for(var i in locations){
            	var l=locations[i];
            	$("#cityMenu").append("<li><a href=\"#\" id=\"city"+i+"\">"+l+"</a></li>");            
            }
            $("a[id^=city]").on("click",function(){
				var areatext=$(this).text();
				$("#inputCity").text(areatext);
				loadPlace(areatext);
			});
        }
	});
}
function loadLocation(){
	$.ajax({
		type:"post",
		url:"loadLocation.do",
        success:function(data){
            var locations=data.data;
            for(var i in locations){
            	var l=locations[i];
            	$("#locationMenu").append("<li><a href=\"#\" id=\"location"+i+"\">"+l+"</a></li>");            
            }
            $("a[id^=location]").on("click",function(){
				var areatext=$(this).text();
				$("#inputAddr1").text(areatext);
				loadCity(areatext);
			});
        }
	});
}


function loadConfig(){
	$.ajax({
		type:"post",
		url:"loadConfig.do",
        success:function(data){
            var configs=data.data;
            for(var i in configs){
            	var con=configs[i];
            	$("#configMenu").append("<li><a href=\"#\" id=\"type"+i+"\">"+con.configValue+"</a></li>");           
            }
            
            $("a[id^=type]").on("click",function(){
				var typetext=$(this).text();
				$("#inputType").text(typetext);
			});
        }
	});
}

$(document).ready(function(){
	$("#inputName").on("blur",verifyName);
	$("#inputAddr2").on("blur",verifyAddr);
	loadConfig();
	loadLocation();
	$("#next").on("click",function(){
		verifyAddr();
		verifyName();
		verifyType();
		var addr=$("#inputAddr1").text()+","+$("#inputCity").text()+","+$("#inputPlace").text();
		if(isName && isType && isAddr){
			$.ajax({
				type:"post",
				url:"register2.do",
				data: {"storename":$("#inputName").val(),"type":$("#inputType").text(),
				"addr1":addr,"addr2":$("#inputAddr2").val()},
             	dataType: "json",
             	success:function(data){
             		window.location.href="register3.view";
             	}
			});
		}else{
			return false;
		}
	});
});