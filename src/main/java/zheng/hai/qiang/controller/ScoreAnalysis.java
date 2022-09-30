package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.service.ScoreAnalysisService;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ScoreAnalysis {
    @Autowired
    public ScoreAnalysisService sas;

    @ResponseBody
    @RequestMapping(value = "/html/selectAvg.action",produces = "application/json; charset=utf-8")
    public String addQuestion(HttpServletRequest request) {
        String person = CookieUtil.getCookie(request,"name");
        List<ExamInformation> informationList = new ArrayList<>();
        HashMap map = new HashMap();
        map.put("person",person);
        informationList = sas.findExamCode(map);
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        for(ExamInformation ei : informationList) {
            Map map1 = new HashMap();
            map1 = sas.selectAvg(ei.getExamCode());
            if(map1 != null) {
                /*rtnMap.putAll(map1);*/
                map1.put("Avg",map1.get("AVG(score)"));
                map1.put("Count",map1.get("COUNT(id)"));
                map1.put("Max",map1.get("MAX(score)"));
                map1.put("Min",map1.get("MIN(score)"));
                list.add(map1);
            }
        }
        return new Gson().toJson(list);
    }

}
