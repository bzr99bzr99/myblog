package nuc.edu.cn.bzr.service.serviceimpl;

import nuc.edu.cn.bzr.mapper.UserMapper;
import nuc.edu.cn.bzr.model.User;
import nuc.edu.cn.bzr.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByAccount(int userAccount) {
        return userMapper.findUserByAccount(userAccount);
    }

}
