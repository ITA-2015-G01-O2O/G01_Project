var isAnnouncement=false;
var isMinPrice=false;
var isShipment=false;
var isStartTime=false;
var isFinishTime=false;
function verifyAnnouncement(){
	var announcement=$("#inputAnnouncement").val();
	if(announcement.length<255){
		isAnnouncement=true;
		$("#announcementmsg").attr("style","display: none;");
	}else{
		isAnnouncement=false;
		$("#announcementmsg").removeAttr("style");
	}				
}
function verifyMinPrice(){
	var minPrice=$("#inputMinAmount").val();
	if(minPrice.match(/\d+/g)){
		isMinPrice=true;
		$("#minAmountmsg").attr("style","display: none;");
	}else{
		isMinPrice=false;
		$("#minAmountmsg").removeAttr("style");
	}				
}
function verifyShipment(){
	var shipment=$("#inputShipment").val();
	if(shipment.match(/\d+/g)){
		isShipment=true;
		$("#shipmentmsg").attr("style","display: none;");
	}else{
		isShipment=false;
		$("#shipmentmsg").removeAttr("style");
	}				
}
function verifyStartTime(){
	var startTime=$("#startTime").val();
	if(startTime.length>0){
		isStartTime=true;
		$("#startTimemsg").attr("style","display: none;");
	}else{
		isStartTime=false;
		$("#startTimemsg").removeAttr("style");
	}				
}	
function verifyFinishTime(){
	var finishTime=$("#finishTime").val();
	if(finishTime.length>0){
		isFinishTime=true;
		$("#finishTimemsg").attr("style","display: none;");
	}else{
		isFinishTime=false;
		$("#finishTimemsg").removeAttr("style");
	}				
}
function loadMessage(){
	$.ajax({
		type:"post",
		url:"load.do",
		success:function(data){
			var store=data.data;
			$("#inputAnnouncement").val(store.announcement);
			$("#inputMinAmount").val(store.startingFee);
			$("#inputShipment").val(store.deliverFee);
			var s=store.serviceBeginTime;
			var date1=new Date(s).toString().substring(16,24);
			$("#startTime").val(date1);
			var f=store.serviceEndTime;
			var date2=new Date(f).toString().substring(16,24);
			$("#finishTime").val(date2);
		},
        error:function(data){
            alert("Load message fail!");
        }
	});
}
$(document).ready(function(){
	$("#inputAnnouncement").on("blur",verifyAnnouncement);
	$("#inputMinAmount").on("blur",verifyMinPrice);
	$("#inputShipment").on("blur",verifyShipment);
	loadMessage();
	$("#save").on("click",function(){
		verifyAnnouncement();
		verifyMinPrice();
		verifyShipment();
		if(isAnnouncement && isMinPrice && isShipment && isStartTime && isFinishTime ){
			$.ajax({
				type:"post",
				url:"update.do",
				data: {"minprice":$("#inputMinAmount").val(),"announcement":$("#inputAnnouncement").val(),
				"shipment":$("#inputShipment").val(),"starttime":$("#startTime").val(),"finishtime":$("#finishTime").val()},
             	dataType: "json",
             	success:function(data){
             		alert("Save success!");
             	},
             	error:function(data){
             		alert("Save fail!");
             	}
			});
		}
		else
			return false;
	});
});