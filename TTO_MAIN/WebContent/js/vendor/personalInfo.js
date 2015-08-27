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
$(document).ready(function(){
	loadMessage();

});