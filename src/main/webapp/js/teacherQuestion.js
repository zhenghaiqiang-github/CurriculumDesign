//试题界面

//加载页面
$(document).ready(function (){
    $("#p9").css('display','none');//隐藏
    $("#p10").css('display','none');//隐藏
    seekAll();
});

function seekQuestion() {
    $("#mytab").text("");
    var selectQuestion = $("#selectQuestion").val();
    var selectSubject = $("#selectSubject").val();
    var data = {    "selectQuestion":selectQuestion,
                    "selectSubject":selectSubject,
                };
    if((selectQuestion == null||selectQuestion == "")&&(selectSubject == null||selectSubject == "")){
        seekAll();
    }else {
        $.ajax({
            url: "seekQuestion.action",
            type: "post",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType: "json",
            success: function (data) {
                var dataObj = eval(data);//json为接收的后台返回的数据；
                var $tab1 = $("#mytab");
                for (i = 0; i < dataObj.length; i++) {
                    $("#mytab").append("<tr><td>"+dataObj[i].id+"</td>" +
                        "<td>"+dataObj[i].question+"</td>" +
                        "<td>"+dataObj[i].answer+"</td>" +
                        "<td>"+dataObj[i].optionA+"</td>" +
                        "<td>"+dataObj[i].optionB+"</td>" +
                        "<td>"+dataObj[i].optionC+"</td>" +
                        "<td>"+dataObj[i].optionD+"</td>" +
                        "<td>"+dataObj[i].subject+"</td>" +
                        "<td>"+dataObj[i].book+"</td>" +
                        "<td>"+dataObj[i].chapter+"</td>" +
                        "<td>"
                        +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"layui-btn\" " +
                        "onclick=\"UpdateQuestion(" +dataObj[i].id+")\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "<button class=\"layui-btn layui-btn-warm\" " +
                        "onclick=\"deleQuestion(" +dataObj[i].id+")\">删除</button>"+"" +
                        "</td></tr>");
                }
            },
            error: function () {
                alert("error");
            }
        });
    }
}


//查询所有试题
function seekAll() {
    $("#mytab").text("");
    $.ajax({
        url: "seekAll.action",
        type: "post",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab");
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab").append("<tr><td>"+dataObj[i].id+"</td>" +
                                   "<td>"+dataObj[i].question+"</td>" +
                                "<td>"+dataObj[i].answer+"</td>" +
                                "<td>"+dataObj[i].optionA+"</td>" +
                                "<td>"+dataObj[i].optionB+"</td>" +
                                "<td>"+dataObj[i].optionC+"</td>" +
                                "<td>"+dataObj[i].optionD+"</td>" +
                                "<td>"+dataObj[i].subject+"</td>" +
                                "<td>"+dataObj[i].book+"</td>" +
                                "<td>"+dataObj[i].chapter+"</td>" +
                                "<td>"
                                +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"layui-btn\" " +
                                 "onclick=\"UpdateQuestion(" +dataObj[i].id+")\">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                                "<button class=\"layui-btn layui-btn-warm\" " +
                                "onclick=\"deleQuestion(" +dataObj[i].id+")\">删除</button>"+"" +
                    "           </td></tr>");
            }
        },
        error: function () {
            alert("error");
        }
    });
}

//添加试题界面显示
function addQuestion() {
    $("#p9").css('display','block');
}

//关闭试题界面显示
function closeQuestion() {
    $("#p9").css('display','none');
    $("#p10").css('display','none');
}

