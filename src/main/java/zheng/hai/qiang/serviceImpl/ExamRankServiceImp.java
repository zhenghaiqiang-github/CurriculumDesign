package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.ExamRankMapper;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.service.ExamRankService;

import java.util.List;

public class ExamRankServiceImp implements ExamRankService {

    @Autowired
    ExamRankMapper erm;

    @Override
    public List<ExamResult> selectExamRank(String examCode) {
        return erm.selectExamRank(examCode);
    }
}
