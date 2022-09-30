package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.pojo.Question;
import zheng.hai.qiang.service.TeacherExamInformationService;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TeacherExamInformation {
    @Autowired
    public TeacherExamInformationService tei;

    @ResponseBody
    @RequestMapping(value = "/html/selectexamInformationfocounts.action",produces = "application/json; charset=utf-8")
    public Integer selectexamInformationfocounts(){
        int examinformation = tei.selectexamInformationfocounts();
        return examinformation;
    }


    @ResponseBody
    @RequestMapping(value = "/html/addExamInformation.action",produces = "application/json; charset=utf-8")
    public String addQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String name = map.get("name");
        String subject = map.get("subject");
        String score = map.get("score");
        String examId = map.get("examId");
        String examCode = map.get("examCode");//examDate
        String examDate = map.get("examDate");
        String person = CookieUtil.getCookie(request,"name");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String createDate = df.format(new Date());
        String exam = examId.substring(0,examId.indexOf("."));
        ExamInformation ei = new ExamInformation(name,createDate,exam,score,examCode,person,subject,examDate);
        tei.addExamInformation(ei);
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/selectExamInformation.action",produces = "application/json; charset=utf-8")
    public String selectExamInformation(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String selectExamInformation = map.get("selectExamInformation");
        List<ExamInformation> list = new ArrayList<>();
        String person = CookieUtil.getCookie(request,"name");
        HashMap map1 = new HashMap();
        map1.put("selectExamInformation",selectExamInformation);
        map1.put("name",person);
        list = tei.findExamInformation(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/seekInforById.action",produces = "application/json; charset=utf-8")
    public String seekInforById(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<ExamInformation> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        list = tei.seekInforById(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/sureUpdateExam.action",produces = "application/json; charset=utf-8")
    public String sureUpdateExam(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String id = map.get("id");
        String name = map.get("name");
        String subject = map.get("subject");
        String examDate = map.get("examDate");
        int i = Integer.parseInt(id);
        ExamInformation ei = new ExamInformation(i,name,subject,examDate);
        tei.sureUpdateExam(ei);
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/deleInfo.action",produces = "application/json; charset=utf-8")
    public String deleInfo(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<Question> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        tei.deleInfo(map1);
        return new Gson().toJson(list);
    }
}
