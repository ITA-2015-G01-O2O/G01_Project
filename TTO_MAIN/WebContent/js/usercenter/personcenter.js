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
			
		}
	}).done(function(json) {
		if(json==""){
			var str="<h1 >have no orders  yet</h1>";
			$("#home").append(str);
		}
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
					
				}
			}).done(function(json) {
				
				if (json != "") {
					$("#userInfo_password").text(json.password);
				}
			});

		}

	});

	$("#saveCharge").on("click", function() {
		var flag = confirm("do you want to charge?");
		var addFund = $("#addMoney").val();
		if (flag) {
			$.ajax({

				type : "post",
				url : "../usercenter/chargeUserFund.do",
				cache : false,
				data : {
					addMoney:addFund,
				},
				error : function(error) {
					
				}
			}).done(function(json) {
				$("#chargePage").modal("hide");
				if (json != "") {
					$("#userInfo_fund").text("￥：" + json.fund);
					
				}
			});

		}

	});
	function addUserOrder(data) {
		var s = $("#myordermodel").clone();
		var orderId = data.orderId;
		s.find("#commitId").data("orderId", orderId);
		s.find("#resOVoname").text(data.storeName);
		s.find("#resOVoPhone").text(data.phone);
		s.find("#resOVoOrderNumber").text(data.orderNumber);
		var orderTime = new Date(data.createTime);
		var finalTime = formatDateTime2(orderTime);
		s.find("#resOVoOrderTime").text(finalTime);
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
				s.find("#resOVoCommentscore2").show();
				s.find("#resOVoCommenttime2").show();
				s.find("#resOVoComment").text(data.context==null?"null":data.context);
				s.find("#resOVoCommentscore2").text(data.point==null?"null":data.point);
				s.find("#resOVoCommenttime2").text(data.deliverTime==null?"null":data.deliverTime);
			}
		}
		if (data.status == "ACCEPT") {
			s.find("#resReplyToUser").text("vendor is cooking");
		}
		if (data.status == "CANCEL") {
			s.find("#resReplyToUser").text("This order has been canceled.");
		}
		if (data.status == "SENDING") {
			s.find("#resReplyToUser").text("vendor is sending your food");
			s.find("#userConfirmThisOrder").removeClass("hidden");
			s
					.find("#userConfirmThisOrder")
					.on(
							"click",
							function() {
								var confirmOrder = confirm("do you want to confirm this order?");
								if (confirmOrder) {
									$
											.ajax(
													{

														type : "post",
														url : "../usercenter/confirmOrder.do",
														cache : false,
														data : {
															orderId : orderId,

														},
														error : function(error) {
															
														}
													})
											.done(
													function(json) {
														var ss = s;
														if (json.isSuccess) {
														
															ss
																	.find(
																			"#userConfirmThisOrder")
																	.addClass(
																			"hidden");
															s
																	.find(
																			"#resOVoOrderState")
																	.text(
																			"FINISHED");
															s
																	.find(
																			"#resReplyToUser")
																	.text(
																			"this order has finished.");
															s.find("#resOVoCommentFunc").show();
															s.find("#showcommentlabel").hide();
															s.find("#resOVoComment2").show();
														}
													});
								}

							});
		}

		s.find("#detailLocation").text(data.detailLocation);
		s.find("#showImg").attr("src", "../file/img/" + data.logoPicUrl);

		if (data.status == "NEW") {
			s.find("#resReplyToUser").text(
					"this order is writting for checked.");
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
							
						}
					}).done(function(json) {
						var ss = s;
						if (json.isSuccess) {
							
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
			
			tr += "<td class=\"active\" id=\"productName\">"
					+ orderItems[i].productName + "</td>";
			tr += "<td class=\"active\" id=\"productPrice\">"
					+ orderItems[i].price + "</td>";
			tr += "<td class=\"active\" id=\"productAmount\">"
				+ orderItems[i].amount + "</td>";
			tr += "</tr>";
			s.find("#myordertbody").append(tr);
			sum += orderItems[i].price*orderItems[i].amount;
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
	commenterrormsg="";
	var inputvalue="";
	var inputvalue2="";
	var inputvalue3="";
	var inputvalue4;
	var resOVoCommentchildren = $(ele).closest('div').children();
	for(var i=0;i<resOVoCommentchildren.length;i++){
		if(resOVoCommentchildren.eq(i).attr('id')=="resOVoCommenttext"){
			inputvalue=resOVoCommentchildren.eq(i).val();
			continue;
		}
		if(resOVoCommentchildren.eq(i).attr('id')=="resOVoCommentscore"){
			inputvalue2=resOVoCommentchildren.eq(i).val();
			continue;
		}
		if(resOVoCommentchildren.eq(i).attr('id')=="resOVoCommenttime"){
			inputvalue3=resOVoCommentchildren.eq(i).val();
			continue;
		}
		if(resOVoCommentchildren.eq(i).attr('id')=="errorMsg3"){
			inputvalue4=resOVoCommentchildren.eq(i);
			continue;
		}
	}

	
	
	var id = $(ele).data("orderId");
	if (inputvalue3 != "" && isNaN(inputvalue3)) {
		commenterrormsg = getErrorMsg(commenterrormsg,
				"Error deliver time number,reinput pls,deliver time should be a number");
	}
	if (inputvalue2 != "") {
		if (isNaN(inputvalue2)) {
			commenterrormsg = getErrorMsg(commenterrormsg,
					"Error Score number,the score number should be a number,reinput pls");
		} else if ((Number(inputvalue2) <= 0 || Number(inputvalue2) > 5)) {
			commenterrormsg = getErrorMsg(
					commenterrormsg,
					"Error Score number,reinput pls,and the length should be greater than 0 and less than 5");
		}
	}
	if (commenterrormsg != "") {
		inputvalue4.hide();
		inputvalue4.html('');
		inputvalue4.show();
		inputvalue4.html(commenterrormsg);
		return false;
	} else {
		if (id != null) {
			$.ajax({
				type : "post",
				url : "../usercenter/saveComment.do",
				cache : false,
				asyn : false,
				data : {
					context : inputvalue==""?"nothing":inputvalue,
					point : inputvalue2==""?"3":inputvalue2,
					deliverTime : inputvalue3==""?"60":inputvalue3,
					orderId : $(ele).data("orderId")
				},
				error : function(error) {					
				}
			}).done(function(json) {
				if (json.isSuccess == true) {
					$(ele).closest('div').hide();
					var preele = $(ele).closest('div').prev();
					preele.show();
					setCommentLabel(preele,inputvalue,inputvalue2,inputvalue3);
					
				} else {
					$("#failchange").modal("show");
				}
			});
		}
	}

}

function setCommentLabel(preele,inputvalue,inputvalue2,inputvalue3){
	var preeleChildren=$(preele).children();
	for(var i=0;i<preeleChildren.length;i++){
		if(preeleChildren.eq(i).attr('id')=="resOVoComment"){
			preeleChildren.eq(i).show();
			preeleChildren.eq(i).text(inputvalue);
			continue;
		}
		if(preeleChildren.eq(i).attr('id')=="resOVoCommentscore2"){
			preeleChildren.eq(i).show();
			inputvalue2=preeleChildren.eq(i).text(inputvalue2);
			continue;
		}
		if(preeleChildren.eq(i).attr('id')=="resOVoCommenttime2"){
			preeleChildren.eq(i).show();
			inputvalue3=preeleChildren.eq(i).text(inputvalue3);
			continue;
		}
	}
}


var commenterrormsg = null;
function getErrorMsg(msg, newmsg) {
	if (msg == null) {
		msg = newmsg;
	} else {
		msg = msg + "<br/>" + newmsg;
	}
	return msg;
}

var formatDateTime2 = function (date) {  
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? ('0' + m) : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    var h = date.getHours();  
    var minute = date.getMinutes();  
    minute = minute < 10 ? ('0' + minute) : minute;  
    return y + '-' + m + '-' + d+' '+h+':'+minute;  
};
