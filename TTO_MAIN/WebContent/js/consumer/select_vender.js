/**
 * @LINEL
 * select-store by location
 */

$(function () {

    /**
     *jquery sort, discard DB order
     */
    var location_id = $.cookie("location_Id"),
        sortType = "salesCount",
        orderType = 1,
        storeType = "allType"

    var type_list = new Array();
    var stores,
        sort_store_list;
    var carousel_imgs = $("#carousel img");

    //console.log(carousel_imgs.length);

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
                //console.log(json);
                stores = json;
                sort_store_list = json;
                operate_store_DOM(stores);
                render_type_list();
                addEvents();
            }
        });
    }

    //dom operation
    function operate_store_DOM(store_list) {
        var count_img = 0;
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
            //hot img
            console.log("hot state" + store_list[i].isHot);
            if (store_list[i].isHot) {
                carousel_imgs[count_img++].attr("src", "../file/img/" + store_list[i].logoPicURL);
            }
            //new_store.find('.status');
            $("#store_temp").parent().append(new_store);
            //generate_list
            add_type_list(store_list[i].storeType);
        }
    };

    // generate store type bar
    function add_type_list(list_node) {
        var count = 0;
        for (var i = 0; i < type_list.length; i++) {
            if (type_list[i] == list_node) {
                count++;
            }
        }
        if (count == 0) {
            type_list[type_list.length] = list_node;
        }
    }

    function render_type_list() {
        //console.log(type_list);
        for (var i = 0; i < type_list.length; i++) {
            var temp = $('#store_type_list>li:first').clone();
            temp.removeClass('active');
            temp.find('a').html(type_list[i]);
            temp.appendTo($('#store_type_list'));
        }
    }


    //----------------sort and order events--------------
    function addEvents() {

        $('#store_type_list li a').on('click', function () {
            var list = $('#store_type_list li');
            list.removeClass('active');
            $(this).parent().addClass('active');
            //sort by
            if ($(this).text() != '全部') {
                sort_stores_operation($(this).text());
            } else {
                clean_stores();
                sort_store_list = stores;
                operate_store_DOM(stores);
            }
        });

        $('#sorter button').on('click', function () {
            //console.log($(this).text());
            orderType = orderType * (-1);
            var type_icon;

            if (orderType == -1) {
                type_icon = "glyphicon-sort-by-attributes-alt";
            } else {
                type_icon = "glyphicon-sort-by-attributes";
            }

            $(this).parent().find('.glyphicon').removeClass('glyphicon-sort-by-attributes').removeClass('glyphicon-sort-by-attributes-alt').addClass('hidden');
            $(this).find('.glyphicon').removeClass('hidden').addClass(type_icon);
            sortType = $(this).attr("id");
            order_stores_operation();
        });


    }
    //sort by type
    function sort_stores_operation(sortType) {
        sort_store_list = new Array();
        for (var i = 0, j = 0; i < stores.length; i++) {
            if (stores[i].storeType == sortType) {
                sort_store_list[j] = stores[i];
                j++;
            }
        }
        //console.log(sort_store_list);
        clean_stores();
        operate_store_DOM(sort_store_list);
    }


    //sorter by order
    function order_stores_operation() {
        var temp, len = sort_store_list.length;
        for (var i = 0; i < len - 1; i++) {
            for (var j = i + 1; j < len; j++) {
                if (compare_result(i, j)) {
                    temp = sort_store_list[i];
                    sort_store_list[i] = sort_store_list[j];
                    sort_store_list[j] = temp;
                }
            }
        }
        //console.log(sort_store_list);
        clean_stores();
        operate_store_DOM(sort_store_list);
    }

    function compare_result(i, j) {
        if (sortType == "sales") {
            //console.log("按照销量排序");
            return (orderType * sort_store_list[i].salesNum >= orderType * sort_store_list[j].salesNum);
        }
        if (sortType == "score") {
            //console.log("按照评分排序");
            return (orderType * sort_store_list[i].avgPoint >= orderType * sort_store_list[j].avgPoint);
        }
        if (sortType == "speed") {
            //console.log("按照送餐时间排序");
            return (orderType * sort_store_list[i].avgDeliverTime >= orderType * sort_store_list[j].avgDeliverTime);
        }
        return 0;
    }


    //select then search    

    $('.search input').on('keydown', function () {
        var input = $('.search input').val();
        console.log("select");

    });


    //clean DOM
    function clean_stores() {
        for (var i = 0; i < stores.length; i++) {
            $("#store_temp").next().remove();
        }
    }

    //ajax call data
    store_info();


}());
