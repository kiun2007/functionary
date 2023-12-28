package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 岗位信息
 *
 * gks_job_details
 *
 * 2023-10-14 21:01:04
 */
@ApiModel(description="岗位信息")
@ListBuild(value = "JobDetails", title = "岗位信息")
public class JobDetails1 extends IdRandom {
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
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    @ListBuildItem(title = "联系电话")
    private String jobTele;

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
     * 基础经历要求
     */
    @ApiModelProperty("基础经历要求")
    @ListBuildItem(title = "基础经历要求")
    private String factorUndergo;

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

    @ApiModelProperty("考试类型(冗余字段加快搜索)")
    @ListBuildItem(title = "考试类型(冗余字段加快搜索)")
    private String type;

    /**
     * 考试区域(冗余字段加快搜索)
     */
    @ApiModelProperty("考试区域(冗余字段加快搜索)")
    @ListBuildItem(title = "考试区域(冗余字段加快搜索)")
    private String region;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @ListBuildItem(title = "备注")
    private String factorDesc;

    /**
     * 源数据URL
     */
    @ApiModelProperty("源数据URL")
    @ListBuildItem(title = "源数据URL")
    private String sourceUrl;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String addUserId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间")
    private Date addTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updUserId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updTerminalIp;

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

    public String getJobTele() {
        return jobTele;
    }

    public void setJobTele(String jobTele) {
        this.jobTele = jobTele == null ? null : jobTele.trim();
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

    public String getFactorUndergo() {
        return factorUndergo;
    }

    public void setFactorUndergo(String factorUndergo) {
        this.factorUndergo = factorUndergo == null ? null : factorUndergo.trim();
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

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId == null ? null : addUserId.trim();
    }

    public String getAddUserNm() {
        return addUserNm;
    }

    public void setAddUserNm(String addUserNm) {
        this.addUserNm = addUserNm == null ? null : addUserNm.trim();
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

    public String getUpdUserNm() {
        return updUserNm;
    }

    public void setUpdUserNm(String updUserNm) {
        this.updUserNm = updUserNm == null ? null : updUserNm.trim();
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
}
