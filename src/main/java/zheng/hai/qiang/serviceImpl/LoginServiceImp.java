package zheng.hai.qiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import zheng.hai.qiang.mapper.LoginMapper;
import zheng.hai.qiang.service.LoginService;

import java.util.Map;

public class LoginServiceImp implements LoginService {

    @Autowired
    LoginMapper lm;

    @Override
    public Map<String, String> selectPassword(String account) {
        return lm.selectPassword(account);
    }

    @Override
    public Map<String, String> selectTeacherPassword(String account) {
        return lm.selectTeacherPassword(account);
    }
}
