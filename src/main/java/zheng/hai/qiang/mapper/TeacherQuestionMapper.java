package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.Question;

import java.util.HashMap;
import java.util.List;

public interface TeacherQuestionMapper {
    //查询题目量
    Integer selectquestioncounts();
    //查询所有试题
    List<Question> findQuestionAll(String name);

    //根据条件查询试题
    List<Question> findQuestion(HashMap map);

    //添加试题
    void addQuedtion(Question qt);

    //根据条件查询试题
    List<Question> findQuestionById(HashMap map);

    //更新信息
    void updateQuestion(Question qt);

    void deleQuedtion(HashMap map);
}
