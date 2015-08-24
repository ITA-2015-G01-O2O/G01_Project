$(document).ready(function() {
	//function addMenu(id,data)
	//function addMenu()
	for (var i = 0; i < 12; i++) {
		{
			var Menu = $("#menuModel").clone();
			Menu.find("#menuName").text(i);
			Menu.find("#menuDesc").text("Balalalalalalalalalalalalalalalalalal" + i);
			Menu.removeClass("hidden");
			Menu.appendTo(".col-xs-12.MenuArea");
			Menu.attr("id", i);
			Menu.find(".btn.btn-danger.del").attr("id", i);
			Menu.find(".btn.btn-primary.update").attr("id", i);
		}
	}
	
	
		$(".btn.btn-danger.del").on("click", function() {
			alert("delete" + this.id);
		});


		$(".btn.btn-primary.update").on("click", function() {
			alert("update" + this.id);
		});

});