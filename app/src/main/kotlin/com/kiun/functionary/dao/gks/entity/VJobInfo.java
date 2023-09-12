package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * VIEW
 * 
 * v_gks_job_info
 *
 * 2023-09-12 19:17:49
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VJobInfo", title = "VIEW")
public class VJobInfo extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键")
    private String id;

    /**
     * 公告
     */
    @ApiModelProperty("公告")
    @ListBuildItem(title = "公告")
    private String jobNotice;

    /**
     * 职位名称
     */
    @ApiModelProperty("职位名称")
    @ListBuildItem(title = "职位名称")
    private String jobName;

    /**
     * 招聘人数
     */
    @ApiModelProperty("招聘人数")
    @ListBuildItem(title = "招聘人数")
    private Integer jobCount;

    /**
     * 薪资待遇
     */
    @ApiModelProperty("薪资待遇")
    @ListBuildItem(title = "薪资待遇")
    private BigDecimal jobSalary;

    /**
     * 岗位要求
     */
    @ApiModelProperty("岗位要求")
    @ListBuildItem(title = "岗位要求")
    private String jobRequire;

    /**
     * 工作职责
     */
    @ApiModelProperty("工作职责")
    @ListBuildItem(title = "工作职责")
    private String jobWork;

    /**
     * 专业要求
     */
    @ApiModelProperty("专业要求")
    @ListBuildItem(title = "专业要求")
    private String factorSpeciality;

    /**
     * 学历要求
     */
    @ApiModelProperty("学历要求")
    @ListBuildItem(title = "学历要求")
    private String factorEducation;

    /**
     * 性别要求
     */
    @ApiModelProperty("性别要求")
    @ListBuildItem(title = "性别要求")
    private String factorGender;

    /**
     * 户籍地
     */
    @ApiModelProperty("户籍地")
    @ListBuildItem(title = "户籍地")
    private String factorDomicile;

    /**
     * 最大年龄
     */
    @ApiModelProperty("最大年龄")
    @ListBuildItem(title = "最大年龄")
    private Integer factorAgeMax;

    /**
     * 最小年龄
     */
    @ApiModelProperty("最小年龄")
    @ListBuildItem(title = "最小年龄")
    private Integer factorAgeMin;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @ListBuildItem(title = "备注")
    private String factorDesc;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    @ListBuildItem(title = "添加用户")
    private String addUserId;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间")
    private Date addTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @ListBuildItem(title = "修改用户")
    private String updUserId;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
    @ListBuildItem(title = "修改数据人员IP")
    private String updTerminalIp;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Long count;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private BigDecimal noticeJobCount;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Date publishTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Date endTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNotice() {
        return jobNotice;
    }

    public void setJobNotice(String jobNotice) {
        this.jobNotice = jobNotice == null ? null : jobNotice.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public Integer getJobCount() {
        return jobCount;
    }

    public void setJobCount(Integer jobCount) {
        this.jobCount = jobCount;
    }

    public BigDecimal getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(BigDecimal jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire == null ? null : jobRequire.trim();
    }

    public String getJobWork() {
        return jobWork;
    }

    public void setJobWork(String jobWork) {
        this.jobWork = jobWork == null ? null : jobWork.trim();
    }

    public String getFactorSpeciality() {
        return factorSpeciality;
    }

    public void setFactorSpeciality(String factorSpeciality) {
        this.factorSpeciality = factorSpeciality == null ? null : factorSpeciality.trim();
    }

    public String getFactorEducation() {
        return factorEducation;
    }

    public void setFactorEducation(String factorEducation) {
        this.factorEducation = factorEducation == null ? null : factorEducation.trim();
    }

    public String getFactorGender() {
        return factorGender;
    }

    public void setFactorGender(String factorGender) {
        this.factorGender = factorGender == null ? null : factorGender.trim();
    }

    public String getFactorDomicile() {
        return factorDomicile;
    }

    public void setFactorDomicile(String factorDomicile) {
        this.factorDomicile = factorDomicile == null ? null : factorDomicile.trim();
    }

    public Integer getFactorAgeMax() {
        return factorAgeMax;
    }

    public void setFactorAgeMax(Integer factorAgeMax) {
        this.factorAgeMax = factorAgeMax;
    }

    public Integer getFactorAgeMin() {
        return factorAgeMin;
    }

    public void setFactorAgeMin(Integer factorAgeMin) {
        this.factorAgeMin = factorAgeMin;
    }

    public String getFactorDesc() {
        return factorDesc;
    }

    public void setFactorDesc(String factorDesc) {
        this.factorDesc = factorDesc == null ? null : factorDesc.trim();
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId == null ? null : addUserId.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId == null ? null : updUserId.trim();
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getUpdTerminalIp() {
        return updTerminalIp;
    }

    public void setUpdTerminalIp(String updTerminalIp) {
        this.updTerminalIp = updTerminalIp == null ? null : updTerminalIp.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getNoticeJobCount() {
        return noticeJobCount;
    }

    public void setNoticeJobCount(BigDecimal noticeJobCount) {
        this.noticeJobCount = noticeJobCount;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}