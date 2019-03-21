package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    public BaseServiceImpl(){
        System.out.println("baseServiceLmpl");
    }

    public void save() {
        System.out.println(" invoke save ");
    }
}
