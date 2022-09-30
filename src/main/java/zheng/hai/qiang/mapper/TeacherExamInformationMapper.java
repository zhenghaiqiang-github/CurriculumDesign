package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.ExamInformation;
import java.util.HashMap;
import java.util.List;


public interface TeacherExamInformationMapper {
    //查询考试量
    Integer selectexamInformationfocounts();

    //添加试卷
    void addExamInformation(ExamInformation ei);

    //根据条件查询考试信息
    List<ExamInformation> findExamInformation(HashMap map);//seekInforById

    List<ExamInformation> seekInforById(HashMap map);//sureUpdateExam

    void sureUpdateExam(ExamInformation ei);

    void deleInfo(HashMap map);
}
