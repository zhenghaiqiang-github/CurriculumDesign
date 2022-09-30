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
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//控制器标识
@Controller
public class ExamExport {
    //依赖注入
    @Autowired
    public ExamRankService ers;

    @ResponseBody
    @RequestMapping(value = "/html/rankExport.action",produces = "application/json; charset=utf-8")
    public String rankExport(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) {
        String examCode = map.get("examCode");
        List<ExamResult> list = new ArrayList<>();
        list = ers.selectExamRank(examCode);
        return new Gson().toJson(list);
       /* String[] title = {"考试排名","考生账号","考试姓名","分数"};

        //excel文件名
        String fileName = "学生成绩表"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "学生成绩表";

        String[][] content = new String[ list.size() ][ title.length ];

        for (int i = 0; i < list.size(); i++) {
            content[i][0] = String.valueOf(i);
            content[i][1] = list.get(i).getStudentaccount().toString();
            content[i][2] = list.get(i).getStudentName().toString();
            content[i][3] = list.get(i).getScore().toString();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
