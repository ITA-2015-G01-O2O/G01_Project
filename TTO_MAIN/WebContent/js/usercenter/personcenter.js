$(function(){
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
			for(var i = 0;i<json.length;i++){
				var s = addUserOrder(json[i]);
				$("#home").append(s).show();
			}
		}
		$("#myordermodel").addClass("hidden");
	});
	
	

	$("#changePsd").on("click",function(){
		var flag = confirm("do you really want to change psd?");
		if(flag){
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
					alert("success");
					$("#userInfo_password").text(json.password);
				}
			});
			
		}
		
		
	});
	
	
	$("#charge").on("click",function(){
		var flag = confirm("do you really want to charge ?");
		if(flag){
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
					$("#userInfo_fund").text("￥："+json.fund);
					
				}
			});
			
		}
		
		
	});
	function addUserOrder(data){
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
		s.find("#resOVoComment").text(data.context);
		s.find("#detailLocation").text(data.detailLocation);
		s.find("#showImg").attr("src","../file/img/"+data.logoPicUrl);
		
		if(data.status=="NEW"){
			s.find("#userCancelThisOrder").removeClass("hidden");
			s.find("#userCancelThisOrder").on("click",function(){
				var cancelOrder = confirm("do you want to cancel this order?");
				if(cancelOrder){
					$.ajax({
						
						type : "post",
						url : "../usercenter/cancelOrder.do",
						cache : false,
						data : {
							orderId:orderId,
							
						},
						error : function(error) {
							alert(error);
						}
					}).done(function(json) {
						var ss= s;						
						if (json.isSuccess) {
							alert("success");
							ss.find("#userCancelThisOrder").addClass("hidden");
							s.find("#resOVoOrderState").text("CANCEL");
						}
					});
				}
				
			});
		}
		
		sum=0;
		var orderItems = data.orderEachItemList;
		
		for(var i = 0;i<orderItems.length;i++){
			var tr="<tr>";
			tr += "<td class=\"active\" id=\"productId\">"+orderItems[i].productId+"</td>";	
			tr +="<td class=\"active\" id=\"productName\">"+orderItems[i].productName+"</td>";
			tr +="<td class=\"active\" id=\"productPrice\">"+orderItems[i].price+"</td>";
			tr += "</tr>";
			s.find("#myordertbody").append(tr);
			sum+=orderItems[i].price;
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