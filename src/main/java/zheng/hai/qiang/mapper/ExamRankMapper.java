package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.ExamResult;

import java.util.List;

public interface ExamRankMapper {


    //根据条件查询
    List<ExamResult> selectExamRank(String examCode);

}
