package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.mapper.UserMapper;
import com.sucl.smms.system.model.User;
import com.sucl.smms.system.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author sucl
 * @since 2019/3/25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteById(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> getUsers(User record) {
        return userMapper.selectByAll(record);
    }

    @Override
    public void saveOrUpdate(User user) {
        boolean update = !StringUtils.isEmpty(user.getUserId());
        if(update){
            userMapper.updateByPrimaryKey(user);
        }else{
            user.setUserId(UUID.randomUUID().toString());
            user.setPassword("123456");
            userMapper.insert(user);
        }
    }

    @Override
    public void batchDelete(String[] ids) {
        userMapper.batchDelete(ids);
    }
}
