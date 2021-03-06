package com.cxd.mapper;

import com.cxd.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {
    List<Administrator> queryAdministratorList();

    Administrator queryAdministratorById(int Id);
}
