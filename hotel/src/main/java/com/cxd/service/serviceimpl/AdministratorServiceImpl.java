package com.cxd.service.serviceimpl;

import com.cxd.mapper.AdministratorMapper;
import com.cxd.pojo.Administrator;
import com.cxd.service.AdministratorService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service

public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper AdministratorMapper;


    @Override
    public boolean Login(Administrator administrator) {
        //        List<Administrator> administratorList = AdministratorMapper.queryAdministratorList();
//        for (Administrator administrator : administratorList){
//            System.out.println(administrator);
//        }
        int term =administrator.getId();
        Administrator a1 = AdministratorMapper.queryAdministratorById(term);
        if (a1==null) {
            return false;
        }else if (a1.getPassword().equals(administrator.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
