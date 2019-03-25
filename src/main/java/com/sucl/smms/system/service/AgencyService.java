package com.sucl.smms.system.service;

import com.sucl.smms.system.model.Agency;

/**
 * @author sucl
 * @since 2019/3/25
 */
public interface AgencyService {

    int deleteById(String id);

    int insert(Agency record);

    int insertSelective(Agency record);

    Agency selectByPrimaryKey(String id);

    int updateByIdSelective(Agency record);

    int updateById(Agency record);
}
