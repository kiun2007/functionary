package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VAgencyRecord;
import com.kiun.functionary.dao.gks.entity.VAgencyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VAgencyRecordMapper extends com.kiun.functionary.base.BaseExampleMapper<VAgencyRecordExample, VAgencyRecord> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_agency_record
     * 2024-01-14 23:47:45
     */
    List<VAgencyRecord> selectByExampleWithBLOBs(VAgencyRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_agency_record
     * 2024-01-14 23:47:45
     */
    int updateByExampleWithBLOBs(@Param("record") VAgencyRecord record, @Param("example") VAgencyRecordExample example);

    List<VAgencyRecord> selectByAgencyId(String agencyId);

    List<VAgencyRecord> selectByAgencyName(String agencyName);

    List<VAgencyRecord> selectByUserId(String userId);

    List<VAgencyRecord> selectByName(String name);

    List<VAgencyRecord> selectByAdmin(String admin);

    List<VAgencyRecord> selectByTitle(String title);

    List<VAgencyRecord> selectByUpdTime(java.util.Date updTime);

    List<VAgencyRecord> selectByLoginName(String loginName);

    List<VAgencyRecord> selectByUserName(String userName);

    List<VAgencyRecord> selectByMobileNo(String mobileNo);

    List<VAgencyRecord> selectByEducation(String education);

    List<VAgencyRecord> selectBySpeciality(String speciality);

    List<VAgencyRecord> selectByPolitical(String political);

    List<VAgencyRecord> selectByType(String type);

    List<VAgencyRecord> selectByRegion(String region);
}