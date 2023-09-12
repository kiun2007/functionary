package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.*;
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
 * 2023-08-08 23:13:18
 */
@ApiModel(description="岗位信息")
@ListBuild(value = "JobDetails", title = "岗位信息", operate = {
        @Operate(title = "添加", url = "/general/add/JobDetails?jobNotice={jobNotice}", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/JobDetails?id={id}&jobNotice={jobNotice}"),
        @Operate(title = "删除", url = "/general/delete", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class JobDetails extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Edit | FormFlag.EditDisable)
    private String id;

    /**
     * 公告
     */
    @ApiModelProperty("公告")
    @ListBuildItem(title = "公告", flag = FormFlag.Update|FormFlag.Search, type = FormType.Hidden)
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
    @ListBuildItem(title = "招聘人数", flag = FormFlag.Update|FormFlag.Table)
    private Integer jobCount;

    /**
     * 薪资待遇
     */
    @ApiModelProperty("薪资待遇")
    @ListBuildItem(title = "薪资待遇", flag = FormFlag.Update|FormFlag.Table)
    private BigDecimal jobSalary;

    /**
     * 岗位要求
     */
    @ApiModelProperty("岗位要求")
    @ListBuildItem(title = "岗位要求", flag = FormFlag.Update|FormFlag.Table)
    private String jobRequire;

    /**
     * 工作职责
     */
    @ApiModelProperty("工作职责")
    @ListBuildItem(title = "工作职责", flag = FormFlag.Update|FormFlag.Table)
    private String jobWork;

    /**
     * 专业要求
     */
    @ApiModelProperty("专业要求")
    @ListBuildItem(title = "专业要求", flag = FormFlag.Update|FormFlag.Table)
    private String factorSpeciality;

    /**
     * 学历要求
     */
    @ApiModelProperty("学历要求")
    @ListBuildItem(title = "学历要求", flag = FormFlag.Update|FormFlag.Table, type = FormType.Select,selectOpt = @Select(
            label = "factorEducationName",
            formLabel = "itemVal",
            formValue = "itemKey",
            url = "/general/select-tree/VSysDictItemTree?dictId=gks_education&parentCode=parentId&code=id"
    ))
    private String factorEducation;

    /**
     * 性别要求
     */
    @ApiModelProperty("性别要求")
    @ListBuildItem(title = "性别要求", flag = FormFlag.Update|FormFlag.Table, type = FormType.Select,selectOpt = @Select(
            label = "factorGenderName",
            formLabel = "itemVal",
            formValue = "itemKey",
            url = "/general/select-tree/VSysDictItemTree?dictId=gks_gender&parentCode=parentId&code=id"
    ))
    private String factorGender;

    /**
     * 户籍地
     */
    @ApiModelProperty("户籍地")
    @ListBuildItem(title = "户籍地", flag = FormFlag.Update|FormFlag.Table, type = FormType.Select, selectOpt = @Select(
            label = "factorDomicileName",
            formLabel = "itemVal",
            formValue = "itemKey",
            url = "/general/select-tree/VSysDictItemTree?dictId=gks_region&parentCode=parentId&code=id")
    )
    private String factorDomicile;

    /**
     * 最大年龄
     */
    @ApiModelProperty("最大年龄")
    @ListBuildItem(title = "最大年龄", flag = FormFlag.Update|FormFlag.Table)
    private Integer factorAgeMax;

    /**
     * 最小年龄
     */
    @ApiModelProperty("最小年龄")
    @ListBuildItem(title = "最小年龄", flag = FormFlag.Update|FormFlag.Table)
    private Integer factorAgeMin;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @ListBuildItem(title = "备注", flag = FormFlag.Update|FormFlag.Table)
    private String factorDesc;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    private String addUserId;

    /**
     * 添加用户名称
     */
    @ApiModelProperty("添加用户名称")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    private Date addTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private String updUserId;

    /**
     * 修改用户名称
     */
    @ApiModelProperty("修改用户名称")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
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
