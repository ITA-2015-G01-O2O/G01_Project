/**
 * @param acceleration 速度
 * @param stime 时间间隔 (毫秒)
 **/
function gotoTop(acceleration, stime) {
    acceleration = acceleration || 0.1;
    stime = stime || 10;
    var x1 = 0;
    var y1 = 0;
    var x2 = 0;
    var y2 = 0;
    var x3 = 0;
    var y3 = 0;
    if (document.documentElement) {
        x1 = document.documentElement.scrollLeft || 0;
        y1 = document.documentElement.scrollTop || 0;
    }
    if (document.body) {
        x2 = document.body.scrollLeft || 0;
        y2 = document.body.scrollTop || 0;
    }
    var x3 = window.scrollX || 0;
    var y3 = window.scrollY || 0;

    // 滚动条到页面顶部的水平距离
    var x = Math.max(x1, Math.max(x2, x3));
    // 滚动条到页面顶部的垂直距离
    var y = Math.max(y1, Math.max(y2, y3));

    // 滚动距离 = 目前距离 / 速度, 因为距离原来越小, 速度是大于 1 的数, 所以滚动距离会越来越小
    var speeding = 1 + acceleration;
    window.scrollTo(Math.floor(x / speeding), Math.floor(y / speeding));

    // 如果距离不为零, 继续调用函数
    if (x > 0 || y > 0) {
        var run = "gotoTop(" + acceleration + ", " + stime + ")";
        window.setTimeout(run, stime);
    }
}

$(function() {
	getUserName();
	isStore();
    //setAddress
    if ($.cookie("location_Id") != null) {
        $("#address").html($.cookie("location_name"));
    } else {
        $("#address").hide();
    }
});

function isStore(){
	 $.ajax({
	        type: "post",
	        url: "/TTO_MAIN/account/isStore.do",
	        cache: false,
	        error: function (error) {
	            alert("error1");
	        }
	    }).done(function (json) {
	        if (json != "") {
	            if (json.isSuccess == true) {
	            	if(json.data=="NORMAL"){
	            		$("#openStore").hide();
	            		$("#showmyShop").show();
	            		$("#logout").show();
	            		$("#openStore").children().eq(0).attr('href',"../vendor/product/NewOrder.view");
	            	}else if(json.data=="CHECK"){
	            		$("#openStore").show();
	            		$("#showmyShop").hide();
	            		$("#openStore").data('openStore',"../vendor/register/register4.view");
	            	}else if(json.data=="FREEZE"){
	            		$("#openStore").show();
	            		$("#showmyShop").hide();
	            		$("#openStore").data('openStore',"../vendor/register/register1.view");
	            	}
	            } else {
	            	 $("#openStore").show();
	            	 $("#showmyShop").hide();
	            	 $("#openStore").data('openStore',"../vendor/register/register1.view");
	            }
	        }
	    });
}


function getUserName(){
	 $.ajax({
	        type: "post",
	        url: "/TTO_MAIN/account/getMainName.do",
	        cache: false,
	        error: function (error) {
	            alert("error2");
	        }
	    }).done(function (json) {
	        if (json != "") {
	            if (json.isSuccess == true) {
	                $("#loginameshow").show();
	                $("#logintitle").hide();
	                $("#registertitle").hide();
	                $("#logout").show();
	                //vendor/order/NewOrder.view
	                $("#loginameshow").children().eq(0).attr("href","/TTO_MAIN/usercenter/personcenter.view");
	                $("#loginameshow").data("successlogin",true);
	                $("#loginameshow").children().eq(0).text(json.data);
	            } else {
	                $("#logintitle").show();
	                $("#registertitle").show();
	                $("#loginameshow").hide();
	            }
	        }
	    });
}
function isstorelogin(){
	  $.ajax({
	        type: "post",
	        url: "/TTO_MAIN/account/getMainName.do",
	        cache: false,
	        asyn:false,
	        error: function (error) {
	            alert("error3");
	        }
	    }).done(function (json) {
	        if (json != "") {
	            if (json.isSuccess == true) {
	            	 $("#relogin").modal("hide");
	            	 window.location.href= $("#openStore").data('openStore');
	            	 return true;
	            } else {
	               $("#relogin").modal("show");
	               return false;
	            }
	        }
	    });
}

function consumerlogin() {
	var username = $("#username").val();
	var password = $("#password").val();

	$.ajax({
		type : "post",
		url : "/TTO_MAIN/account/login.do",
		cache : false,
		data : {
			loginname : username,
			password : password
		},
		error : function(error) {
			alert("error4");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				// window.location.href='../account/select-vender.view';
				$("#relogin").modal("hide");
				$("#logout").show();
				getUserName();
				isStore();
			} else {
				$("#errorMsg").show();
				$("#errorMsg").text(json.data);
			}
		}
	});
}




