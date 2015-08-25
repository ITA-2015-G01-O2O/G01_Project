/**
 * @LINEL
 * select-store by location
 */

$(function () {

    //default parameters *location_id =50, later on cookies
    var location_id = 50,
        sortType = "salesCount",
        orderType = "asc",
        storeType = "allType"


    var param = {
        location: location_id,
        sortType: sortType,
        orderType: orderType,
        storeType: storeType
    };

    //ajax call stores
    var store_info = function () {
        $.ajax({
            type: "get",
            url: "../stores/location",
            cache: false,
            data: param,
            error: function (error) {
                alert("error");
            }
        }).done(function (json) {
            if (json != "") {
                console.log(json)
                operateDOM(json);
            }
        });
    }

    //dom operation
    function operateDOM(store_list) {
        for (var i = 0; i < store_list.length; i++) {
            var new_store = $("#store_temp").clone();
            new_store.removeClass('hidden');
            new_store.removeAttr('id');
            new_store.find('.shopName').html(store_list[i].shopName);
            new_store.find('.avgPoint').html("评分：" + store_list[i].avgPoint);
            new_store.find('.deliverFee').html("外卖费" + store_list[i].deliverFee);
            new_store.find('.shopId').attr("href", "../consumer/getMerprosById.view?merId=" + store_list[i].shopId);
            new_store.find('.logoPicURL').attr("src", "../file/img/" + store_list[i].logoPicURL);
            new_store.find('.startingFee').html(store_list[i].startingFee + "元 起送");
            new_store.find('.salesNum').html("销量:" + store_list[i].salesNum);
            new_store.find('.avgDeliverTime').html(store_list[i].avgDeliverTime + "分钟送达");
            //new_store.find('.isHot')[0].innerHTML = store_list[i].isHot;
            //new_store.find('.status');
            $("#store_temp").parent().append(new_store);
        }

    };

    //----------------sort by type
    //----------------sort order by

    $('#store_type_list li a').on('click', function () {
        var list = $('#store_type_list li');

        list.removeClass('active');

        console.log($(this).text());
        $(this).parent().addClass('active');
    });


    //ajax call
    store_info();

}());
