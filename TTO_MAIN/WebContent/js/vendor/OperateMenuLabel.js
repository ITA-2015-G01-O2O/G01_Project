$(document).ready(function() {
	loadVendorInfo();
	$.get("/TTO_MAIN/vendor/productLabel/findProductLabel.do", function(data) {
		var str = eval(data);
		$.each(str, function() {
			addLaebl(this);
		});

		$(".aLabel").on("click", function() {
			$(".menuTestArea").empty();
			var labelValue=$(this).data('id');
			if( typeof(labelValue) != "undefined")
	  		{	
			$.get("/TTO_MAIN/vendor/product/loadProductByLabel.do",{label:labelValue}, function(data) {
				var str = eval(data);
				$.each(str, function() {
					var Menu = $("#menuModel").clone();
					addMenu1(Menu,this);
				});
				
				$(".btn.btn-danger.del").on("click", function() {
					deleteMenu1($(this).data('id'));
				});

				$(".btn.btn-primary.update").on("click", function() {
				  
				//	alert($("#menuName").val());
					var menu=$("#"+$(this).data('id'));
					$("#updateMenuName").val(menu.find("#menuName").text());
					$("#updateMenuPrice").val(menu.find("#menuPrice").text());
			        $(".modal.fade.bs-example-modal-sm").data('id',$(this).data('id'));
				});
				
				$("#saveMenuTypeBtn").on("click", function() {
					   var menuType=$("#addMenuType").val();
						$.get("addProductLabel.do", {
							LabelName : menuType,
						}, function(data) {
					         if(data.isSuccess){
					        	 window.location.href="FoodManageMent.view";
					         }
						});
					});
				
				$("#updateMenuBtn").on("click", function() {
			          var id=$(".modal.fade.bs-example-modal-sm").data('id');
			          updateMenu1(id);
				});
			});
		}else{
	         
			 window.location.href="/TTO_MAIN/vendor/product/FoodManageMent.view";
		}
		});

	});

});

function addEvent(){
	$('#labelArea li a').on('click', function () {
        var list = $('#labelArea li');
        list.removeClass('active');
        $(this).parent().addClass('active');
 
    });
}


function addLaebl(str) {
	var Menu = $("#a").clone();
	
	Menu.find(".aLabel").text(str.productLabelName);
	Menu.find(".aLabel").data('id', str.productLabelId);
	Menu.removeClass("active");
	Menu.attr("id", str.productLabelId);
	Menu.appendTo("#labelArea");
	$("<option id="+str.productLabelId+" value="+str.productLabelId+">"+str.productLabelName+"</option>").appendTo(".selectMenuType");
	addEvent();
}

function addMenu1(Menu,str) {
	Menu.attr("id", str.productId);
	Menu.find("#menuName").text(str.productName);
	Menu.find("#menuPrice").text(str.price);
	Menu.find(".btn.btn-danger.del").data('id', str.productId);
	Menu.find(".btn.btn-primary.update").data('id', str.productId);
	Menu.find("#srcImg").attr('src',"/TTO_MAIN/file/img/"+str.productPicUrl);
	Menu.removeClass("hidden");
	Menu.appendTo(".menuTestArea");
}
function deleteMenu1(id) {
	$.get("../vendor/product/deleteProduct.do", {
		pid : id,
	}, function(data) {
         if(data.isSuccess){
        	 window.location.href="/TTO_MAIN/vendor/product/FoodManageMent.view";
         }
	});
}

function updateMenu1(id) {
	
	var name=$("#updateMenuName").val();
	var price=$("#updateMenuPrice").val();
	$.get("/TTO_MAIN/vendor/product/updateProduct.do", {
		pid : id,
		name: name,
		price:price,
	}, function(data) {
         if(data.isSuccess){
        	 window.location.href="/TTO_MAIN/vendor/product/FoodManageMent.view";
         }
	});
}

function loadVendorInfo(){
	$.ajax({
	type:"post",
	url:"/TTO_MAIN/vendor/info/getVendorInfo.do",
	success:function(data){
	var name=data.data.storeName;
	$("#ShopNameLabel").text(name);
	var point=data.data.avgPoint;
	$("#avgPointLabel").text(point);
	var time=data.data.avgDeliverTime;
	$("#avgTimeLabel").text(time);
	var num=data.data.collectionNum;
	$("#collectionNumLabel").text(num);
	},
	        error:function(data){
	            alert("Load message fail!");
	        }
	});
	}