package zheng.hai.qiang.service;

import zheng.hai.qiang.pojo.ExamInformation;

import java.util.HashMap;
import java.util.List;

public interface TeacherExamInformationService {

    Integer selectexamInformationfocounts();

    void addExamInformation(ExamInformation ea);

    List<ExamInformation> findExamInformation(HashMap map);

    List<ExamInformation> seekInforById(HashMap map);

    void sureUpdateExam(ExamInformation ei);

    void deleInfo(HashMap map);
}
