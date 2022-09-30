package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.TeacherExamMapper;
import zheng.hai.qiang.pojo.Exam;
import zheng.hai.qiang.service.TeacherExamService;

import java.util.HashMap;
import java.util.List;

public class TeacherExamServiceImp implements TeacherExamService {

    @Autowired
    TeacherExamMapper teacherExamMapper;

    @Override
    public Integer selectexamcounts() {
        return teacherExamMapper.selectexamcounts();
    }

    @Override
    public void addExam(Exam ea) {
        teacherExamMapper.addExam(ea);
    }
//有问题
    @Override
    public List<Exam> findExam(HashMap map) {
        return teacherExamMapper.findExam(map);
    }

    @Override
    public void deleExam(HashMap map) {
        teacherExamMapper.deleExam(map);
    }

    @Override
    public List<Exam> seekExamById(HashMap map) {
        return teacherExamMapper.seekExamById(map);
    }

    @Override
    public void updateExam(Exam ea) {
        teacherExamMapper.updateExam(ea);
    }

}
