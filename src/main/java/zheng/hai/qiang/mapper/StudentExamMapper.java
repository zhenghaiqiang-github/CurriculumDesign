package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.pojo.Question;

import java.util.HashMap;
import java.util.List;


public interface StudentExamMapper {

    //根据考试码查询考试卷
    List<ExamInformation> findExam(HashMap map);

    //根据考试码查询考试卷
    List<ExamResult> findExamResult(String account,String examCode);

    String findQuestionId(String exam);

    List<Question> findQuestion(String[] id);

    //添加试卷结果
    void addExamResult(ExamResult er);
}
