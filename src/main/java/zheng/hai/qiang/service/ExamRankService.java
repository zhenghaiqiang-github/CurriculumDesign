package zheng.hai.qiang.service;

import zheng.hai.qiang.pojo.ExamResult;

import java.util.List;

public interface ExamRankService {

    List<ExamResult> selectExamRank(String examCode);
}
