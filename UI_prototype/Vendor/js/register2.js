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
$(document).ready(function(){
	$("a[id^=type]").on("click",function(){
		var typetext=$(this).text();
		$("#inputType").text(typetext);
	});
	$("a[id^=area]").on("click",function(){
		var areatext=$(this).text();
		$("#inputAddr1").text(areatext);
	});
	$("#inputName").on("blur",verifyName);
	$("#inputAddr2").on("blur",verifyAddr);
	$("#next").on("click",function(){
		verifyAddr();
		verifyName();
		verifyType();
		if(isName && isType && isAddr){
			return true;
		}else{
			return false;
		}
	});
});