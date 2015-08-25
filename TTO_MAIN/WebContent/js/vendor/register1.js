var isPhone=false;
function verifyphone(){
	var phone=$("#inputPhone").val();
	if(phone.match(/\d+/g)){
		isPhone=true;
		$("#phonemsg").attr("style","display: none;");
	}else{
		isPhone=false;
		$("#phonemsg").removeAttr("style");
	}
}
			
$(document).ready(function(){
	$("#inputPhone").on("blur",verifyphone);
	$("#next").on("click",function(){
		verifyphone();
		if(!isPhone){
			return false;
		}
		else{
			$.ajax({
				type:"post",
				url:"www.baidu.com",
				data: {"phone":$("#inputPhone").val()},
             	dataType: "json"
			});
		}
	});
});