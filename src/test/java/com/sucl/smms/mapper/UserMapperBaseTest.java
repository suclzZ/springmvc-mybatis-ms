package com.sucl.smms.mapper;

import com.sucl.smms.BaseTest;
import com.sucl.smms.system.model.User;
import com.sucl.smms.system.mapper.UserMapper;

import javax.annotation.Resource;

public class UserMapperBaseTest extends BaseTest {
    @Resource
    private UserMapper userMapper;

    @org.junit.Test
    public void save(){
        User user = new User();
        user.setUserId("m01");
        user.setLoginName("mln01");
        userMapper.insert(user);
    }

}
