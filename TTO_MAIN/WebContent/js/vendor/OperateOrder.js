function addOrderTale(str) {
	var Order = $("#orderTable").clone();
	Order.find("#TableTbody").attr("id", str.orderNumber);
	for (var i = 0; i < str.orderItems.length; i++) {
		$(
				"<tr><td>" + str.orderItems[i].product.productName
						+ "</td><td>" + str.orderItems[i].amount + "</td><td>"
						+ str.orderItems[i].price + "</td></tr>")
				.appendTo(Order.find("#" + str.orderNumber));
	}
	Order.attr("id", str.orderId);
	Order.removeClass("hidden");
	Order.find("#orderNum").text(str.orderNumber);
	Order.find("#orderDate").text(formatDateTime2(new Date(str.createTime)));
	Order.find("#orderState").text(str.status);
	Order.find("#orderPeopleName").text(str.contacterName);
	Order.find("#orderTel").text(str.contacterPhone);
	Order.find("#orderAddress").text(str.detailLocation);
	Order.find("#priceLabel").text(getPrice(str.orderItems));
	Order.find(".btn.btn-primary.access").data('id', str.orderId);
	Order.find(".btn.btn-danger.giveUp").data('id', str.orderId);
	Order.appendTo(".col-xs-9.main-wrapper");
	if (str.status == "ACCEPT") {
		Order.find(".btn.btn-primary.access").text("SENDING");
	}
	if (str.status == "SENDING") {
		Order.find(".btn.btn-primary.access").addClass("hidden");
		Order.find(".btn.btn-danger.giveUp").attr("disabled", true);
	}
}

function getPrice(OrderItems) {
	if (OrderItems != null) {
		var price = 0;
		for (var i = 0; i < OrderItems.length; i++) {
			price = price + parseInt(OrderItems[i].price)* parseInt(OrderItems[i].amount);
		}
		return price;
	}
}

var formatDateTime2 = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? ('0' + m) : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	var h = date.getHours();
	var minute = date.getMinutes();
	minute = minute < 10 ? ('0' + minute) : minute;
	return y + '-' + m + '-' + d + ' ' + h + ':' + minute;
};

function loadVendorInfo() {
	$.ajax({
		type : "post",
		url : "/TTO_MAIN/vendor/info/getVendorInfo.do",
		success : function(data) {
			var shopname = data.data.storeName;
			$("#shopNameLabel").text(shopname);
			var point = data.data.avgPoint;
			$("#avgPointLabel").text(point);
			var time = data.data.avgDeliverTime;
			$("#avgTimeLabel").text(time);
			var num = data.data.collectionNum;
			$("#collectionNumLabel").text(num);
		},
		error : function(data) {
			console.log("Load message fail!");
		}
	});
}



$(document).ready(function() {
	verify();
	loadVendorInfo();
	$.get("loadAllNewOrder.do", function(data) {
		var str = eval(data);
		$.each(str, function() {
			addOrderTale(this);
		});

		$(".btn.btn-primary.access").on("click", function() {
			var id=$(this).data('id');
			var status = $(this).text();
			$.get("updateOrder.do", {
				status : status,
				id : $(this).data('id')
			}, function(data) {
				// 加东西
				if (status == "SENDING") {
					$.get("/TTO_MAIN/vendor/jmsController/removejms.do", {
						id : id
					}, function(data) {

					});
				}
				window.location.href = "NewOrder.view";
			});
		});

		$(".btn.btn-danger.giveUp").on("click", function() {
			var status = $(this).text();
			$.get("updateOrder.do", {
				status : status,
				id : $(this).data('id')
			}, function(data) {
				// 加东西
				window.location.href = "NewOrder.view";
			});
		});

	});

});

function verify() {
	$.ajax({
		type : "post",
		url : "/TTO_MAIN/vendor/firstLogin/verify.do",
		success : function(data) {
		var result=data.isSuccess;
		if(result!=true)		
			window.location.href = "/TTO_MAIN/vendor/completeInfo/completeInfo.view";
		},
		error:function(data){
	    		console.log("verify fail!");
		}
	});
}