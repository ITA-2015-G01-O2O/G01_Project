var isName=false;
var isIdcard=false;
var isIdcardPic=false;
var isLicensePic=false;
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
function verifyIdcard(){
	var idcard=$("#inputIdcard").val();
	if(idcard.match(/\d{18}/g)){
		isIdcard=true;
		$("#idcardmsg").attr("style","display: none;");
	}else{
		isIdcard=false;
		$("#idcardmsg").removeAttr("style");
	}
}
function verifyIdcardPic(){
	var idcardPic=$("#IdcardPic").val();
	if(idcardPic.length>0){
		isIdcardPic=true;
		$("#idcardpicmsg").attr("style","display: none;");
	}else{
		isIdcardPic=false;
		$("#idcardpicmsg").removeAttr("style");
	}
}
function verifyLicensePic(){
	var liensePic=$("#LicensePic").val();
	if(liensePic.length>0){
		isLicensePic=true;
		$("#licensepicmsg").attr("style","display: none;");
	}else{
		isLicensePic=false;
		$("#licensepicmsg").removeAttr("style");
	}
}
$(document).ready(function(){
	$("#inputName").on("blur",verifyName);
	$("#inputIdcard").on("blur",verifyIdcard);
	$("#form3").submit(function(){
		verifyName();
		verifyIdcard();
		verifyIdcardPic();
		verifyLicensePic();
		if(isName && isIdcard && isIdcardPic && isLicensePic){
			$.ajax({
				type:"post",
				url:"register3.do",
             	success:function(data){
             		window.location.href="register4.view";
             	}
			});
		}else{
			return false;
		}
	});
});