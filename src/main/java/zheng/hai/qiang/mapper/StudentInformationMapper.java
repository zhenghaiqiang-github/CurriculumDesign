package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.ExamResult;

import java.util.HashMap;
import java.util.List;

public interface StudentInformationMapper {
    //查询学生量
    Integer selectstudentcounts();
    //查询老师量(懒得再写教师的，所以写这里了)
    Integer selectteachercounts();
    //根据条件查询
    List<ExamResult> findExamResult(HashMap map);
}
