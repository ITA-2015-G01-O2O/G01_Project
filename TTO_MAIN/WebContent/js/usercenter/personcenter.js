$(function() {
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});

	$.ajax({

		type : "post",
		url : "../usercenter/getAllUser.do",
		cache : false,
		data : {

		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			$("#myordermodel").removeClass("hidden");
			for (var i = 0; i < json.length; i++) {
				var s = addUserOrder(json[i]);
				$("#home").append(s).show();
			}
		}
		$("#myordermodel").addClass("hidden");
	});

	$("#changePsd").on("click", function() {
		var flag = confirm("do you really want to change psd?");
		if (flag) {
			$.ajax({

				type : "post",
				url : "../usercenter/changeUserProfile.do",
				cache : false,
				data : {

				},
				error : function(error) {
					alert("error");
				}
			}).done(function(json) {
				alert();
				if (json != "") {
					$("#userInfo_password").text(json.password);
				}
			});

		}

	});

	$("#charge").on("click", function() {
		var flag = confirm("do you really want to charge ?");
		if (flag) {
			$.ajax({

				type : "post",
				url : "../usercenter/chargeUserFund.do",
				cache : false,
				data : {

				},
				error : function(error) {
					alert(error);
				}
			}).done(function(json) {
				alert(json.length);
				if (json != "") {
					alert("success");
					$("#userInfo_fund").text("￥：" + json.fund);

				}
			});

		}

	});
	function addUserOrder(data) {
		var s = $("#myordermodel").clone();
		var orderId = data.orderId;

		s.find("#resOVoname").text(data.storeName);
		s.find("#resOVoPhone").text(data.phone);
		s.find("#resOVoOrderNumber").text(data.orderNumber);
		s.find("#resOVoOrderTime").text(data.createTime);
		s.find("#resOVoOrderState").text(data.status);
		s.find("#resOVoContacter").text(data.contacterName);
		s.find("#resOVoContactPhone").text(data.contacterPhone);
		s.find("#resOVoRemarks").text(data.remarks);
		if (data.status == "FINISHED") {
			
			s.find("#resReplyToUser").text("this order has finished.");
			s.find("#resOVoCommentFunc").show();
			if (data.context == null) {
				s.find("#resOVoComment2").show();
				s.find("#commitId").data("orderId", orderId);
			} else {
				s.find("#resOVoComment").show();
				s.find("#resOVoComment").text(data.context);
			}
		}
		if(data.status=="ACCEPT"){
			s.find("#resReplyToUser").text("vendor is cooking");
		}
		if(data.status=="CANCEL"){
			s.find("#resReplyToUser").text("This order has been canceled.");
		}
		if(data.status=="SENDING"){
			s.find("#resReplyToUser").text("vendor is sending your food");
			s.find("#userConfirmThisOrder").removeClass("hidden");
			s.find("#userConfirmThisOrder").on("click", function() {
				var confirmOrder = confirm("do you want to confirm this order?");
				if (confirmOrder) {
					$.ajax({

						type : "post",
						url : "../usercenter/confirmOrder.do",
						cache : false,
						data : {
							orderId : orderId,

						},
						error : function(error) {
							alert(error);
						}
					}).done(function(json) {
						var ss = s;
						if (json.isSuccess) {
							alert("success");
							ss.find("#userConfirmThisOrder").addClass("hidden");
							s.find("#resOVoOrderState").text("FINISHED");
							s.find("#resReplyToUser").text("this order has finished.");
						}
					});
				}

			});
		}

		s.find("#detailLocation").text(data.detailLocation);
		s.find("#showImg").attr("src", "../file/img/" + data.logoPicUrl);

		if (data.status == "NEW") {
			s.find("#resReplyToUser").text("this order is writting for checked.");
			s.find("#userCancelThisOrder").removeClass("hidden");
			s.find("#userCancelThisOrder").on("click", function() {
				var cancelOrder = confirm("do you want to cancel this order?");
				if (cancelOrder) {
					$.ajax({

						type : "post",
						url : "../usercenter/cancelOrder.do",
						cache : false,
						data : {
							orderId : orderId,

						},
						error : function(error) {
							alert(error);
						}
					}).done(function(json) {
						var ss = s;
						if (json.isSuccess) {
							alert("success");
							ss.find("#userCancelThisOrder").addClass("hidden");
							s.find("#resOVoOrderState").text("CANCEL");
						}
					});
				}

			});
		}

		sum = 0;
		var orderItems = data.orderEachItemList;

		for (var i = 0; i < orderItems.length; i++) {
			var tr = "<tr>";
			tr += "<td class=\"active\" id=\"productId\">"
					+ orderItems[i].productId + "</td>";
			tr += "<td class=\"active\" id=\"productName\">"
					+ orderItems[i].productName + "</td>";
			tr += "<td class=\"active\" id=\"productPrice\">"
					+ orderItems[i].price + "</td>";
			tr += "</tr>";
			s.find("#myordertbody").append(tr);
			sum += orderItems[i].price;
		}

		s.find("#totalPrice").text(sum);
		setRomdomNameandId(s);

		return s;
	}
	function setRomdomNameandId($element) {
		$element.prop('name', $element.prop("name") + "_"
				+ Math.floor(Math.random() * (1000000)));
		$element.prop('id', $element.prop("id") + "_"
				+ Math.floor(Math.random() * (1000000)));
	}

});
function commitcomment(ele) {
	var resOVoCommentchildren = $(ele).closest('div').children();
	var inputvalue = resOVoCommentchildren.eq(0).val();
	var id = $(ele).data("orderId");
	$.ajax({
		type : "post",
		url : "../usercenter/saveComment.do",
		cache : false,
		asyn : false,
		data : {
			context : inputvalue,
			point : 0,
			deliverTime : 0,
			orderId : $(ele).data("orderId")
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json.isSuccess == true) {
			resOVoCommentchildren.hide();
			var preele = $(ele).closest('div').prev();
			preele.show();
			preele.text(inputvalue);
		} else {
			$("#failchange").modal("show");
		}
	});

}
