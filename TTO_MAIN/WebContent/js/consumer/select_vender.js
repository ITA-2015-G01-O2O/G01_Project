/**
 * @LINEL
 * select-store by location
 */


$(function () {

    //default location, later on cookies
    var location_id = 50;

    var store_info = function () {
        $.ajax({
            type: "get",
            url: "../stores/location?location=" + location_id,
            cache: false,
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


    function operateDOM(store_list) {
        for (var i = 0; i < store_list.length; i++) {
            var new_store = $("#store_temp").clone();
            new_store.removeClass('hidden');
            new_store.removeAttr('id');
            new_store.find('.shopName').html(store_list[i].shopName);
            new_store.find('.avgPoint').html(store_list[i].avgPoint);
            new_store.find('.deliverFee').html(store_list[i].deliverFee);
            new_store.find('.shopId').attr("href", "../consumer/getMerprosById.view?merId=" + store_list[i].shopId);
            new_store.find('.logoPicURL').attr("src", store_list[i].logoPicURL);
            new_store.find('.startingFee').html(store_list[i].startingFee);
            //new_store.find('.isHot')[0].innerHTML = store_list[i].isHot;
            //new_store.find('.status');
            $("#store_temp").parent().append(new_store);
        }

    };

    store_info();

    //sort by type
    //sort order by



}());
