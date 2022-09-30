package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.Exam;
import zheng.hai.qiang.pojo.Question;
import zheng.hai.qiang.service.TeacherExamService;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TeacherExam {
    @Autowired
    public TeacherExamService tes;

    @ResponseBody
    @RequestMapping(value = "/html/selectexamcounts.action",produces = "application/json; charset=utf-8")
    public Integer selectexamcounts(){
        int exam = tes.selectexamcounts();
        return exam;
    }
    @ResponseBody
    @RequestMapping(value = "/html/addExam.action",produces = "application/json; charset=utf-8")
    public String addQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String name = map.get("name");
        String singleScore = map.get("singleScore");
        String subject = map.get("subject");
        String book = map.get("book");
        String chapter = map.get("chapter");
        String question = map.get("question");
        String person = CookieUtil.getCookie(request,"name");
        String [] result = question.split(",");
        int account = result.length;
        int single = Integer.parseInt(singleScore);
        String totalScore = String.valueOf(account*single);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String createDate = df.format(new Date());
        Exam ea = new Exam(name,totalScore,createDate,person,subject,book,chapter,question);
        tes.addExam(ea);
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/selectExam.action",produces = "application/json; charset=utf-8")
    public String seekQuestion(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String selectExam = map.get("selectExam");
        List<Exam> list = new ArrayList<>();
        String person = CookieUtil.getCookie(request,"name");
        HashMap map1 = new HashMap();
        map1.put("selectExam",selectExam);
        map1.put("name",person);
        list = tes.findExam(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/deleExam.action",produces = "application/json; charset=utf-8")
    public String deleExam(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<Question> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        tes.deleExam(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/seekExamById.action",produces = "application/json; charset=utf-8")
    public String seekExamById(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<Exam> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        list = tes.seekExamById(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/sureExam.action",produces = "application/json; charset=utf-8")
    public String sureExam(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String id = map.get("id");
        String name = map.get("name");
        String subject = map.get("subject");
        String book = map.get("book");
        String chapter = map.get("chapter");
        int i = Integer.parseInt(id);
        Exam ea = new Exam(i,name,subject,book,chapter);
        tes.updateExam(ea);
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }
}
