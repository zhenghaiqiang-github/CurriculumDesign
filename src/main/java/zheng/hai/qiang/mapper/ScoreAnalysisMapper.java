package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.ExamInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ScoreAnalysisMapper {


    //根据条件查询
    List<ExamInformation> findExamCode(HashMap map);

    Map<String,String> selectAvg(String examCode);
}
