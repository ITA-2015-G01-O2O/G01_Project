var isStoreName=false;
var isPhone=false;
function verifyStoreName(){
	var storeName=$("#inputStoreName").val();
	if(storeName.length>0){
		isStoreName=true;
		$("#storeNamemsg").attr("style","display: none;");
	}else{
		isStoreName=false;
		$("#storeNamemsg").removeAttr("style");
	}
}
function verifyPhone(){
	var phone=$("#inputPhone").val();
	if(phone.match(/\d+/g)){
		isPhone=true;
		$("#phonemsg").attr("style","display: none;");
	}else{
		isPhone=false;
		$("#phonemsg").removeAttr("style");
	}	
}
function loadMessage(){
	$.ajax({
		type:"post",
		url:"load.do",
		success:function(data){
			var location1=data.data.location;
			var locations=location1.area+location1.city+location1.place;
			var detailLocation=data.data.detailLocation;
			var allLocation=locations+detailLocation;
			$("#inputAddr").text(allLocation);
			
			var phone=data.data.phone;
			$("#inputPhone").val(phone);
			
			var storeName=data.data.storeName;
			$("#inputStoreName").val(storeName);
			
			var type=data.data.typeConfig.configValue;
			$("#typemsg").text(type);
			$("#inputType").val(type);
			
			var uuid=data.data.logoPicUrl;
			$("#showStorePic").attr("src","../file/img/"+uuid);
			
			$("#piclog").val("0");
		},
        error:function(data){
            alert("Load message fail!");
        }
	});
}
$(document).ready(function(){
	$("#inputStoreName").on("blur",verifyStoreName);
	$("a[id^=type]").on("click",function(){
		var type=$(this).text();
		$("#typemsg").text(type);
		$("#inputType").val(type);
	});
	$("#changePic").on("click",function(){
		$("#piclog").val("1");
	});
	loadMessage();
	$('#si_form').ajaxForm({
		type:'post',
		url:'update.do',
		beforeSubmit:function(){
			verifyStoreName();
			verifyPhone();
			if(isStoreName && isPhone){
				return true;
			}else
				return false;
		},
		success:function(data){
			alert("Save Success!");
		}
	});
});
