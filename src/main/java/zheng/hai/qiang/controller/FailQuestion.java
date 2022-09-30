package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.service.FailQuestionService;
import zheng.hai.qiang.utils.CookieUtil;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FailQuestion {

    @Autowired
    public FailQuestionService fqs;

    @ResponseBody
    @RequestMapping(value = "/html/seedFailQuestion.action",produces = "application/json; charset=utf-8")
    public String seedFailQuestion(HttpServletRequest request) {
        String person = CookieUtil.getCookie(request,"name");
        List<ExamResult> list = new ArrayList<>();
        HashMap map1 = new HashMap();
        map1.put("person",person);
        list = fqs.seedFailQuestion(map1);
        List<String> items=new ArrayList<String>();


        for(ExamResult er : list) {
            String[] as = er.getFailquestion().split(",");
            for(int j = 0; j <as.length; j++) {
                items.add(as[j]);
            }
            as=null;
        }

        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getFailquestion() != "" || list.get(i).getFailquestion() != null) {
                String[] as = list.get(i).getFailquestion().split(",");
                for(int j = 0; j <as.length; j++) {
                    items.add(as[j]);
                }
                as=null;
            }
        }*/
        Map<String,Integer> rtnmap = new HashMap<>();
        rtnmap = frequencyOfListElements(items);


        return new Gson().toJson(rtnmap);
    }

    public static Map<String,Integer> frequencyOfListElements( List<String> items ) {
        if (items == null || items.size() == 0) return null;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String temp : items) {
            Integer count = map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }
}
