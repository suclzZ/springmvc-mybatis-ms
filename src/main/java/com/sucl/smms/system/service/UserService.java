package com.sucl.smms.system.service;

import com.sucl.smms.system.model.User;

import java.util.List;

/**
 * @author sucl
 * @since 2019/3/25
 */
public interface UserService {

    int deleteById(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByIdSelective(User record);

    int updateById(User record);

    List<User> getUsers();

    List<User> getUsers(User record);

    void saveOrUpdate(User user);

    void batchDelete(String[] ids);
}
