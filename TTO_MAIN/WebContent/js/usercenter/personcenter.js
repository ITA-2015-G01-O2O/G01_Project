$(function(){
	$('#myTabs a').click(function(e) {
		e.preventDefault();
		$(this).tab('show');
	});
	alert("hi");
	
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
		alert(json.length);
		if (json != "") {
			alert("success");
			$("#myordermodel").removeClass("hidden");
			for(var i = 0;i<json.length;i++){
				alert(i);
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
				}
			});
			
		}
		
		
	});
	
	
	$("#charge").on("click",function(){
		var flag = confirm("do you really want to change psd?");
		if(flag){
			$.ajax({
				
				type : "post",
				url : "../usercenter/chargeUserFund.do",
				cache : false,
				data : {
					
				},
				error : function(error) {
					alert("error");
				}
			}).done(function(json) {
				alert(json.length);
				if (json != "") {
					alert("success");
					
				}
			});
			
		}
		
		
	});
	function addUserOrder(data){
		var s = $("#myordermodel").clone();
		alert("copying..........");
		
		setRomdomNameandId(s);
		
		return s;
	}
	function setRomdomNameandId($element) {
		$element.prop('name', $element.prop("name") + "_"
				+ Math.floor(Math.random() * (1000000)));
		$element.prop('id', $element.prop("id") + "_"
				+ Math.floor(Math.random() * (1000000)));
	}
	
	
//	function addUserOrder(){
//		var str="";
//		str+="<div class=\"col-xs-12 res_content  page-header\">";
//		str+="<div class=\"col-xs-1\"></div>";
//		str+="<div class=\"col-xs-2\">";
//		str+="<img src=\"../img/usercenter/title_admin.png\" /></div>";
//		
//		str+="<div class=\"col-xs-6\">";
//		str+="<ul class=list-inline\">";
//		str+="<li>res name:XXX</li>";
//		str+="<li> res tel:10000000</li></ul>";
//		
//		str+="<ul class=\"list-inline\">";
//		str+="<li>order number:XXX</li>";
//		str+="<li>oder time:2015-01-02</li></ul></div>";
//
//		str+="<div class=\"col-xs-2\">";
//		str+="<div>order state:</div><div>";
//			
//		str+="<span class=\"btn btn-info\">affect</span></div></div>";
//			
//		
//		str+="<div class=\"col-xs-1\"></div></div>";
//
//		str+="<div class=\"\">";
//		str+="<div class=\"clo-xs-12\">";
//		str+="<div class=\"col-xs-4\">";
//		str+="<div class=\"\">";
//		str+="<table class=\"table table-bordered\">";
//		str+"<caption>order info</caption><thead>";
//						
//		str+="<th class=\"active\">food number</th>";
//							<th class="active">food name</th>
//							<th class="active">food price</th>
//						</thead>
//						<tfoot>
//							<th class="active">food number</th>
//							<th class="active">food name</th>
//							<th class="active">food price</th>
//						</tfoot>
//						<tbody>
//							<tr>
//								<td class="active">order 1</td>
//								<td class="success">name</td>
//								<td class="warning">price</td>
//							</tr>
//							<tr>
//								<td class="active">order 1</td>
//								<td class="success">name</td>
//								<td class="warning">price</td>
//							</tr>
//							<tr>
//								<td class="active">order 1</td>
//								<td class="success">name</td>
//								<td class="warning">price</td>
//							</tr>
//							<tr>
//								<td class="active">order 1</td>
//								<td class="success">name</td>
//								<td class="warning">price</td>
//							</tr>
//
//						</tbody>
//					</table>
//					<div class="text-right">total:$24
//						<!--<button type="button" class="btn btn-success">confirm</button>-->
//
//					</div>
//				</div>
//			</div>
//			<div class="col-xs-8">
//
//				<div class="col-xs-12 myclass1">
//					<div class="col-xs-2">
//
//					</div>
//					<div class="page-header ">order state</div>
//					<div>contacter:XXX</div>
//					<div>tel:XXXXX</div>
//					<div>remarks</div>
//					<div>comment</div>
//					<div class="page-header ">addr:XXXXX</div>
//				</div>
//				<!--<div class="clearfix list-container">
//
//			<div class="list-wrapper clearfix" mon="area=mid_category_hot_tuangou">
//				<div class="title">热门团购</div>
//				<ul class="mid-list list-inline">
//					<li><a href="http://www.nuomi.com/deal/movies" class="" mon="element=电影&amp;position=0">电影</a></li>
//					<li><a href="http://www.nuomi.com/392" class="hot" mon="element=自助餐&amp;position=1">自助餐</a></li>
//					<li><a href="http://www.nuomi.com/341" class="" mon="element=KTV&amp;position=2">KTV</a></li>
//					<li><a href="http://www.nuomi.com/364" class="hot" mon="element=火锅&amp;position=3">火锅</a></li>
//					<li><a href="http://www.nuomi.com/881" class="" mon="element=蛋糕&amp;position=4">蛋糕</a></li>
//					<li><a href="http://t.nuomi.com" class="hot" mon="element=酒店&amp;position=5">酒店</a></li>
//					<li><a href="http://www.nuomi.com/380" class="" mon="element=小吃快餐&amp;position=6">小吃快餐</a></li>
//					<li><a href="http://www.nuomi.com/391" class="" mon="element=西餐&amp;position=7">西餐</a></li>
//				</ul>
//			</div>
//		</div>-->
//				<div class="myclass1">
//					<div class="text-center mymainhei">waiting for check by res</div>
//					<div class=" text-right">
//						<button class="btn btn-warning">cancel order?</button>
//					</div>
//				</div>
//			</div>
//		</div>
//	</div>
//
//	}
	
	
});