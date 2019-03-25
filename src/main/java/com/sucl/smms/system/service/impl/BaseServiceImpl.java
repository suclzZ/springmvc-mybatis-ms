package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.service.BaseService;

import javax.annotation.Resource;
import java.io.Serializable;

public class BaseServiceImpl<T , PK extends Serializable> implements BaseService {
    @Resource
    private T baseMapper;

    @Override
    public int deleteByPrimaryKey(Serializable serializable) {
        return 0;
    }

    @Override
    public int insert(Object record) {
        return 0;
    }

    @Override
    public int insertSelective(Object record) {
        return 0;
    }

    @Override
    public Object selectByPrimaryKey(Serializable serializable) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Object record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Object record) {
        return 0;
    }
}
