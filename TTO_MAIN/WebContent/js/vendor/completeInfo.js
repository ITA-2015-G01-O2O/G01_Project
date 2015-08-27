var isStorePic=false;
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
function verifyStorePic(){
	var storePic=$("#inputStorePic").val();
	if(storePic.length>0){
		isStorePic=true;
		$("#storePicmsg").attr("style","display: none;");
	}else{
		isStorePic=false;
		$("#storePicmsg").removeAttr("style");
	}				
}
$(document).ready(function(){
	$('#ci_form').ajaxForm({
		type:'post',
		url:'update.do',
		beforeSubmit:function(){
			verifyAnnouncement();
			verifyMinPrice();
			verifyShipment();
			verifyStartTime();
			verifyFinishTime();
			verifyStorePic();
			if(isAnnouncement && isMinPrice && isShipment && isStartTime && isFinishTime && isStorePic){
				return true;
			}else
				return false;
			},
		success:function(data){
			window.location.href="/TTO_MAIN/vendor/order/NewOrder.view";
		}
	});
	
	
	$("#inputAnnouncement").on("blur",verifyAnnouncement);
	$("#inputMinAmount").on("blur",verifyMinPrice);
	$("#inputShipment").on("blur",verifyShipment);
	
});