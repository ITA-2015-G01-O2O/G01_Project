function consumerlogin() {
	var username = $("#username").val();
	var password = $("#password").val();

	$.ajax({
		type : "post",
		url : "../consumer/login.do",
		cache : false,
		data : {
			loginname : username,
			password : password
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if(json.isSuccess==true){
				windows.location.href();
			}else{
				
			}
		}
	});
}

function addaddress() {
	$('#addressModal').on('show.bs.modal', function(e) {
		$("#deletebtn").on("click", function(e) {
			deletebtn(userId, td);
		});
	});
}

function addMeals(ele) {
	var divele = $(ele).closest('div').children();
	var proName = divele.eq(0).find('h4').eq(0).text();
	var proId = divele.eq(1).find('span').eq(0).val();
	var proprice = divele.eq(2).find('h5').eq(0).find('span').eq(0).val();
	addToCard(proName, proId, proprice);
}
function addToCard(proName, proId, proprice) {

}
