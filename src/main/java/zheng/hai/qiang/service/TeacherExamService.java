package zheng.hai.qiang.service;

import zheng.hai.qiang.pojo.Exam;
import java.util.HashMap;
import java.util.List;

public interface TeacherExamService {

    Integer selectexamcounts();

    void addExam(Exam ea);

    List<Exam> findExam(HashMap map);

    void deleExam(HashMap map);

    List<Exam> seekExamById(HashMap map);

    void updateExam(Exam ea);
    
}
