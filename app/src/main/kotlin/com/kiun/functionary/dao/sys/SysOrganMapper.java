package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.SysOrgan;
import com.kiun.functionary.dao.sys.entity.SysOrganExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrganMapper extends com.kiun.functionary.base.BaseExampleMapper<SysOrganExample, SysOrgan> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organ
     * 2023-07-23 22:37:00
     */
    int deleteByPrimaryKey(String organId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organ
     * 2023-07-23 22:37:00
     */
    SysOrgan selectByPrimaryKey(String organId);

    List<SysOrgan> selectByOrganId(String organId);

    List<SysOrgan> selectByOrganName(String organName);

    List<SysOrgan> selectByLevelNo(Integer levelNo);

    List<SysOrgan> selectByParentId(String parentId);

    List<SysOrgan> selectByAddress(String address);

    List<SysOrgan> selectByCuntryName(String cuntryName);

    List<SysOrgan> selectByPostNo(String postNo);

    List<SysOrgan> selectByPhoneNo(String phoneNo);

    List<SysOrgan> selectByFaxNo(String faxNo);

    List<SysOrgan> selectByCreaterId(String createrId);

    List<SysOrgan> selectByCreateDate(java.util.Date createDate);

    List<SysOrgan> selectByUpdateId(String updateId);

    List<SysOrgan> selectByUpdateDate(java.util.Date updateDate);

    List<SysOrgan> selectByOrganType(String organType);
}