//添加具体的试题
function addQuestionTitle() {
    var question = $("#question").val();
    var answer = $("input[name='answer']:checked").val();
    var optionA = $("#optionA").val();
    var optionB = $("#optionB").val();
    var optionC = $("#optionC").val();
    var optionD = $("#optionD").val();
    var subject = $("#subject").val();
    var difficulty = $("#difficulty").val();
    var book = $("#book").val();
    var chapter = $("#chapter").val();



    if(question==""||question==null) {
        $.messager.alert('温馨提示','请输入题目');
        return false;
    }
    if(answer == "") {
        $.messager.alert('温馨提示','请选择答案');
        return false;
    }
    if(optionA==""||optionA==null) {
        $.messager.alert('温馨提示','请输入选项');
        return false;
    }
    if(optionB==""||optionB==null) {
        $.messager.alert('温馨提示','请输入选项');
        return false;
    }
    if(optionC==""||optionC==null) {
        $.messager.alert('温馨提示','请输入选项');
        return false;
    }
    if(optionD==""||optionD==null) {
        $.messager.alert('温馨提示','请输入选项');
        return false;
    }


    var data = {    "question":question,
                    "answer":answer,
                    "optionA":optionA,
                    "optionB":optionB,
                    "optionC":optionC,
                    "optionD":optionD,
                    "subject":subject,
                    "difficulty":difficulty,
                    "book":book,
                    "chapter":chapter
                 };

    $.ajax({
        url: "addQuestion.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $("#p9").css('display','none');//显示
            $.messager.alert('温馨提示','添加成功');
            seekAll();
        },
        error: function () {
            alert("error");
        }
    });
}

//修改题目
function UpdateQuestion(id) {
    var data = {"id":id};
    $.ajax({
        url: "seekQuestionById.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var answer = dataObj[0].answer;
            if (answer == "A") {
                $("input[name='updateAnswer'][value=A]").attr("checked",true);
            }
            if (answer == "B") {
                $("input[name='updateAnswer'][value=B]").attr("checked",true);
            }
            if (answer == "C") {
                $("input[name='updateAnswer'][value=C]").attr("checked",true);
            }
            if (answer == "D") {
                $("input[name='updateAnswer'][value=D]").attr("checked",true);
            }
            $("#updateId").val(dataObj[0].id);
            $("#updateQuestion").textbox('setValue',dataObj[0].question);
            $("#updateOptionA").textbox('setValue',dataObj[0].optionA);
            $("#updateOptionB").textbox('setValue',dataObj[0].optionB);
            $("#updateOptionC").textbox('setValue',dataObj[0].optionC);
            $("#updateOptionD").textbox('setValue',dataObj[0].optionD);
            $("#updateSubject").textbox('setValue',dataObj[0].subject);
            $("#updateBook").textbox('setValue',dataObj[0].book);
            $("#updateChapter").textbox('setValue',dataObj[0].chapter);
            $("#p10").css('display','block');//显示
        },
        error: function () {
            alert("error");
        }
    });
}

//修改按钮
function sureQuestion() {
    var id = $("#updateId").val();
    var question = $("#updateQuestion").val();
    var answer = $("input[name='updateAnswer']:checked").val();
    var optionA = $("#updateOptionA").val();
    var optionB = $("#updateOptionB").val();
    var optionC = $("#updateOptionC").val();
    var optionD = $("#updateOptionD").val();
    var subject = $("#updateSubject").val();
    var book = $("#updateBook").val();
    var chapter = $("#updateChapter").val();

    var data = {    "id":id,
                    "question":question,
                    "answer":answer,
                    "optionA":optionA,
                    "optionB":optionB,
                    "optionC":optionC,
                    "optionD":optionD,
                    "subject":subject,
                    "book":book,
                    "chapter":chapter
                };

    $.ajax({
        url: "updateQuestion.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $("#p10").css('display','none');//显示
            $.messager.alert('温馨提示','修改成功');
            seekAll();
        },
        error: function () {
            alert("error");
        }
    });

}

//删除
function deleQuestion(id) {
    $.messager.confirm('温馨提示','确定要删除该试题吗?',function(r){
        if (r){
            var data = {"id":id};
            $.ajax({
                url: "deleQuestion.action",
                type: "post",
                data: JSON.stringify(data),
                contentType:"application/json",
                dataType: "json",
                success: function (data) {
                    var dataObj = eval(data);//json为接收的后台返回的数据；
                    $.messager.alert('温馨提示','删除成功');
                    seekAll();
                },
                error: function () {
                    alert("error");
                }
            });
        }
    });
}