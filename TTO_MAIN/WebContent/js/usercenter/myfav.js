//$(function(){
//	$("button[name=cancelfav]").on("click",function(){
//		var yes = confirm("do you want to cancel?");
//		if(yes){
//			
//			$.ajax({
//				
//				type : "post",
//				url : "../usercenter/cancelUserFavVendor.do",
//				cache : false,
//				data : {
//					
//				},
//				error : function(error) {
//					alert("error");
//				}
//			}).done(function(json) {
//				if (json != "") {
//					$(this).parent().parent().parent().parent().parent().remove();
//					alert("success");
//				}
//			});
//			
//			
//			
//			
//			
//		}
//		
//	});
//	
//	
//	
//});