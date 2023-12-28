package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 岗位年龄要求
 *
 * gks_job_must_age
 *
 * 2023-10-14 08:56:45
 */
@ApiModel(description="岗位年龄要求")
@ListBuild(value = "JobMustAge", title = "岗位年龄要求")
public class JobMustAge {
    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    @ListBuildItem(title = "岗位ID")
    private String jobId;

    /**
     * 最年轻出生日期出生日期需在此之前
     */
    @ApiModelProperty("最年轻出生日期出生日期需在此之前")
    @ListBuildItem(title = "最年轻出生日期出生日期需在此之前")
    private Date youngAge;

    /**
     * 最老出生日期出生日期需在此之后
     */
    @ApiModelProperty("最老出生日期出生日期需在此之后")
    @ListBuildItem(title = "最老出生日期出生日期需在此之后")
    private Date oldAge;

    /**
     * 学历学位ID
     */
    @ApiModelProperty("学历学位ID")
    @ListBuildItem(title = "学历学位ID")
    private String educationId;

    /**
     * 学历学位名称
     */
    @ApiModelProperty("学历学位名称")
    @ListBuildItem(title = "学历学位名称")
    private String educationName;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public Date getYoungAge() {
        return youngAge;
    }

    public void setYoungAge(Date youngAge) {
        this.youngAge = youngAge;
    }

    public Date getOldAge() {
        return oldAge;
    }

    public void setOldAge(Date oldAge) {
        this.oldAge = oldAge;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId == null ? null : educationId.trim();
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName == null ? null : educationName.trim();
    }
}
