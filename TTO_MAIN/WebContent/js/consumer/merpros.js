$(function() {
	var merId = $("#merId").val();
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
				
			} else {

			}
		}
	});
})

function setPros(products) {
	if (products.length != 0) {
		for (var i = 0; i < products.length; i++) {
			addshowPro(products[i]);
		}
	}
}

function addshowPro(pro){
	var proimg = $("#proimg").clone();
	proimg.show().appendTo($("#meals"));
	
	var proInfo = $("#proInfo").clone();
	proInfo.show().appendTo($("#meals"));
	
	var proInfos=$(proInfo).children();
	proInfos.eq(0).text(pro.productName);
	proInfos.eq(1).text(pro.productId);
	proInfos.eq(2).find('span').eq(0).text(pro.price);
	proInfos.eq(3).find('span').eq(0).text(pro.salesVolume);
}

function setMerInfo(json){
	$("#storeName").text(json.storeName);
	$("#detailLocation").text('地址：'+json.detailLocation);
	$("#avgPoint").text(json.avgPoint+'分数');
	$("#avgDeliverTime").text(json.avgDeliverTime+"分钟");
	$("#startingFee").text(json.startingFee+"元起送");
	if(json.deliverFee==0){
		$("#deliverFee").text('免费起送');
	}else{
		$("#deliverFee").text(json.deliverFee+"元快递费");
	}
	
	$("#announcement").text(json.announcement);
	$("#serviceBeginTime").text(json.serviceBeginTime);
	$("#serviceEndTime").text(json.serviceEndTime);
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
	/**
	 * prop获取第一个匹配的属性，然后替换
	 */
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
