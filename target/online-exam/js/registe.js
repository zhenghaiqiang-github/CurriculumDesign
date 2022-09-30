//注册界面
function registe() {

    var name = $("#name").val();
    var account = $("#account").val();
    var password = $("#password").val();
    var repassword = $("#repassword").val();
    var question = $("#question").val();
    var answer = $("#answer").val();
    var status = $("input[name='remenber']:checked").val();//身份

    if(status==""||status==null) {
        $.messager.alert('温馨提示','请选择身份');
        return false;
    }
    if(name == "") {
        $.messager.alert('温馨提示','请输入姓名');
        return false;
    }
    if (account == "" || !(/\d{10}$/.test(account))) {
        $.messager.alert('温馨提示','请输入10位数字账号');
        return false;
    }
    if(password == "" || repassword=="") {
        $.messager.alert('温馨提示','请输入密码');
        return false;
    }
    if (password != repassword) {
        $.messager.alert('温馨提示','两次密码输入不一致');
        return false;
    }
    if(question == "" || answer=="") {
        $.messager.alert('温馨提示','请输入密保问题或答案');
        return false;
    }



    var data = {    "name":name,
                    "account":account,
                    "password":password,
                    "question":question,
                    "answer":answer,
                    "status":status
                };

    $.ajax({
        url: "registe.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var json = eval(data);//json为接收的后台返回的数据；
            if(json.msg=="no") {
                $.messager.alert('温馨提示','该账号已被注册，请换一个账号');
                $("#account").textbox('setValue');
            } else if (json.msg=="yes") {
                $.messager.alert('温馨提示','注册成功');
                window.location.href="../../../html/login.html";
            }
        },
        error: function () {
            alert("error");
        }
    });
}