/*
 * dashboard模块
 */
layui.define(['jquery', 'element'],function(exports){ //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    $= layui.jquery;
    var element = layui.element;
    var obj = {
        monitor: function (ctx) {
            setInterval(function () {
                $.ajax({
                    type: "GET",
                    url: ctx + "monitor",
                    dataType: "json",
                    success: function(data){
                        var cpu = data.cpu.toFixed(4) + "%";
                        element.progress('cpu', cpu);
                        var memory = data.memory.toFixed(4) + "%";
                        element.progress('memory', memory);
                    },
                    error: function (e) {

                    }
                });
            }, 5000);
        }
    };

    //输出dashboard接口
    exports('dashboard', obj);
});
