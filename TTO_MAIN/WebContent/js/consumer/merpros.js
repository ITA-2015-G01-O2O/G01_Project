var merId;
$(function() {
	
	merId = $("#merId").val();
	$.cookie('com.group.tto.main.addorder' + merId, '', {
		expires : -1
	});
	if (merId == null) {
		return false;
	}

	$.ajax({
		type : "post",
		url : "../consumer/getMerchantById.do",
		cache : false,
		data : {
			merId : merId
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				setPros(json.data.products);

				setMerInfo(json.data);
				
				setProductLael(json.data.productLabels);

			} 
		}
	});
	getUserName();
});





function setProductLael(productLabel){
	if (productLabel.length != 0) {
		for (var i = 0; i < productLabel.length; i++) {
			addproductLabel(productLabel[i]);
		}
	}
}


function addproductLabel(proLabel){
	var labelBtn= $("#labelBtn").clone();
	labelBtn.show().appendTo($("#showAllpros"));
	setRomdomNameandId(labelBtn);
	$(labelBtn).text(proLabel.productLabelName);
	$(labelBtn).data("proLabelId",proLabel.productLabelId);
}



function setPros(products) {
	if (products.length != 0) {
		deleteproducts();
		for (var i = 0; i < products.length; i++) {
			addshowPro(products[i]);
		}
	}
}

function addshowPro(pro) {
	if (pro.isDelete != true) {
		var proimg = $("#proimg").clone();
		proimg.show().appendTo($("#meals"));
		setRomdomNameandId(proimg);
		var proimgchildren = $(proimg).children();
		if (pro.productPicUrl == null) {
			proimgchildren.eq(0).attr('src',
					'../img/img.png');
		} else {
			proimgchildren.eq(0).attr('src',
					'/TTO_MAIN/file/img/' + pro.productPicUrl);
		}
		var proInfo = $("#proInfo").clone();
		proInfo.show().appendTo($("#meals"));
		setRomdomNameandId(proInfo);
		var proInfos = $(proInfo).children();
		proInfos.eq(0).text(pro.productName);
		proInfos.eq(1).text(pro.productId);
		proInfos.eq(2).find('span').eq(0).text(pro.price);
		proInfos.eq(3).find('span').eq(0).text(pro.salesVolume);
	}
}

function setMerInfo(json) {
	if(json.logoPicUrl==null){
		$("#storeImgId").attr('src','../img/img.png');
	}else{
		$("#storeImgId").attr('src','/TTO_MAIN/file/img/'+json.logoPicUrl);
	}
	
	$("#storeName").text(json.storeName);
	$("#detailLocation").text('Address:' + json.detailLocation);
	$("#avgPoint").text(json.avgPoint + ' scores');
	$("#avgDeliverTime").text(json.avgDeliverTime + " minute(s)");
	$("#startingFee").text(json.startingFee + " yuan up to send");
	if (json.deliverFee == 0) {
		$("#deliverFee").text('Free deliver fee');
	} else {
		$("#deliverFee").text("deliver fee :" + json.deliverFee);
	}

	$("#announcement").text(json.announcement);
	$("#serviceBeginTime").text(json.serviceBeginTime);
	$("#serviceEndTime").text(json.serviceEndTime);
}

function deliveryPros() {
	$.ajax({
				type : "post",
				url : "../consumer/isConsumerLogin.do",
				cache : false,
				error : function(error) {
					alert("error");
				}
			})
			.done(
					function(json) {
						if (json != "") {
							if (json.isSuccess == true) {
								var dataString = getOrder();
								if (dataString.length>0) {
									var dataJson = JSON.stringify(dataString);

									$.cookie('com.group.tto.main.addorder'
											+ merId, dataJson);

									console.log(dataJson);

									window.location.href = '../consumer/confirmOrder.view?merId='
											+ merId;

								}else{
									$("#orderEmpty").modal("show");
								}
							} else {
								$("#relogin").modal("show");
							}
						}
					});
}
function getOrder() {
	var divele = $("#ordersCard").children();
	var orderArray = new Array();

	divele.each(function() {
		var orderclass = $(this).attr("class");
		if (orderclass == "orderBox") {

			var orderchildren = $(this).children();
			var orderclassId = orderchildren.eq(1).text();
			if (orderclassId != "") {
				var GLOBAL_OrderInfo = new ORDERINFO();
				GLOBAL_OrderInfo.proId = orderclassId;

				GLOBAL_OrderInfo.proName = orderchildren.eq(0).text();
				GLOBAL_OrderInfo.bid = $("#merId").val();
				GLOBAL_OrderInfo.proNum = orderchildren.eq(3).val();

				var priceString = orderchildren.eq(5).text();
				var price1 = priceString.substr(1, priceString.length - 1);

				GLOBAL_OrderInfo.proPrice = price1;

				orderArray.push(GLOBAL_OrderInfo);
			}

		}
	});

	return orderArray;
}


function addaddress() {
	$('#addressModal').on('show.bs.modal', function(e) {
		$("#deletebtn").on("click", function(e) {
			deletebtn(userId, td);
		});
	});
}

var moneyCount = 0;

function addMeals(ele) {
	var divele = $(ele).closest('div').children();
	var proName = divele.eq(0).text();
	var proId = divele.eq(1).text();
	var proprice = divele.eq(2).find('span').eq(0).text();
	addToCard(proName, proId, proprice);
}

