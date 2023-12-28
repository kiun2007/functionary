package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.JobMustAge;
import com.kiun.functionary.dao.gks.entity.JobMustAgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMustAgeMapper extends com.kiun.functionary.base.BaseExampleMapper<JobMustAgeExample, JobMustAge> {
    List<JobMustAge> selectByJobId(String jobId);

    List<JobMustAge> selectByYoungAge(java.util.Date youngAge);

    List<JobMustAge> selectByOldAge(java.util.Date oldAge);

    List<JobMustAge> selectByEducationId(String educationId);

    List<JobMustAge> selectByEducationName(String educationName);
}