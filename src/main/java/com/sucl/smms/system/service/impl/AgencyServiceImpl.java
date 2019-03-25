package com.sucl.smms.system.service.impl;

import com.sucl.smms.system.mapper.AgencyMapper;
import com.sucl.smms.system.model.Agency;
import com.sucl.smms.system.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sucl
 * @since 2019/3/25
 */
@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {
    @Resource
    private AgencyMapper agencyMapper;

    @Override
    public int deleteById(String id) {
        return agencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Agency record) {
        return agencyMapper.insert(record);
    }

    @Override
    public int insertSelective(Agency record) {
        return agencyMapper.insertSelective(record);
    }

    @Override
    public Agency selectByPrimaryKey(String id) {
        return agencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByIdSelective(Agency record) {
        return agencyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Agency record) {
        return agencyMapper.updateByPrimaryKey(record);
    }
}
