package nuc.edu.cn.bzr.service;

import nuc.edu.cn.bzr.model.User;

public interface LoginService {
    public User findUserByAccount(int userAccount);
}
