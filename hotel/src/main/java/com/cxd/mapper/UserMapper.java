package com.cxd.mapper;


import com.cxd.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表明这是一个mybatis的mapper类：  Dao层
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int Id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int Id);
}
