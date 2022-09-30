//加载页面
$(document).ready(function (){

});

function seekAll() {
    $("#mytab").text("");
    var examName = $("#examName").val();
    var examSubject = $("#examSubject").val();
    var examCode = $("#examCode").val();
    var studentAccount = $("#studentAccount").val();
    var studentName = $("#studentName").val();

    var data = {    "examName":examName,
                    "examSubject":examSubject,
                    "examCode":examCode,
                    "studentAccount":studentAccount,
                    "studentName":studentName
                };

    $.ajax({
        url: "selectExamRes.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab").append(
                    "<tr>" +
                    "<td>"+dataObj[i].id+"</td>" +
                    "<td>"+dataObj[i].studentaccount+"</td>" +
                    "<td>"+dataObj[i].studentName+"</td>" +
                    "<td>"+dataObj[i].examName+"</td>" +
                    "<td>"+dataObj[i].subject+"</td>" +
                    "<td>"+dataObj[i].examCode+"</td>" +
                    "<td>"+dataObj[i].score+"</td>" +
                    "</tr>"
                );
            }
        },
        error: function () {
            alert("error");
        }
    });
}

