package com.cxd.service;

import com.cxd.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserList();

    public User queryUserById(int Id);

    public boolean Login(User user);

    public boolean AddUser(User user);

    //注销user的功能，到时候让admin调用
    public boolean DeleteUser(int Id);
    //String Name,String         先用user之后再可能再换具体的
    public boolean UpdateUser(User user);
    //修改密码用，理论上只要id和password   在列表页面绑定修改按钮来做
    //两个功能由一个类实现
}
