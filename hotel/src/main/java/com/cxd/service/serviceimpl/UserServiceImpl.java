package com.cxd.service.serviceimpl;

import com.cxd.mapper.UserMapper;
import com.cxd.pojo.User;
import com.cxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public User queryUserById(int Id) {
        return userMapper.queryUserById(Id);
    }

    @Override
    public boolean Login(User user) {
        User user1 = userMapper.queryUserById(user.getId());
        if (user1 != null) {
//            比较密码
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean AddUser(User user) {
        int i = userMapper.addUser(user);
        return i == 1;
    }

    @Override
    public boolean DeleteUser(int Id) {
        int i = userMapper.deleteUser(Id);
        return i == 1;
    }

    @Override
    public boolean UpdateUser(User user) {
        int i = userMapper.updateUser(user);
        return i == 1;
    }


}
