package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.mapper.MenuMapper;
import com.sucl.smms.system.model.Menu;
import com.sucl.smms.system.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sucl
 * @since 2019/3/25
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteById(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Menu record) {
        return menuMapper.updateByPrimaryKey(record);
    }
}
