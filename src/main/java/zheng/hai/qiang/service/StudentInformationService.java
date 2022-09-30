package zheng.hai.qiang.service;

import zheng.hai.qiang.pojo.ExamResult;

import java.util.HashMap;
import java.util.List;

public interface StudentInformationService {

    Integer selectstudentcounts();

    Integer selectteachercounts();
    //根据条件查询
    List<ExamResult> findExamResult(HashMap map);
    
}
