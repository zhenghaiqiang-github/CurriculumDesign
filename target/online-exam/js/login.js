//学生登录界面

//加载页面
$(document).ready(function (){

});

//登录按钮

function login() {
    var account = $("#account").val();
    var password = $("#password").val();

    var status = $("input[name='remenber']:checked").val();//身份
    if(account=="") {
         $.messager.alert('温馨提示','请输入账号');

        return false;
    }else if(password=="") {
        $.messager.alert('温馨提示','请输入密码');
        return false;
    }else if(status==""||status==null) {
        $.messager.alert('温馨提示','请选择身份');
        return false;
    }
    var data = {    "account":account,
        "password":password,
        "status":status,
    };
    $.ajax({
        url: "login.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var json = eval(data);//json为接收的后台返回的数据；
            if(json.msg=="null"||json.msg=="no") {
                $.messager.alert('温馨提示','输入正确的账号密码');
            } else if (json.msg=="studentYes") {
                window.location.href="../html/student.html";
            } else if (json.msg=="teacherYes") {
                window.location.href="../html/teacher.html";
            }
        },
        error: function () {
            $.messager.alert("服务器异常,请联系郑海强");
        }
    });
}

function clearText() {
    $("#account").textbox('setValue',"");
    $("#password").textbox('setValue',"");
}