$(function() {

	var orderjson = $("#ordercomfirm").text();

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
	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();

	if (ausername != null && auserPhone != null && auseraddress != null) {
		$("#addressModal").modal("hide");
		$("#addadress").hide();
		$("#showaddressInfo").show();
		$("#contact").text(ausername);
		$("#phonenum").text(auserPhone);
		$("#addressInfo").text(auseraddress);
	}
}

function confirmbuy() {

	var ausername = $("#ausername").val();
	var auserPhone = $("#auserPhone").val();
	var auseraddress = $("#auseraddress").val();
	var merchantmsg=$("#merchantmsg").val();
	var orderjson = $("#ordercomfirm").text();
	var dataJson = JSON.stringify(orderjson);

	if (ausername != null && auserPhone != null && auseraddress != null) {
		$.ajax({
			type : "post",
			url : "../order/addOrder.do",
			cache : false,
			data : {
				dataJson : dataJson,
				ausername : ausername,
				auserPhone : auserPhone,
				auseraddress : auseraddress,
				remark:merchantmsg
			},
			error : function(error) {
				alert("error");
			}
		}).done(function(json) {
			if (json != "") {
				if (json.isSuccess == true) {
					// window.location.href='../account/select-vender.view';
					$("#relogin").modal("hide");
				} else {
					$("#errorMsg").show();
					$("#errorMsg").text(json.data);
				}
			}
		});
	}

}

function setTotalCount(money) {
	money = Number(money);
	$("#totalcount").text("￥" + (money + paycount));
}
