package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.Agency;
import com.kiun.functionary.dao.gks.entity.AgencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyMapper extends com.kiun.functionary.base.BaseExampleMapper<AgencyExample, Agency> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_agency
     * 2023-12-28 17:53:09
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_agency
     * 2023-12-28 17:53:09
     */
    Agency selectByPrimaryKey(String id);

    List<Agency> selectById(String id);

    List<Agency> selectByName(String name);

    List<Agency> selectByTitle(String title);

    List<Agency> selectByDesc(String desc);

    List<Agency> selectByLogo(String logo);

    List<Agency> selectByAdmin(String admin);

    List<Agency> selectByAddUserId(String addUserId);

    List<Agency> selectByAddUserNm(String addUserNm);

    List<Agency> selectByAddTime(java.util.Date addTime);

    List<Agency> selectByUpdUserId(String updUserId);

    List<Agency> selectByUpdUserNm(String updUserNm);

    List<Agency> selectByUpdTime(java.util.Date updTime);

    List<Agency> selectByUpdTerminalIp(String updTerminalIp);
}