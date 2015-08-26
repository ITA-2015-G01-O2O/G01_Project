$(function(){
	getUserName();
});

function consumerlogin() {
	var username = $("#username").val();
	var password = $("#password").val();

	$.ajax({
		type : "post",
		url : "../account/login.do",
		cache : false,
		data : {
			loginname : username,
			password : password
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				// window.location.href='../account/select-vender.view';
				$("#relogin").modal("hide");
				getUserName();
				//$("#logintitle").hide();
				//$("#registertitle").hide();
				//$("#loginameshow").show();
				
			} else {
				$("#errorMsg").show();
				$("#errorMsg").text(json.data);
			}
		}
	});
}


function getUserName(){
	$.ajax({
		type : "post",
		url : "../account/getMainName.do",
		cache : false,
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				$("#loginameshow").show();
				$("#logintitle").hide();
				$("#registertitle").hide();
				$("#loginameshow").children().eq(0).text(json.data);
			}else{
				$("#logintitle").show();
				$("#registertitle").show();
				$("#loginameshow").hide();
			} 
		}
	});
}


function addaddress() {
	$('#addressModal').on('show.bs.modal', function(e) {
		$("#deletebtn").on("click", function(e) {
			deletebtn(userId, td);
		});
	});
}

function addMeals(ele) {
	var divele = $(ele).closest('div').children();
	var proName = divele.eq(0).find('h4').eq(0).text();
	var proId = divele.eq(1).find('span').eq(0).val();
	var proprice = divele.eq(2).find('h5').eq(0).find('span').eq(0).val();
	addToCard(proName, proId, proprice);
}
function addToCard(proName, proId, proprice) {

}
var errorMsg;
function verifyName(name) {
	if (name.match(/\d{11}$/)) {
		return true;
	} else {
		errorMsg = getErrorMsg(errorMsg,
				"Error UserName,The userName should be PhoneNumber!");
		return false;
	}
}

function getErrorMsg(msg, newmsg) {
	if (msg == null) {
		msg = newmsg;
	} else {
		msg = msg + "<br/>" + newmsg;
	}
	return msg;
}

function verifypassword(psw1, compsw2) {
	if (psw1 != compsw2) {
		errorMsg = getErrorMsg(errorMsg,
				"Error password,pls comfirm your psssword!");
		return false;
	} else if (psw1.match(/^.{6,}$/)) {
		return true;
	} else {
		errorMsg = getErrorMsg(errorMsg,
				"Error Password format!Password's length should  be  greater than 6");
		return false;
	}
}

