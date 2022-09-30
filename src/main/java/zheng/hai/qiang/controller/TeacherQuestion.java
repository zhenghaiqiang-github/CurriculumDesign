package zheng.hai.qiang.controller;

/**
 * 作者:郑海强
 * 功能:题目设置
 * 修改日期:2021/3/10
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.Question;
import zheng.hai.qiang.service.TeacherQuestionService;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherQuestion {
    @Autowired
    public TeacherQuestionService tqs;

    @ResponseBody
    @RequestMapping(value = "/html/selectquestioncounts.action",produces = "application/json; charset=utf-8")
    public Integer selectquestioncounts(){
         int questions = tqs.selectquestioncounts();
        return questions;
    }
    @ResponseBody
    @RequestMapping(value = "/html/seekAll.action",produces = "application/json; charset=utf-8")
    public String seekAll(HttpServletRequest request) {
        List<Question> list = new ArrayList<>();
        String person = CookieUtil.getCookie(request,"name");
        list = tqs.findQuestionAll(person);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/addQuestion.action",produces = "application/json; charset=utf-8")
    public String addQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String question = map.get("question");
        String answer = map.get("answer");
        String optionA = map.get("optionA");
        String optionB = map.get("optionB");
        String optionC = map.get("optionC");
        String optionD = map.get("optionD");
        String subject = map.get("subject");
        String difficulty = map.get("difficulty");
        String book = map.get("book");
        String chapter = map.get("chapter");
        String person = CookieUtil.getCookie(request,"name");
        Question qt = new Question(question,answer,optionA,optionB,optionC,optionD,subject,person,book,chapter,difficulty);
        tqs.addQuestion(qt);
        System.out.println("666");
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/seekQuestion.action",produces = "application/json; charset=utf-8")
    public String seekQuestion(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String selectQuestion = map.get("selectQuestion");
        String selectSubject = map.get("selectSubject");
        List<Question> list = new ArrayList<>();
        String person = CookieUtil.getCookie(request,"name");
        HashMap map1 = new HashMap();
        map1.put("selectQuestion",selectQuestion);
        map1.put("selectSubject",selectSubject);
        map1.put("name",person);
        list = tqs.findQuestion(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/seekQuestionById.action",produces = "application/json; charset=utf-8")
    public String seekQuestionById(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<Question> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        list = tqs.findQuestionById(map1);
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/updateQuestion.action",produces = "application/json; charset=utf-8")
    public String updateQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String question = map.get("question");
        String answer = map.get("answer");
        String optionA = map.get("optionA");
        String optionB = map.get("optionB");
        String optionC = map.get("optionC");
        String optionD = map.get("optionD");
        String subject = map.get("subject");
        String id = map.get("id");
        String book = map.get("book");
        String chapter = map.get("chapter");
        int i = Integer.parseInt(id);
        Question qt = new Question(i,question,answer,optionA,optionB,optionC,optionD,subject,book,chapter);
        tqs.updateQuestion(qt);
        System.out.println("666");
        List<Question> list = new ArrayList<>();
        return new Gson().toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/html/deleQuestion.action",produces = "application/json; charset=utf-8")
    public String deleQuestion(@RequestBody Map<String,String> map,HttpServletRequest request) {
        String id = map.get("id");
        List<Question> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("id",id);
        tqs.deleQuedtion(map1);
        return new Gson().toJson(list);
    }

}
