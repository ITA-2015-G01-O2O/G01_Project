var merId;
$(function() {
	paycount=0;
	merId = $("#merId").text();
	var orderjson = $.cookie('com.group.tto.main.addorder' + merId);

	if (orderjson == null) {
		return false;
	} else {
		var orderdata = JSON.parse(orderjson);
		setOrderpros(orderdata);
	}

});

var paycount;
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
	errorMsg=null;
	$('#errorMsg2').html("");
	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();

	errorMsg=validate(ausername, auserPhone, auseraddress);
	if(errorMsg!=null){
		addflag=false;
		$("#errorMsg2").show();
		$('#errorMsg2').html(errorMsg);
		return false;
	}else {
		addflag=true;
		$("#addressModal").modal("hide");
		$("#addadress").hide();
		$("#showaddressInfo").show();
		$("#contact").text(ausername);
		$("#phonenum").text(auserPhone);
		$("#addressInfo").text(auseraddress);
		$("#errorMsg2").hide();
	}
}
var errorMsg = null;
function validate(ausername, auserPhone, auseraddress) {
	if (ausername == "") {
		errorMsg=getErrorMsg(errorMsg, "UserName should not be null!");
	}
	if (auserPhone == "") {
		errorMsg=getErrorMsg(errorMsg, "UserPhone should not be null!");
	}else{
		if(!auserPhone.match(/^\d{11}$/)){
			errorMsg=getErrorMsg(errorMsg, "Error UserPhone format,The UserPhone's length  should be 11 number!");
		}
	}
	if (auseraddress == "") {
		errorMsg=getErrorMsg(errorMsg, "UserAddress should not be null!");
	}
	return errorMsg;
}


function getErrorMsg(msg, newmsg) {
	if (msg == null) {
		msg = newmsg;
	} else {
		msg = msg + "<br/>" + newmsg;
	}
	return msg;
}
var addflag=false;
function confirmbuy() {

	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();
	var merchantmsg = $("#merchantmsg").val();
	
	
	
	var dataJson = $.cookie('com.group.tto.main.addorder' + merId);
	if(dataJson==null){
		window.location.href = '../consumer/search.view';
	}
	// var dataJson = JSON.stringify(orderjson);
	// var dataJson=dataJson.substr(1, dataJson.length - 2);
	if (addflag==true) {
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
					addflag=false;
					$.cookie('com.group.tto.main.addorder' + merId, '', {
						expires : -1
					});
					window.location.href = '../usercenter/personcenter.view';
				} else {
					// 添加失败
				}
			}
		});
	}else{
		$("#completeinfo").modal("show");
	}

}

function setTotalCount(money) {
	money = Number(money);
	var totalmoney=(money + Number(paycount));
	$("#totalcount").text("￥" + totalmoney);
	paycount=totalmoney;
}
