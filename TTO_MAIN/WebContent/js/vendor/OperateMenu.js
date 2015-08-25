$(document).ready(function() {

	$.get("../product/loadProduct.do", function(data) {
		var str = eval(data);
		$.each(str, function() {
			addMenu(this);
		});

		$(".btn.btn-danger.del").on("click", function() {
			deleteMenu($(this).data('id'));
		});

		$(".btn.btn-primary.update").on("click", function() {
		  
		//	alert($("#menuName").val());
			var menu=$("#"+$(this).data('id'));
			$("#updateMenuName").val(menu.find("#menuName").text());
			$("#updateMenuPrice").val(menu.find("#menuPrice").text());
	        $(".modal.fade.bs-example-modal-sm").data('id',$(this).data('id'));
		});
	});

	$("#addMenuBtn").on("click", function() {
		var menuName = $("#menuName").val();
		var menuType = $("#menuType").text();
		var menuPrice = $("#menuPrice").val();
		$.get("../product/addProduct.do", {
			menuName : menuName,
			menuType : menuType,
			menuPrice : menuPrice,
		}, function(data) {
             if(data.isSuccess){
            	 window.location.href="/TTO_MAIN/product/FoodManageMent.view";
             }
		});
	});
	
	
	$("#updateMenuBtn").on("click", function() {
          var id=$(".modal.fade.bs-example-modal-sm").data('id');
          updateMenu(id);
	});

});

function addMenu(str) {
	var Menu = $("#menuModel").clone();
	Menu.attr("id",str.productId);
	Menu.find("#menuName").text(str.productName);
	Menu.find("#menuPrice").text(str.price);
	Menu.find(".btn.btn-danger.del").data('id', str.productId);
	Menu.find(".btn.btn-primary.update").data('id', str.productId);
	Menu.removeClass("hidden");
	Menu.appendTo(".col-xs-12.MenuArea");
}

function deleteMenu(id) {
	$.get("../product/deleteProduct.do", {
		pid : id,
	}, function(data) {
         if(data.isSuccess){
        	 window.location.href="/TTO_MAIN/product/FoodManageMent.view";
         }
	});
}

function updateMenu(id) {
	
	var name=$("#updateMenuName").val();
	var price=$("#updateMenuPrice").val();
	$.get("../product/updateProduct.do", {
		pid : id,
		name: name,
		price:price,
	}, function(data) {
         if(data.isSuccess){
        	 window.location.href="/TTO_MAIN/product/FoodManageMent.view";
         }
	});
}