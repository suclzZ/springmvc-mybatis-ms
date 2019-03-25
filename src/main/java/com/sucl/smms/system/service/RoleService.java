package com.sucl.smms.system.service;

import com.sucl.smms.system.model.Role;

/**
 * @author sucl
 * @since 2019/3/25
 */
public interface RoleService {

    int deleteById(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByIdSelective(Role record);

    int updateById(Role record);
}
