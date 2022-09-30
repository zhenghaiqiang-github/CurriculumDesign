package zheng.hai.qiang.mapper;

import java.util.Map;

public interface LoginMapper {

    //根据账号查询密码
    Map<String,String> selectPassword(String account);

    //根据账号查询密码
    Map<String,String> selectTeacherPassword(String account);
}
