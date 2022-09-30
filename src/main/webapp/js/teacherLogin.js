//学生登录界面

//加载页面
$(document).ready(function (){
    //checkLogin();
});

//登录按钮
function login() {
    var status = $("input[name='remenber']:checked").val();//是否记住密码
    var account = $("#account").val();
    var password = $("#password").val();
    if(account=="") {
        $.messager.alert('温馨提示','请输入账号');
        return false;
    }else if(password=="") {
        $.messager.alert('温馨提示','请输入密码');
        return false;
    }
    $.ajax({
        url: "teacherLogin.action",
        type: "post",
        data: {"account": account,"password":password},
        dataType: "json",
        success: function (data) {
            var json = eval(data);//json为接收的后台返回的数据；
            if(json.msg=="null"||json.msg=="no") {
                $.messager.alert('温馨提示','输入正确的账号密码');
            } else if (json.msg=="yes") {
                window.location.href="../html/teacher.html";
            }
        },
        error: function () {
            alert("error");
        }
    });
}