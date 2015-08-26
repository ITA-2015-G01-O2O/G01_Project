function loadMessage(){
	$.ajax({
		type:"post",
		url:"load.do",
		success:function(data){
			var name=data.data.realName;
			$("#trueNamemsg").val(name);
			var id=data.data.idCardNumber;
			$("#dicardnumbermsg").val(id);
		},
        error:function(data){
            alert("Load message fail!");
        }
	});
}
$(document).ready(function(){
	loadMessage();
});