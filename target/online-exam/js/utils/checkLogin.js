//检测是否登录
function checkLogin() {
    $.ajax({
        url: "check.action",
        type: "post",
        dataType: "json",
        success: function (data) {
            var json = eval(data);//json为接收的后台返回的数据；
            if(json.msg=="no") {
                $.messager.alert('Warning','未登录');
            }
            if(json.msg == "login") {
                $.messager.alert('Warning','登录了');
            }
            /*window.location.href="../html/student.html";*/
        },
        error: function () {
            alert("error");
        }
    });
}