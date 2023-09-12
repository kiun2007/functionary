package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VJobInfo;
import com.kiun.functionary.dao.gks.entity.VJobInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VJobInfoMapper extends com.kiun.functionary.base.BaseExampleMapper<VJobInfoExample, VJobInfo> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_gks_job_info
     * 2023-09-12 19:17:49
     */
    List<VJobInfo> selectByExampleWithBLOBs(VJobInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_gks_job_info
     * 2023-09-12 19:17:49
     */
    int updateByExampleWithBLOBs(@Param("record") VJobInfo record, @Param("example") VJobInfoExample example);

    List<VJobInfo> selectById(String id);

    List<VJobInfo> selectByJobNotice(String jobNotice);

    List<VJobInfo> selectByJobName(String jobName);

    List<VJobInfo> selectByJobCount(Integer jobCount);

    List<VJobInfo> selectByJobSalary(java.math.BigDecimal jobSalary);

    List<VJobInfo> selectByJobRequire(String jobRequire);

    List<VJobInfo> selectByJobWork(String jobWork);

    List<VJobInfo> selectByFactorSpeciality(String factorSpeciality);

    List<VJobInfo> selectByFactorEducation(String factorEducation);

    List<VJobInfo> selectByFactorGender(String factorGender);

    List<VJobInfo> selectByFactorDomicile(String factorDomicile);

    List<VJobInfo> selectByFactorAgeMax(Integer factorAgeMax);

    List<VJobInfo> selectByFactorAgeMin(Integer factorAgeMin);

    List<VJobInfo> selectByFactorDesc(String factorDesc);

    List<VJobInfo> selectByAddUserId(String addUserId);

    List<VJobInfo> selectByAddTime(java.util.Date addTime);

    List<VJobInfo> selectByUpdUserId(String updUserId);

    List<VJobInfo> selectByUpdTime(java.util.Date updTime);

    List<VJobInfo> selectByUpdTerminalIp(String updTerminalIp);

    List<VJobInfo> selectByCount(Long count);

    List<VJobInfo> selectByNoticeJobCount(java.math.BigDecimal noticeJobCount);

    List<VJobInfo> selectByPublishTime(java.util.Date publishTime);

    List<VJobInfo> selectByEndTime(java.util.Date endTime);

    List<VJobInfo> selectByDetails(String details);
}