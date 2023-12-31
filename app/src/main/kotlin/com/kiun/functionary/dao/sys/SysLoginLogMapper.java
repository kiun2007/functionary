package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.SysLoginLog;
import com.kiun.functionary.dao.sys.entity.SysLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginLogMapper extends com.kiun.functionary.base.BaseExampleMapper<SysLoginLogExample, SysLoginLog> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     * 2023-07-23 22:37:00
     */
    int deleteByPrimaryKey(String loginId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_login_log
     * 2023-07-23 22:37:00
     */
    SysLoginLog selectByPrimaryKey(String loginId);

    List<SysLoginLog> selectByLoginId(String loginId);

    List<SysLoginLog> selectByLoginName(String loginName);

    List<SysLoginLog> selectByReqIp(String reqIp);

    List<SysLoginLog> selectByReamrk(String reamrk);

    List<SysLoginLog> selectByCreaterId(String createrId);

    List<SysLoginLog> selectByCreateDate(java.util.Date createDate);

    List<SysLoginLog> selectByLoginType(String loginType);
}