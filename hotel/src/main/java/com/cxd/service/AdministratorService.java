package com.cxd.service;

import com.cxd.pojo.Administrator;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {

    public boolean Login(Administrator administrator);

}
