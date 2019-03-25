package com.sucl.smms.system.service;

import com.sucl.smms.system.model.Menu;

/**
 * @author sucl
 * @since 2019/3/25
 */
public interface MenuService {

    int deleteById(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByIdSelective(Menu record);

    int updateById(Menu record);
}
