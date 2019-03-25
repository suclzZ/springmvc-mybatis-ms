package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.mapper.RoleMapper;
import com.sucl.smms.system.model.Role;
import com.sucl.smms.system.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sucl
 * @since 2019/3/25
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteById(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
