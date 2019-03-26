package com.sucl.smms.system.mapper;

import com.sucl.smms.system.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    List<User> selectByAll(User record);

    void batchDelete(String[] ids);
}