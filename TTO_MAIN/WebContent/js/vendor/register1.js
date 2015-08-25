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
				url:"register1.do",
				data: {"phone":$("#inputPhone").val()},
             	dataType: "json",
             	success:function(data){
             		window.location.href="register2.view";
             	}
			});
		}
	});
});