package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.TeacherExamInformationMapper;
import zheng.hai.qiang.pojo.ExamInformation;
import zheng.hai.qiang.service.TeacherExamInformationService;

import java.util.HashMap;
import java.util.List;

public class TeacherExamInformationServiceImp implements TeacherExamInformationService {

    @Autowired
    TeacherExamInformationMapper teacherExamInformationMapper;

    @Override
    public Integer selectexamInformationfocounts() {
        return teacherExamInformationMapper.selectexamInformationfocounts();
    }
    @Override
    public void addExamInformation(ExamInformation ea) {

        teacherExamInformationMapper.addExamInformation(ea);
    }

    @Override
    public List<ExamInformation> findExamInformation(HashMap map) {
        System.out.println("111111111111111111"+teacherExamInformationMapper.findExamInformation(map));
        return teacherExamInformationMapper.findExamInformation(map);
    }

    @Override
    public List<ExamInformation> seekInforById(HashMap map) {
        return teacherExamInformationMapper.seekInforById(map);
    }

    @Override
    public void sureUpdateExam(ExamInformation ei) {
        teacherExamInformationMapper.sureUpdateExam(ei);
    }

    @Override
    public void deleInfo(HashMap map) {
        teacherExamInformationMapper.deleInfo(map);
    }
}
