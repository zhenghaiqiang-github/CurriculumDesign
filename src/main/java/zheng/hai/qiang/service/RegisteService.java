package zheng.hai.qiang.service;

import zheng.hai.qiang.pojo.Student;
import zheng.hai.qiang.pojo.Teacher;

public interface RegisteService {

    String selectAccount(String account);

    void addAccount(Student s1);

    String selectTeaAccount(String account);

    void addTeaAccount(Teacher s1);
}
