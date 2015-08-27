$(document).ready(function() {
	$.get("../vendor/order/loadAllCompletedOrder.do", {

	}, function(data) {
		var str = eval(data);
		$.each(str, function() {
			addOrderHistoryTale(this);
		});
		$("#" + str.orderId).on("click", function() {
			// alert($(this).attr('id'));
			// alert($(this).attr('id'));
			alert($(this).data("data"));
		});

	});

});

// 订单号+时间+选择品+评分+评价+操作
function addOrderHistoryTale(str) {
	if (str.comment != null) {
		$(
				"<tr><td>" + str.orderNumber + "</td><td>"
						+ formatDateTime(new Date(str.createTime))
						+ "</td><td>" + "菜品" + "</td><td>" + str.comment.point
						+ "</td><td>" + str.comment.context + "</td><td>"
						+ str.status + "</td><td><Button  class='btn btn-primary btn-lg' data-toggle='modal' data-target='#myModal' id=" + str.orderId
						+ ">Detail</Button></td></tr>").appendTo(
				"#HistoryTbody");
		$("#" + str.orderId).data("data", str);

	} else {
		$(
				"<tr><td>" + str.orderNumber + "</td><td>"
						+ formatDateTime(new Date(str.createTime))
						+ "</td><td>" + "菜品" + "</td><td>" + "-" + "</td><td>"
						+ "-" + "</td><td>" + str.status
						+ "</td><td><Button  class='btn btn-primary btn-lg' data-toggle='modal' data-target='#myModal' id=" + str.orderId
						+ ">Detail</Button></td></tr>").appendTo(
				"#HistoryTbody");
		$("#" + str.orderId).data("data", str);
	}
}

var formatDateTime = function(date) {
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