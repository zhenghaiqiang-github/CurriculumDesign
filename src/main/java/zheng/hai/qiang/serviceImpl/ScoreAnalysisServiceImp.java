package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.ScoreAnalysisMapper;
import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.service.ScoreAnalysisService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreAnalysisServiceImp implements ScoreAnalysisService {

    @Autowired
    ScoreAnalysisMapper scoreAnalysisMapper;

    @Override
    public List<ExamInformation> findExamCode(HashMap map) {
        return scoreAnalysisMapper.findExamCode(map);
    }

    @Override
    public Map<String, String> selectAvg(String examCode) {
        return scoreAnalysisMapper.selectAvg(examCode);
    }
}
