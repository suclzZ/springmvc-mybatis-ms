package com.sucl.smms.system.mapper;

import com.sucl.smms.system.model.Agency;

public interface AgencyMapper {
    int deleteByPrimaryKey(String agencyId);

    int insert(Agency record);

    int insertSelective(Agency record);

    Agency selectByPrimaryKey(String agencyId);

    int updateByPrimaryKeySelective(Agency record);

    int updateByPrimaryKeyWithBLOBs(Agency record);

    int updateByPrimaryKey(Agency record);
}