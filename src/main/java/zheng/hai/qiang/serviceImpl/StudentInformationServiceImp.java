package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.StudentInformationMapper;
import zheng.hai.qiang.pojo.ExamResult;
import zheng.hai.qiang.service.StudentInformationService;

import java.util.HashMap;
import java.util.List;

public class StudentInformationServiceImp implements StudentInformationService {

    @Autowired
    StudentInformationMapper studentInformationMapper;
    @Override
    public Integer selectstudentcounts() {
        return studentInformationMapper.selectstudentcounts();
    }

    @Override
    public Integer selectteachercounts() {
        return studentInformationMapper.selectteachercounts();
    }

    @Override
    public List<ExamResult> findExamResult(HashMap map) {
        return studentInformationMapper.findExamResult(map);
    }
}
