//教师界面

//加载页面
$(document).ready(function (){
    $("#p5").css('display','none');//隐藏
    $("#p6").css('display','none');//隐藏
    $("#p7").css('display','none');//隐藏
    GetStudentName();//拦截未登录*/
});

//检测是否登录
function GetStudentName() {
    $.ajax({
        url: "teacherName.action",
        type: "post",
        dataType: "json",
        success: function (data) {
            var json = eval(data);//json为接收的后台返回的数据；
            if(json.name =="no") {
                $.messager.alert('温馨提示','您还未登录!','info',function () {
                    window.location.href="../html/login.html";
                });
            } else {
                $("#teacherName").text('欢迎您,' + json.name+'同学');
            }
        },
        error: function () {
            alert("error");
        }
    });
}

function gotoIndex() {
    window.location.href="../html/login.html";
}

function selectExamCode() {
    var ExamCode = $("#ExamCode").val();
    if(ExamCode==""||ExamCode==null) {
        $.messager.alert('温馨提示','请输入正确的考试码！');
        return false;
    }

    data = {    "ExamCode":ExamCode};

    $.ajax({
        url: "selectExamCode.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            var dataObj = eval(data);//json为接收的后台返回的数据；
            if (dataObj.msg=="no") {
                $.messager.alert('温馨提示','考试还未开始或不存在');
            } else if(dataObj.msg=="already") {
                $.messager.alert('温馨提示','您已参加过考试了');
            } else {
                var name = $("#teacherName").text().substring(4,$("#teacherName").text().length);
                id = dataObj[0].id;
                person = dataObj[0].person;
                score = dataObj[0].totalScore;
                var examDate = dataObj[0].examDate;
                subject = dataObj[0].subject;
                examName = dataObj[0].name;
                c = examDate*60;
                $.messager.confirm('温馨提示','确定开始考试?考试时长:'+examDate+'分钟,考试科目:'+subject,function(r){
                    if (r){
                        timedMsg();
                        $("#p5").css('display','block');
                        demo();
                    }
                });

                }
        },
        error: function () {
            alert("error");
        }
    });

}

function demo() {
    $.ajax({
        url: "selectExamCode2.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            count = 0;
            var dataObj = eval(data);//json为接收的后台返回的数据；
            var $tab1 = $("#mytab");
            for (i = 0; i < dataObj.length; i++) {
                $("#mytab").append(
                    "<tr><td><font size=\"3\" id=\"studentName\">"+dataObj[i].id+"."+dataObj[i].question+"</font></td></tr>"
                    +"<tr><td><input type=\"radio\" name="+dataObj[i].id+dataObj[i].answer+" value="+"A"+dataObj[i].answer+dataObj[i].id+">A:"+dataObj[i].optionA+"</td></tr>"
                    +"<tr><td><input type=\"radio\" name="+dataObj[i].id+dataObj[i].answer+" value="+"B"+dataObj[i].answer+dataObj[i].id+">B:"+dataObj[i].optionB+"</td></tr>"
                    +"<tr><td><input type=\"radio\" name="+dataObj[i].id+dataObj[i].answer+" value="+"C"+dataObj[i].answer+dataObj[i].id+">C:"+dataObj[i].optionC+"</td></tr>"
                    +"<tr><td><input type=\"radio\" name="+dataObj[i].id+dataObj[i].answer+" value="+"D"+dataObj[i].answer+dataObj[i].id+">D:"+dataObj[i].optionD+"</td></tr>"
                    +"<tr><td>-------------------------------------------" +
                    "-------------------------------------------" +
                    "-------------------------</td></tr>"
                );
                count++;
            }
            $("#p6").css('display','block');
            $("#p7").css('display','block');
        },
        error: function () {
            alert("error");
        }
    });
}

function timedMsg()
{
    $("#infomation").text("");
    minutes = Math.floor(c / 60);
    seconds = Math.floor(c % 60);
    msg = "距离结束还有" + minutes + "分" + seconds + "秒";
    $("#infomation").append(
        "<td><font size=\"3\" id=\"studentName\">科目:"+subject+"</font></td>"
        +"<td><font size=\"3\" id=\"studentName\">"+msg+"</font></td>"
    );
    if(c==0){
        clearTimeout(t);
        //强制交卷
    }else{
        t=setTimeout('timedMsg()',1000);
    }
    c--;
}

function submitExam() {
    var i = 0;
    var trueSelect = 0;
    var fail = "";
    $("#mytab :checked").each(function () {
        var select = $(this).val().substring(0,1);
        var answer = $(this).val().substring(1,2);
        var id = $(this).val().substring(2,$(this).val().length);
        if(select != "0") {
            if(select==answer) {
                trueSelect = trueSelect+1;
            } else {
                fail=fail+","+id;
            }
        }
    });
    var getScore = score*trueSelect/count;
    var failSelect = fail.substring(1,fail.length);
    var ExamCode = $("#ExamCode").val();
    var data = {    "examinforid":id,
                    "person":person,
                    "totalscore":score,
                    "score":getScore,
                    "failquestion":failSelect,
                    "examCode":ExamCode,
                    "subject":subject,
                    "examName":examName
                };
    $.ajax({
        url: "examResult.action",
        type: "post",
        data: JSON.stringify(data),
        contentType:"application/json",
        dataType: "json",
        success: function (data) {
            $("#mytab").text("");
            $("#ExamCode").textbox('setValue',"");
            $("#p5").css('display','none');//隐藏
            $("#p6").css('display','none');//隐藏
            $("#p7").css('display','none');//隐藏
            // $.messager.alert('考试已结束');
            $.messager.alert('温馨提示','考试结束.您的分数为'+getScore+'');
        },
        error: function () {
            alert("error");
        }
    });

}
