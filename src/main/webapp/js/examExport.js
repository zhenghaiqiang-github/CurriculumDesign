//成绩界面

//加载页面
$(document).ready(function (){
    selectExamInfor();
});

function selectExamInfor() {
    $("#mytab1").text("");
    var selectExamInformation = "";
    var data = {    "selectExamInformation":selectExamInformation
    };
    $.ajax({
        url: "selectExamInformation.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab1");
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab1").append(
                    "<tr>" +
                    "<td>"+dataObj[i].id+"</td>" +
                    "<td>"+dataObj[i].name+"</td>" +
                    "<td>"+dataObj[i].examCode+"</td>" +
                    "<td>"+"<button class=\"layui-btn\" onclick=\"selectRank("+dataObj[i].examCode+")\">导出</button>" +
                    "</tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function selectRank(src) {
    var data = {"examCode":src};
    $.ajax({
        url: "rankExport.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var jsonData = eval(data);//json为接收的后台返回的数据；
            //列标题，逗号隔开，每一个逗号就是隔开一个单元格
            var str = "考试排名,考生账号,考试姓名,分数\n";
            //增加\t为了不让表格显示科学计数法或者其他格式
            for(var i = 0 ; i < jsonData.length ; i++ ){
                y = i+1;
                str+=y+","+jsonData[i].studentaccount+","+jsonData[i].studentName+","+jsonData[i].score+","+"\t";
                str+='\n';
            }
            //encodeURIComponent解决中文乱码
            var uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
            //通过创建a标签实现
            var link = document.createElement("a");
            link.href = uri;
            //对下载的文件命名
            link.download =  "成绩排名.csv";
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
            $.messager.alert('温馨提示','导出成功');
        },
        error: function () {
            alert("error");
        }
    });
}
