package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OperateCookie {

    @ResponseBody
    @RequestMapping(value = "/html/teacherName.action",produces = "application/json; charset=utf-8")
    public String checkLogin(HttpServletRequest request) {
        Map map = new HashMap();
        String name = CookieUtil.getCookie(request,"name");
        if(name==null) {
            map.put("name", "no");
        }else {
            map.put("name",name);
        }
        return new Gson().toJson(map);
    }
}
