//试卷界面

//加载页面
$(document).ready(function (){
    selectExam();
    $("#p9").css('display','none');//隐藏
    $("#p10").css('display','none');//隐藏
    $("#p11").css('display','none');//隐藏
});

function createExam() {
    $("#allQuestion").textbox('setValue',"");
    $("#examName").textbox('setValue',"");
    $("#subject").textbox('setValue',"");
    $("#book").textbox('setValue',"");
    $("#chapter").textbox('setValue',"");
    $("#singleScore").textbox('setValue',"");
    $("#p9").css('display','block');
}

function addQuestion() {
    $("#mytab").text("");
    $.ajax({
        url: "seekAll.action",
        type: "post",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab");
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab").append(
                    "<tr>" +
                    "<td><input type=\"checkbox\" name=\"id\" value="+dataObj[i].id+" /></td><td>"+dataObj[i].id+"</td>" +
                    "<td>"+dataObj[i].question+"</td>" +
                    "<td>"+dataObj[i].subject+"</td>" +
                    "<td>"+dataObj[i].book+"</td>" +
                    "<td>"+dataObj[i].chapter+"</td>" +
                    "<td>"+dataObj[i].difficulty+"</td></tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
    $("#p10").css('display','block');
    $("#p11").css('display','none');
}

function closeQuestion() {
    $("#p10").css('display','none');
}

function closeExam() {
    $("#p9").css('display','none');
    $("#p11").css('display','none');
}

function addQuestion2() {
    var s='';
    $('input[name="id"]:checked').each(function(){
        s+=$(this).val()+',';
    });
    $.messager.confirm('温馨提示','确定把试题添加到试卷中?',function(r){
        if (r){
            s = s.substring(0, s.length - 1);
            $("#allQuestion").textbox('setValue',s)//赋值
            $("#p10").css('display','none');
        }
    });
}

function sureQuestion() {
    var examName = $("#examName").val();
    var subject = $("#subject").val();
    var book = $("#book").val();
    var chapter = $("#chapter").val();
    var singleScore = $("#singleScore").val();
    var allQuestion = $("#allQuestion").val();


    if(examName==""||examName==null) {
        $.messager.alert('温馨提示','请输入试卷名称');
        return false;
    }
    if(allQuestion==""||allQuestion==null) {
        $.messager.alert('温馨提示','请选择试题');
        return false;
    }

    var data = {    "name":examName,
                    "singleScore":singleScore,
                    "subject":subject,
                    "book":book,
                    "chapter":chapter,
                    "question":allQuestion,
                };

    $.ajax({
        url: "addExam.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $.messager.alert('温馨提示','添加成功');
            $("#p9").css('display','none');//隐藏
            selectExam();
        },
        error: function () {
            alert("error");
        }
    });
}

function selectExam() {
    $("#mytab1").text("");
    var selectExam = $("#selectExam").val();
    var data = {    "selectExam":selectExam
                };
    $.ajax({
        url: "selectExam.action",
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
                    "<td>"+dataObj[i].totalScore+"</td>" +
                    "<td>"+dataObj[i].person+"</td>" +
                    "<td>"+dataObj[i].subject+"</td>" +
                    "<td>"+dataObj[i].book+"</td>" +
                    "<td>"+dataObj[i].chapter+"</td>" +
                    "<td>"+dataObj[i].question+"</td>" +
                    "<td>"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"layui-btn\" onclick=\"updateExam(" +dataObj[i].id+")\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<button class=\"layui-btn layui-btn-warm\" onclick=\"deleExam(" +dataObj[i].id+")\">删除</button>"+"</td></tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function updateExam(id) {
    var data = {"id":id};
    $.ajax({
        url: "seekExamById.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；

            $("#updateId").val(dataObj[0].id);
            $("#examName1").textbox('setValue',dataObj[0].name);
            $("#subject1").textbox('setValue',dataObj[0].subject);
            $("#book1").textbox('setValue',dataObj[0].book);
            $("#chapter1").textbox('setValue',dataObj[0].chapter);
            $("#allQuestion1").textbox('setValue',dataObj[0].question);
            $("#p11").css('display','block');//显示
        },
        error: function () {
            alert("error");
        }
    });
}

//删除
function deleExam(id) {
    $.messager.confirm('温馨提示','确定要删除该试卷吗?',function(r){
        if (r){
            var data = {"id":id};
            $.ajax({
                url: "deleExam.action",
                type: "post",
                data: JSON.stringify(data),
                contentType:"application/json",
                dataType: "json",
                success: function (data) {
                    var dataObj = eval(data);//json为接收的后台返回的数据；
                    $.messager.alert('温馨提示','删除成功');
                    selectExam();
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });
}

function sureExam() {
    var id = $("#updateId").val();
    var examName = $("#examName1").val();
    var subject = $("#subject1").val();
    var book = $("#book1").val();
    var chapter = $("#chapter1").val();
    var data = {
                    "id":id,
                    "name":examName,
                    "subject":subject,
                    "book":book,
                    "chapter":chapter
                };

    $.ajax({
        url: "sureExam.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $.messager.alert('温馨提示','修改成功');
            selectExam();
            $("#p11").css('display','none');//隐藏
        },
        error: function () {
            alert("error");
        }
    });

}
