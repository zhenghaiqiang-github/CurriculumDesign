//成绩分析

//加载页面
$(document).ready(function (){
    selectAvg();
});

//平均分曲线图
function selectAvg() {
    $.ajax({
        url: "selectAvg.action",
        type: "post",
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);
            categories = new Array();
            data2 = new Array();
            personCount = new Array();
            max = new Array();
            min = new Array();
            allCount = 0;
            for (i = 0; i < dataObj.length; i++) {
                data2.push(dataObj[i].Avg);
                categories.push(dataObj[i].examName);
                personCount.push(dataObj[i].Count);
                max.push(dataObj[i].Max);
                min.push(dataObj[i].Min);
                allCount = allCount+dataObj[i].Count;
            }
            var options = {
                chart: {
                    type: 'line'                          //指定图表的类型，默认是折线图（line）
                },
                title: {
                    text: '考试平均分走向'                 // 标题
                },
                xAxis: {
                    categories: categories   // x 轴分类
                },
                yAxis: {
                    title: {
                        text: '分数'                // y 轴标题
                    }
                },
                series: [{                              // 数据列
                    name: '考试成绩',// 数据列名
                    data: data2                    // 数据
                }]
            };
            var chart = Highcharts.chart('container', options);
            selectCount();
            selectCore();
        },
        error: function () {
            alert("error");
        }
    });

}

//扇形
function selectCount() {
    var s1 = "[";
    for (i = 0; i < categories.length; i++) {
        var precent = personCount[i]/allCount*100+"";
        var inf = "{"+
            "name: '"+categories[i]+"',"+
            "y:"+precent.substring(0,4)+
        "},";
        s1 = s1+inf;
    }
    s1 = s1.substring(0,s1.length-1);
    s1 = s1+"]";
    var json = eval(s1);
    Highcharts.chart('container2', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '每次考试参考人数占比'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            name: '人数占比',
            colorByPoint: true,
            data:json
        }]
    });
}

//成绩
function selectCore() {
    var s1 = "[";
    for (i = 0; i < categories.length; i++) {
        var precent = personCount[i]/allCount*100+"";
        var inf = "{"+
            "name: '"+categories[i]+"',"+
            "data:["+max[i]+","+data2[i]+","+min[i]+"]"+
            "},";
        s1 = s1+inf;
    }
    s1 = s1.substring(0,s1.length-1);
    s1 = s1+"]";
    var json = eval(s1);

    /*[{
        name: '东京',
        data: [49.9, 71.5, 106.4]
    }, {
        name: '纽约',
        data: [83.6, 78.8, 98.3]
    }, {
        name: '伦敦',
        data: [48.9, 38.8, 39.3]
    }]*/






    var chart = Highcharts.chart('container3',{
        chart: {
            type: 'column'
        },
        title: {
            text: '考试成绩分布'
        },
        xAxis: {
            categories: [
                '最高分','平均分','最低分'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: '分数 (分)'
            }
        },
        tooltip: {
            // head + 每个 point + footer 拼接成完整的 table
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 分</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                borderWidth: 0
            }
        },
        series: json
    });
}