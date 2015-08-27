var flag = false;

function changePsw() {
	if (flag == false) {
		$("#showChangePsw").modal("show");
		return false;
	} else {
		
		$.ajax({
			type : "post",
			url : "../usercenter/changeUserProfile.do",
			cache : false,
			asyn:false,
			data : {
				newPassword:$("#userInfo_password").val()
			},
			error : function(error) {
			}
		}).done(function(json) {
			if (json.isSuccess == true) {
				$("#showChangePsw").modal("hide");
				$("#successchange").modal("show");
				flag=false;
			}else{
				
			}
		});
		
	}
}


function confirmPsw(){
	$('#errorMsg').text('');
	var orgpsw=$("#userInfo_password").data("userInfo_password");
	var inputoldpsw=$("#checkPassword").val();
	var newpsw=$("#userInfo_password").val();
	if(inputoldpsw==null){
		$("#errorMsg").show();
		$("#errorMsg").text("Input old password,pls");
	}else if(inputoldpsw!=orgpsw){
		$("#errorMsg").show();
		$("#errorMsg").text("Error old password! ");
	}else if(newpsw==null){
		$("#errorMsg2").show();
		$("#showChangePsw").modal("hide");
		$("#errorMsg2").text("Input new password,pls");
	}else if(!newpsw.match(/^.{6,}$/)){
		$("#errorMsg2").show();
		$("#showChangePsw").modal("hide");
		$("#errorMsg2").text("Error Password format!Password's length should  be  greater than 6 ");
	}else{
		flag=true;
		$("#showChangePsw").modal("hide");
		$("#errorMsg2").hide();
	}
}