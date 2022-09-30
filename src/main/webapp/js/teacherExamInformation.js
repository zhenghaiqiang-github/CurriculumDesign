//试题界面

//加载页面
$(document).ready(function (){
    selectExamInformation();
    $("#p9").css('display','none');//隐藏
    $("#p10").css('display','none');//隐藏
    $("#p11").css('display','none');//隐藏
});

function createExam() {
    $("#p9").css('display','block');
}

function closeExam() {
    $("#p9").css('display','none');
    $("#p11").css('display','none');//隐藏
}

function addExam() {
    $("#mytab").text("");
    var data = {    "selectExam":null
    };
    $.ajax({
        url: "selectExam.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab");
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab").append(
                    "<tr>" +
                    "<td><input type=\"radio\" name=\"id\" value="+dataObj[i].id+","+dataObj[i].name+","+dataObj[i].totalScore+" /></td>" +
                    "<td>"+dataObj[i].id+"</td>" +
                    "<td>"+dataObj[i].name+"</td>" +
                    "<td>"+dataObj[i].totalScore+"</td>" +
                    "<td>"+dataObj[i].subject+"</td>" +
                    "</tr>"
                );
            }
        },
        error: function () {
            alert("error");
        }
    });
    $("#p10").css('display','block');
}

function closeQuestion() {
    $("#p10").css('display','none');
}

function addQuestion() {
    var s = $('input[name="id"]:checked').val();
    $.messager.confirm('温馨提示','确定把试卷添加到考试中?',function(r){
        if (r){
            var arr=s.split(",");
            var examId = arr[0]+"."+arr[1];
            $("#examId").textbox('setValue',examId)//赋值*/
            $("#score").textbox('setValue',100)//赋值*/
            var myDate = new Date();
            var mytime=myDate.toLocaleDateString();
            //examCode
            var time = getNowFormatDate();
            time=time.replace(" ","");
            time=time.replace("-","");
            time=time.replace("-","");
            time=time.replace(":","");
            time=time.replace(":","");
            var examCode = time+arr[0];
            $("#examCode").textbox('setValue',examCode);
            $("#p10").css('display','none');
        }
    });
}

function getNowFormatDate() {//获取当前时间
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1<10? "0"+(date.getMonth() + 1):date.getMonth() + 1;
    var strDate = date.getDate()<10? "0" + date.getDate():date.getDate();
    var currentdate = date.getFullYear() + seperator1  + month  + seperator1  + strDate
        + " "  + date.getHours()  + seperator2  + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

function sureExam() {
    var examName = $("#examName").val();
    var subject = $("#subject").val();
    var score = $("#score").val();
    var examId = $("#examId").val();
    var examCode = $("#examCode").val();
    var examDate = $("#examDate").val();


    if(examName==""||examName==null) {
        $.messager.alert('温馨提示','请输入考试名称');
        return false;
    }
    if(examDate==""||examDate==null) {
        $.messager.alert('温馨提示','请输入考试时间');
        return false;
    }
    if(examId==""||examId==null) {
        $.messager.alert('温馨提示','请选择试卷');
        return false;
    }


    var data = {    "name":examName,
                    "score":score,
                    "subject":subject,
                    "examId":examId,
                    "examCode":examCode,
                    "examDate":examDate
                };

    $.ajax({
        url: "addExamInformation.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $.messager.alert('温馨提示','添加成功');
            selectExamInformation();
            $("#p9").css('display','none');//隐藏
        },
        error: function () {
            alert("error");
        }
    });
}

function selectExamInformation() {
    $("#mytab1").text("");
    var selectExamInformation = $("#selectExamInformation").val();
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
                    "<td>"+dataObj[i].createDate+"</td>" +
                    "<td>"+dataObj[i].subject+"</td>" +
                    "<td>"+dataObj[i].exam+"</td>" +
                    "<td>"+dataObj[i].totalScore+"</td>" +
                    "<td>"+dataObj[i].examDate+"分钟"+"</td>" +
                    "<td>"+dataObj[i].examCode+"</td>" +
                    "<td>"+dataObj[i].person+"</td>" +
                    "<td>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"layui-btn\" onclick=\"updateInfor(" +dataObj[i].id+")\")\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<button class=\"layui-btn layui-btn-warm\" onclick=\"deleInfo(" +dataObj[i].id+")\")\">删除</button>"+"</td></tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function updateInfor(id) {
    var data = {"id":id};
    $.ajax({
        url: "seekInforById.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；

            $("#updateId").val(dataObj[0].id);
            $("#examName1").textbox('setValue',dataObj[0].name);
            $("#subject1").textbox('setValue',dataObj[0].subject);
            $("#examDate1").textbox('setValue',dataObj[0].examDate);
            $("#score1").textbox('setValue',dataObj[0].totalScore);
            $("#examId1").textbox('setValue',dataObj[0].exam);
            $("#examCode1").textbox('setValue',dataObj[0].examCode);
            $("#p11").css('display','block');//显示
        },
        error: function () {
            alert("error");
        }
    });
}

function sureUpdateExam() {
    var id = $("#updateId").val();
    var examName = $("#examName1").val();
    var subject = $("#subject1").val();
    var examDate = $("#examDate1").val();

    var data = {
                    "id":id,
                    "name":examName,
                    "subject":subject,
                    "examDate":examDate
                };

    $.ajax({
        url: "sureUpdateExam.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $.messager.alert('温馨提示','修改成功');
            selectExamInformation();
            $("#p11").css('display','none');//隐藏
        },
        error: function () {
            alert("error");
        }
    });
}

function deleInfo(id) {
    $.messager.confirm('温馨提示','确定要删除该场考试吗?',function(r){
        if (r){
            var data = {"id":id};
            $.ajax({
                url: "deleInfo.action",
                type: "post",
                data: JSON.stringify(data),
                contentType:"application/json",
                dataType: "json",
                success: function (data) {
                    var dataObj = eval(data);//json为接收的后台返回的数据；
                    $.messager.alert('温馨提示','删除成功');
                    selectExamInformation();
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });
    
}