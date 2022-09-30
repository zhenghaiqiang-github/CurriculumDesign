package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.service.ExamRankService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ExamRank {
    @Autowired
    public ExamRankService ers;


    @ResponseBody
    @RequestMapping(value = "/html/selectRankInfor.action",produces = "application/json; charset=utf-8")
    public String addQuestion(@RequestBody Map<String,String> map, HttpServletRequest request) {
        String examCode = map.get("examCode");
        List<ExamResult> list = new ArrayList<>();
        list = ers.selectExamRank(examCode);
        return new Gson().toJson(list);
    }

}
