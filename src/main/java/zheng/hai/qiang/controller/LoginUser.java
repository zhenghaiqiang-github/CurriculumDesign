package zheng.hai.qiang.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zheng.hai.qiang.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class LoginUser {

    @Autowired
    public LoginService ls;

    //学生登录
    @ResponseBody
    @RequestMapping(value = "*/login.action",produces = "application/json; charset=utf-8")
    public String selectId(@RequestBody Map<String,String> map, HttpServletResponse response) {
        String account = map.get("account");
        String password = map.get("password");
        String status = map.get("status");
        Map rtnMap = new HashMap();

        if(status.equals("student")) {
            rtnMap = ls.selectPassword(account);
            if(rtnMap==null) {
                map.put("msg", "null");
            }else {
                if(rtnMap.get("password").equals(password)) {
                    map.put("msg", "studentYes");
                    Cookie nameCookie = new Cookie("name", (String) rtnMap.get("name"));
                    Cookie accountCookie = new Cookie("account", account);
                    Cookie statusCookie = new Cookie("status", status);
                    response .addCookie(accountCookie);
                    response.addCookie(nameCookie);
                    response.addCookie(statusCookie);
                }else {
                    map.put("msg", "no");
                }
            }
        }
        if(status.equals("teacher")) {
            rtnMap = ls.selectTeacherPassword(account);
            if(rtnMap==null) {
                map.put("msg", "null");
            }else {
                if(rtnMap.get("password").equals(password)) {
                    map.put("msg", "teacherYes");
                    Cookie nameCookie = new Cookie("name", (String) rtnMap.get("name"));
                    Cookie statusCookie = new Cookie("status", status);
                    response.addCookie(nameCookie);
                    response.addCookie(statusCookie);
                }else {
                    map.put("msg", "no");
                }
            }
        }
        return new Gson().toJson(map);
    }

    @ResponseBody
    @RequestMapping(value = "login.action",produces = "application/json; charset=utf-8")
    public String selectId2(@RequestBody Map<String,String> map, HttpServletResponse response) {
        String account = map.get("account");
        String password = map.get("password");
        String status = map.get("status");
        Map rtnMap = new HashMap();

        if(status.equals("student")) {
            rtnMap = ls.selectPassword(account);
            if(rtnMap==null) {
                map.put("msg", "null");
            }else {
                if(rtnMap.get("password").equals(password)) {
                    map.put("msg", "studentYes");
                    Cookie nameCookie = new Cookie("name", (String) rtnMap.get("name"));
                    Cookie statusCookie = new Cookie("status", status);

                    response.addCookie(nameCookie);

                    response.addCookie(statusCookie);
                }else {
                    map.put("msg", "no");
                }
            }
        }
        if(status.equals("teacher")) {
            rtnMap = ls.selectTeacherPassword(account);
            if(rtnMap==null) {
                map.put("msg", "null");
            }else {
                if(rtnMap.get("password").equals(password)) {
                    map.put("msg", "teacherYes");
                    Cookie nameCookie = new Cookie("name", (String) rtnMap.get("name"));
                    Cookie accountCookie = new Cookie("account", account);
                    Cookie statusCookie = new Cookie("status", status);
                    response.addCookie(accountCookie);
                    response.addCookie(nameCookie);

                    response.addCookie(statusCookie);
                }else {
                    map.put("msg", "no");
                }
            }
        }
        return new Gson().toJson(map);
    }
}
