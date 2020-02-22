package nuc.edu.cn.bzr.mapper;

import nuc.edu.cn.bzr.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findUserByAccount(int userAccount);
}
