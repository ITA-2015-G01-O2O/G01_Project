var isAddr=false;
var isStoreName=false;
function verifyAddr(){
	var addr=$("#inputAddr").val();
	if(addr.length>0){
		isAddr=true;
		$("#addrmsg").attr("style","display: none;");
	}else{
		isAddr=false;
		$("#addrmsg").removeAttr("style");
	}				
}
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
$(document).ready(function(){
	$("#inputAddr").on("blur",verifyAddr);
	$("#inputStoreName").on("blur",verifyStoreName);
	$("a[id^=type]").on("click",function(){
		var type=$(this).text();
		$("#inputType").text(type);
	});
	$("#save").on("click",function(){
		verifyStoreName();
		verifyAddr();
		if(isAddr && isStoreName)
			return true;
		else
			return false;
	});
});
