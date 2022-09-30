//教师界面

//加载页面
$(document).ready(function (){
    GetTeacherName();//拦截教师未登录*/
});

//检测是否登录
function GetTeacherName() {
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
                $("#teacherName").text('欢迎您,' + json.name+'老师');
            }
        },
        error: function () {
            alert("error");
        }
    });
}

//跳转试题界面
function gotoTeacherQuestion() {
    $('#zhuti').attr('src', '../html/teacherQuestion.html');
}

//跳转试卷界面
function gotoTeacherExam() {
    $('#zhuti').attr('src', '../html/teacherExam.html');
}

//
function gotoTeacherExamInfor() {
    $('#zhuti').attr('src', '../html/teacherExamInformation.html');
}

function gotoStudentInfor() {
    $('#zhuti').attr('src', '../html/studentInformation.html');
}

function gotoScoreAnalysis() {
    $('#zhuti').attr('src', '../html/scoreAnalysis.html');
}

function gotoExamRank() {
    $('#zhuti').attr('src', '../html/examRank.html');
}

function gotoExamExport() {
    $('#zhuti').attr('src', '../html/examExport.html');
}

function gotofailQuestion() {
    $('#zhuti').attr('src', '../html/failQuestion.html');
}