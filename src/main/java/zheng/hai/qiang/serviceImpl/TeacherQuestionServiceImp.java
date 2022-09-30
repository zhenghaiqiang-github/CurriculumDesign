package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.TeacherQuestionMapper;
import zheng.hai.qiang.pojo.Question;
import zheng.hai.qiang.service.TeacherQuestionService;

import java.util.HashMap;
import java.util.List;

public class TeacherQuestionServiceImp implements TeacherQuestionService {

    @Autowired
    TeacherQuestionMapper teacherQuestionMapper;


    @Override
    public Integer selectquestioncounts() {
        return teacherQuestionMapper.selectquestioncounts();
    }
    @Override
    public List<Question> findQuestionAll(String name) {
        return teacherQuestionMapper.findQuestionAll(name);
    }

    @Override
    public void addQuestion(Question qt) {
        teacherQuestionMapper.addQuedtion(qt);
    }

    @Override
    public List<Question> findQuestion(HashMap map) {
        return teacherQuestionMapper.findQuestion(map);
    }

    @Override
    public List<Question> findQuestionById(HashMap map) {
        return teacherQuestionMapper.findQuestionById(map);
    }

    @Override
    public void updateQuestion(Question qt) {
        teacherQuestionMapper.updateQuestion(qt);
    }

    @Override
    public void deleQuedtion(HashMap map) {
        teacherQuestionMapper.deleQuedtion(map);
    }
}
