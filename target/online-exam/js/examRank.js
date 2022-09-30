//成绩界面

//加载页面
$(document).ready(function (){
    selectExamInfor();
    $("#p3").css('display','none');//隐藏
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
                    "<td>"+"<button class=\"layui-btn\" onclick=\"selectRank("+dataObj[i].examCode+")\">确定</button>" +
                    "</tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function selectRank(src) {
    $("#p2").css('display','none');//隐藏
    var data = {"examCode":src};
    $("#mytab").text("");
    $.ajax({
        url: "selectRankInfor.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab");
            for (i = 0; i < dataObj.length; i++) {
                var y =i+1;
                $("#mytab").append(
                    "<tr>" +
                    "<td>"+y+"</td>" +
                    "<td>"+dataObj[i].studentaccount+"</td>" +
                    "<td>"+dataObj[i].studentName+"</td>" +
                    "<td>"+dataObj[i].score+"</td>" +
                    "</tr>");
            }
            $("#p3").css('display','block');
        },
        error: function () {
            alert("error");
        }
    });
}