function addToCard(proName, proId, proprice) {
	var divele = $("#ordersCard").children();
	var is_add = false;
	divele.each(function() {
		var orderclass = $(this).attr("class");
		if (orderclass == "orderBox") {
			var orderchildren = $(this).children();
			var orderclassId = orderchildren.eq(1).text();
			if (orderclassId == proId) {
				is_add = true;
				var number1 = orderchildren.eq(3).val();
				var priceString = orderchildren.eq(5).text();
				var price1 = priceString.substr(1, priceString.length - 1);
				var number2 = Number(number1) + 1;
				var price2 = Number(price1) + Number(proprice);
				updatePaymoney(proprice);
				orderchildren.eq(3).val(number2);
				orderchildren.eq(5).text("$" + price2);
			}
		}
	})

	if (!is_add) {
		var orderBox1 = addPointPair();
		var orderBox = $(orderBox1).children();
		orderBox.eq(0).text(proName);
		orderBox.eq(1).text(proId);
		orderBox.eq(3).val(1);
		orderBox.eq(5).text("$" + proprice);
		orderBox.eq(6).text(proprice);
		updatePaymoney(proprice);
	}

}

function updatePaymoney(money) {
	var paychildren = $("#payCount").children();
	var money2 = Number(money) + Number(moneyCount);
	paychildren.eq(0).text(money2);
	moneyCount = money2;
}

function addPointPair() {
	var orderBox1 = $("#orderBoxCopy").clone();
	orderBox1.show().appendTo($("#ordersCard"));
	return orderBox1;
}

function setRomdomNameandId($element) {
	$element.prop('name', $element.prop("name") + "_"
			+ Math.floor(Math.random() * (1000000)));
	$element.prop('id', $element.prop("id") + "_"
			+ Math.floor(Math.random() * (1000000)));
}

function add1(ele) {
	var orderchildren = $(ele).closest('div').children();
	var number1 = orderchildren.eq(3).val();
	var number2 = Number(number1) + 1;
	orderchildren.eq(3).val(number2);

	var money = orderchildren.eq(6).text();
	var money2 = number2 * Number(money);

	orderchildren.eq(5).text("$" + money2);
	updatePaymoney(Number(money));
}

function del1(ele) {
	var orderchildren = $(ele).closest('div').children();
	var number1 = orderchildren.eq(3).val();
	var orgprice = Number(orderchildren.eq(6).text());

	if (number1 != 0) {
		var number2 = Number(number1) - 1;
		if (number2 == 0) {
			orderchildren.remove();
			updatePaymoney(-orgprice);
		} else {
			orderchildren.eq(3).val(number2);

			orderchildren.eq(5).text("$" + Number(number2) * orgprice);
			updatePaymoney(-orgprice);
		}
	} else {
		orderchildren.remove();
	}
}

function getComby(score) {
	deleteComment();
	$.ajax({
		type : "post",
		url : "../comment/getallCommentByScore.do",
		cache : false,
		data : {
			merId : merId,
			score : score
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				addComment(json.data);
			}
		}
	});
}

function conment() {
	deleteComment();
	$.ajax({
		type : "post",
		url : "../comment/getallCommentBySid.do",
		cache : false,
		data : {
			merId : merId
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				addComment(json.data);
			}
		}
	});
}

function addComment(com) {
	for (var i = 0; i < com.length; i++) {
		showaddComment(com[i]);
	}

}
function showaddComment(data) {
	var comCopy = $("#commentInfo").clone();
	comCopy.show().appendTo($("#comment"));
	setRomdomNameandId($(comCopy));
	var comcopy1 = $(comCopy).children();
	comcopy1.eq(0).find('span').text(data.point);
	comcopy1.eq(1).find('span').text(data.deliverTime);
	comcopy1.eq(2).find('h5').text(data.context);
}

function deleteComment() {
	var divele = $("#comment").children();
	divele.each(function() {
		var orderclass = $(this).attr("class");
		var orderid = $(this).attr("id");
		if (orderid!=undefined && orderid.indexOf("commentInfo") != -1) {

			if (orderid != "commentInfo") {
				$(this).remove();
			}

		}
	});
}
function deleteproducts() {
	var divele = $("#meals").children();
	divele.each(function() {
		var orderclass = $(this).attr("class");
		var orderid = $(this).attr("id");
		if (orderid!=undefined && orderid.indexOf("proimg") != -1) {
			if (orderid != "proimg") {
				$(this).remove();
			}
		}
		if (orderid!=undefined && orderid.indexOf("proInfo") != -1) {
			if (orderid != "proInfo") {
				$(this).remove();
			}
		}
	});
}

function clickproLabel(ele){
	var productlabelId=$(ele).data("proLabelId");
	deleteproducts();
	$.ajax({
		type : "post",
		url : "../consumer/getprosByproLabel.do",
		cache : false,
		data : {
			merId : merId,
			productlabelId:productlabelId
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				setPros(json.data);
			} 
		}
	});
}

function clickproLabelgetAll(){
	$.ajax({
		type : "post",
		url : "../consumer/getMerchantById.do",
		cache : false,
		data : {
			merId : merId
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				setPros(json.data.products);
			} 
		}
	});
}


function addCollect(){
	var flag=false;
	if( $("#loginameshow").data("successlogin")!=undefined && $("#loginameshow").data("successlogin")==true ){
		flag=true;
	}else{
		$("#relogin").modal("show");
	}
	
	
	
	if(flag){
		$.ajax({
			type : "post",
			url : "../collect/addCollect.do",
			cache : false,
			data:{
				storeId:merId
			},
			error : function(error) {
				alert("error");
			}
		})
		.done(
				function(json) {
					if (json != "") {
						if (json.isSuccess == true) {
							$("#successaddCollect").modal("show");
						}
					}
				});
	}
	
}


