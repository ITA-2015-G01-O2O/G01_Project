var merId;
$(function() {
	merId = $("#merId").text();
	var orderjson = $.cookie('com.group.tto.main.addorder' + merId);

	if (orderjson == null) {
		return false;
	} else {
		var orderdata = JSON.parse(orderjson);
		setOrderpros(orderdata);
	}

});

var paycount = 0;
function setOrderpros(orderdata) {
	for (var i = 0; i < orderdata.length; i++) {
		var order = orderdata[i];

		var tr = $("#showorderCopy").clone();
		tr.show().prependTo($("#showorderpros1"));

		var td = $(tr).children();
		td.eq(0).find('div').text(order.proName);
		td.eq(0).find('span').text(order.proId);

		td.eq(1).find('div').text("￥" + order.proPrice + "*" + order.proNum);

		var money = Number(order.proPrice) * Number(order.proNum);
		setTotalCount(money);
	}
}

function confirmorderbtn() {
	$('#errorMsg2').text("");
	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();

	validate(ausername, auserPhone, auseraddress);
	if(errorMsg!=null){
		$("#errorMsg2").show();
		$('#errorMsg2').text(errorMsg);
	}
	if (ausername != null && auserPhone != null && auseraddress != null) {
		$("#addressModal").modal("hide");
		$("#addadress").hide();
		$("#showaddressInfo").show();
		$("#contact").text(ausername);
		$("#phonenum").text(auserPhone);
		$("#addressInfo").text(auseraddress);
	}
}
var errorMsg = null;
function validate(ausername, auserPhone, auseraddress) {
	if (ausername == null) {
		errorMsg=getErrorMsg(errorMsg, "UserName should not be null!");
	}
	if (auserPhone == null) {
		errorMsg=getErrorMsg(errorMsg, "UserPhone should not be null!");
	}else{
		if(!auserPhone.match(/\d{12}/g)){
			errorMsg=getErrorMsg(errorMsg, "Error UserPhone format,The UserPhone's length  should be 12 number!");
		}
	}
	
	if (auseraddress == null) {
		errorMsg=getErrorMsg(errorMsg, "UserPhone should not be null!");
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
function confirmbuy() {

	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();
	var merchantmsg = $("#merchantmsg").val();

	var dataJson = $.cookie('com.group.tto.main.addorder' + merId);
	// var dataJson = JSON.stringify(orderjson);
	// var dataJson=dataJson.substr(1, dataJson.length - 2);
	if (ausername != null && auserPhone != null && auseraddress != null
			&& dataJson != null) {
		$.ajax({
			type : "post",
			url : "../order/addOrder.do",
			cache : false,
			asyn : false,
			data : {
				dataJson : dataJson,
				ausername : ausername,
				auserPhone : auserPhone,
				auseraddress : auseraddress,
				remark : merchantmsg
			},
			error : function(error) {
				alert("error");
			}
		}).done(function(json) {
			if (json != "") {
				if (json.isSuccess == true) {

					$.cookie('com.group.tto.main.addorder' + merId, '', {
						expires : -1
					});
					window.location.href = '../consumer/confirmOrder.view?';
				} else {
					// 添加失败
				}
			}
		});
	}

}

function setTotalCount(money) {
	money = Number(money);
	$("#totalcount").text("￥" + (money + paycount));
}
