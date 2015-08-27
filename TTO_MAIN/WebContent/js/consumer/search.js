/**
 * @author LINEL
 * 
 */
$(function () {
    var keyword,
        search_num,
        search_btn = $('#search-btn'),
        search_input = $(".search-Place"),
        maplist = $("#maplist"),
        last_time = 0,
        temp = $("#temp");

    $("#background").click(function (e) {
        maplist.hide();
    });

    function search() {
        if (keyword != "") {
            $.ajax({
                type: "post",
                url: "../location/loadLocation.do",
                cache: false,
                data: {
                    query: keyword,
                    limit: search_num
                },
                dataType: 'json',
                success: function (result) {
                    //console.log(result);
                    add_to_list(result.data);
                },
                error: function (error) {
                    alert("error" + error);
                }
            });
        } else {
            maplist.hide();
        }
    }

    search_input.on("keyup", function (event) {
        var code = event.keyCode,
            input = $.trim(search_input.val()),
            now = new Date().getTime();

        if (input == keyword || (now - last_time) < 500) {
            last_time = now;

            return 0;
        }

        if ((code >= 65 && code <= 105) || code == 8 || code == 32) {
            keyword = input;
            search_num = 10;
            maplist.show();
            maplist.removeClass('longer-list');
            //console.log(keyword);
            cleanDOM();
            search();
            last_time = now;
        }

    });

    search_btn.on("click", function () {
        search_num = 100;
        cleanDOM();
        maplist.addClass('longer-list');
        maplist.show();
        search();
    });

    function cleanDOM() {
        maplist.empty();
    }


    //DOM operation
    function add_to_list(list) {
        if (list.length == 0) {
            maplist.hide();
        }
        for (var i = 0; i < list.length; i++) {
            var new_li = temp.clone().removeClass('hidden').attr("id", list[i].locationId);

            new_li.find('a').html(list[i].area + ',' + list[i].city + ',' + list[i].place);

            new_li.on('click', function () {
                console.log($(this));
                set_Location_Cookies($(this).attr("id"), $(this).find('a').html());
            });
            maplist.append(new_li);
        }
    }

    function set_Location_Cookies(id, address) {
        $.cookie("location_Id", id, {
            expires: 7,
            path: '/TTO_MAIN'
        });

        $.cookie("location_name", address, {
            expires: 7,
            path: '/TTO_MAIN'
        });

        window.location.href = "/TTO_MAIN/stores/select-vender.view";
    }


})
