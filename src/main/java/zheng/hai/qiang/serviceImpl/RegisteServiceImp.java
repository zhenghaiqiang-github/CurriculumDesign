package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.RegisteMapper;
import zheng.hai.qiang.pojo.Student;
import zheng.hai.qiang.pojo.Teacher;
import zheng.hai.qiang.service.RegisteService;

public class RegisteServiceImp implements RegisteService {

    @Autowired
    RegisteMapper registeMapper;

    @Override
    public String selectAccount(String account) {
        return registeMapper.selectAccount(account);
    }

    @Override
    public void addAccount(Student s1) {
        registeMapper.addAccount(s1);
    }

    @Override
    public String selectTeaAccount(String account) {
        return registeMapper.selectTeaAccount(account);
    }

    @Override
    public void addTeaAccount(Teacher s1) {
        registeMapper.addTeaAccount(s1);
    }
}
