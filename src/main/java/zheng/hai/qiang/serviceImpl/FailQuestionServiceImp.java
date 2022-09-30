package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.FailQuestionMapper;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.service.FailQuestionService;

import java.util.HashMap;
import java.util.List;

public class FailQuestionServiceImp implements FailQuestionService {

    @Autowired
    FailQuestionMapper fqm;

    @Override
    public List<ExamResult> seedFailQuestion(HashMap map) {
        return fqm.seedFailQuestion(map);
    }
}
