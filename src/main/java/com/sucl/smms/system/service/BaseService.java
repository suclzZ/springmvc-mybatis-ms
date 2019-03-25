package com.sucl.smms.system.service;

import java.io.Serializable;

public interface BaseService<T , PK  extends Serializable> {

    int deleteByPrimaryKey(PK pk);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK pk);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
