package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.pojo.Question;
import zheng.hai.qiang.service.StudentExamService;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class StudentExam {
    @Autowired
    public StudentExamService ses;

    @ResponseBody
    @RequestMapping(value = "/html/selectExamCode.action",produces = "application/json; charset=utf-8")
    public String addQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        ArrayList<String> rtnList = new ArrayList<>();
        Map rtnMap = new HashMap();
        String ExamCode = map.get("ExamCode");
        String person = CookieUtil.getCookie(request,"name");
        String studentaccount = CookieUtil.getCookie(request,"account");
        List<ExamResult> examResult = new ArrayList<>();
        List<ExamInformation> list = new ArrayList<>();
        List<Question> listQuestion = new ArrayList<>();
        list = ses.findExam((HashMap) map);
        examResult = ses.findExamResult(studentaccount,ExamCode);
        if(list.size() == 0) {
            rtnMap.put("msg","no");
            return new Gson().toJson(rtnMap);
        } else if(examResult.size() != 0) {
            rtnMap.put("msg","already");
            return new Gson().toJson(rtnMap);
        }  else {
            String questopnId = ses.findQuestionId(list.get(0).getExam());
            String [] id = questopnId.split(",");
            listQuestion = ses.findQuestion(id);
            String examInformation = new Gson().toJson(list);
            String question = new Gson().toJson(listQuestion);
            System.out.println(examInformation);
            System.out.println(listQuestion);
            return new Gson().toJson(list);
        }
    }
//这里导出Word
    @ResponseBody
    @RequestMapping(value = "/html/selectExamCode2.action",produces = "application/json; charset=utf-8")
    public String addQuestion1(@RequestBody Map<String,String> map, HttpServletRequest request) {
        ArrayList<String> rtnList = new ArrayList<>();
        Map rtnMap = new HashMap();
        String ExamCode = map.get("ExamCode");
        String person = CookieUtil.getCookie(request,"name");
        List<ExamInformation> list = new ArrayList<>();
        List<Question> listQuestion = new ArrayList<>();
        list = ses.findExam((HashMap) map);
        if(list.size() == 0) {
            rtnMap.put("msg","no");
            return new Gson().toJson(rtnMap);
        } else {
            String questopnId = ses.findQuestionId(list.get(0).getExam());
            String [] id = questopnId.split(",");
            listQuestion = ses.findQuestion(id);
            String examInformation = new Gson().toJson(list);
            String question = new Gson().toJson(listQuestion);
            System.out.println(examInformation);
            System.out.println(listQuestion);
            return new Gson().toJson(listQuestion);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/html/examResult.action",produces = "application/json; charset=utf-8")
    public String examResult(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String studentaccount = CookieUtil.getCookie(request,"account");
        String studentName = CookieUtil.getCookie(request,"name");
        String examinforid = map.get("examinforid");
        String person = map.get("person");
        String totalscore = map.get("totalscore");
        String score = map.get("score");
        String failquestion = map.get("failquestion");
        String examCode = map.get("examCode");
        String subject = map.get("subject");
        String examName = map.get("examName");
        ExamResult er = new ExamResult(studentaccount,studentName,examinforid,person,totalscore,score,failquestion,examCode,subject,examName);
        ses.addExamResult(er);
        System.out.println("666");
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }
}
