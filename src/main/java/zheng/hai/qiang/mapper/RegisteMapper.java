package zheng.hai.qiang.mapper;

import zheng.hai.qiang.pojo.Student;
import zheng.hai.qiang.pojo.Teacher;

public interface RegisteMapper {

    //查询该账号是否被注册过
    String selectAccount(String account);

    //注册账号
    void addAccount(Student t1);

    //查询该账号是否被注册过
    String selectTeaAccount(String account);

    //注册账号
    void addTeaAccount(Teacher t1);
}
