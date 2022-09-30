package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.Exam;

import java.util.HashMap;
import java.util.List;

public interface TeacherExamMapper {

    //查询试卷量
    Integer selectexamcounts();
    //添加试卷
    void addExam(Exam ea);

    //根据条件查询试卷
    List<Exam> findExam(HashMap map);

    void deleExam(HashMap map);

    List<Exam> seekExamById(HashMap map);

    void updateExam(Exam ea);
}
