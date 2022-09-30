//加载页面
$(document).ready(function (){
    seedFailQuestion();
});

function seedFailQuestion() {
    $.ajax({
        url: "seedFailQuestion.action",
        type: "post",
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);

            datehang = "[";
            datalie = "[";

            for (var val in dataObj) {
                datehang = datehang + "'题号:"+ val +"'"+ ",";
                datalie = datalie + dataObj[val] +",";
            }
            datehang = datehang.substring(0,datehang.length-1);
            datehang = datehang+"]";
            datalie = datalie.substring(0,datalie.length-1);
            datalie = datalie+"]";
            var json1 = eval(datehang);
            var json2 = eval(datalie);
            table(json1,json2);
        },
        error: function () {
            alert("error");
        }
    });
}

function table(j1,j2) {
    var chart = Highcharts.chart('container', {
        title: {
            text: '错题题号与次数统计'
        },
        subtitle: {
            text: '普通的'
        },
        xAxis: {
            categories: j1
        },

        series: [{
            type: 'column',
            colorByPoint: true,
            data: j2,
            showInLegend: false,
        }]
    });
// 给 wrapper 添加点击事件
    Highcharts.addEvent(document.getElementById('wrapper'), 'click', function(e) {
        var target = e.target,
            button = null;
        if(target.tagName === 'BUTTON') { // 判断点的是否是 button
            button = target.id;
            switch(button) {
                case 'plain':
                    chart.update({
                        chart: {
                            inverted: false,
                            polar: false
                        },
                        subtitle: {
                            text: '普通的'
                        }
                    });
                    break;
                case 'inverted':
                    chart.update({
                        chart: {
                            inverted: true,
                            polar: false
                        },
                        subtitle: {
                            text: '反转'
                        }
                    });
                    break;
                case 'polar':
                    chart.update({
                        chart: {
                            inverted: false,
                            polar: true
                        },
                        subtitle: {
                            text: '极地图'
                        }
                    });
                    break;
            }
        }
    });
}