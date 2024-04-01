package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import static com.kiun.functionary.base.general.FormFlag.All;
import static com.kiun.functionary.base.general.FormFlag.Required;

/**
 * 岗位公告
 *
 * gks_job_notice
 *
 * 2024-01-20 13:33:57
 */
@ApiModel(description="岗位公告")
@ListBuild(value = "JobNotice", title = "岗位公告")
public class JobNotice extends IdRandom {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Edit|FormFlag.AddDisable|FormFlag.EditDisable)
    private String id;

    /**
     * 招聘标题
     */
    @ApiModelProperty("招聘标题")
    @ListBuildItem(title = "招聘标题", flag = All|Required)
    private String title;

    @ApiModelProperty("开始时间")
    @ListBuildItem(title = "开始时间", flag = All|Required)
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @ListBuildItem(title = "结束时间", flag = All|Required)
    private Date endTime;

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    @ListBuildItem(title = "发布时间", flag = All|Required)
    private Date publishTime;

    /**
     * 招聘单位
     */
    @ApiModelProperty("招聘单位")
    @ListBuildItem(title = "招聘单位", type = FormType.Select, selectOpt = @Select(
            label = "organName",
            formLabel = "organName",
            formValue = "organId",
            url = "/general/select-tree/SysOrgan?code=organId&parentCode="
    ))
    private String organId;

    /**
     * 公告类型
     */
    @ListBuildItem(title = "考试类型", flag = All|Required, type = FormType.Select, selectOpt = @Select(
            label = "typeName",
            formLabel = "itemVal",
            formValue = "itemKey",
            url = "/general/select-tree/VSysDictItemTree?dictId=gks_type&parentCode=parentId&code=id"))
    private String type;

    /**
     * 输入类型
     */
    @ApiModelProperty("录入类型")
    @ListBuildItem(title = "录入类型", flag = All|Required, type = FormType.Enum, enums = {"0", "自动导入/爬虫", "1", "手动录入"})
    private String inputType;

    /**
     * 信息发布网址
     */
    @ApiModelProperty("信息发布网址")
    @ListBuildItem(title = "信息发布网址")
    private String infoUrl;

    /**
     * 招聘发布网址
     */
    @ApiModelProperty("招聘发布网址")
    @ListBuildItem(title = "招聘发布网址")
    private String jobUrl;

    /**
     * 区域编码
     */
    @ApiModelProperty("区域编码")
    @ListBuildItem(title = "区域编码")
    private String rangCd;

    /**
     * 区域标识
     */
    @ApiModelProperty("区域标识")
    @ListBuildItem(title = "区域标识")
    private String rangId;

    /**
     * 区域名称
     */
    @ApiModelProperty("区域名称")
    @ListBuildItem(title = "区域名称")
    private String rangName;

    @ApiModelProperty("公告详情")
    @ListBuildItem(title = "公告详情", type = FormType.TextArea)
    private String details;

    /**
     * 详情页网址
     */
    @ApiModelProperty("详情页网址")
    @ListBuildItem(title = "详情页网址")
    private String detailUrl;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl == null ? null : infoUrl.trim();
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl == null ? null : jobUrl.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
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

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_notice
     * 2023-08-08 23:07:12
     */
    public void setId(String id) {
        this.id=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_job_notice
     * 2023-08-08 23:07:12
     */
    public String getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRangCd() {
        return rangCd;
    }

    public void setRangCd(String rangCd) {
        this.rangCd = rangCd == null ? null : rangCd.trim();
    }

    public String getRangId() {
        return rangId;
    }

    public void setRangId(String rangId) {
        this.rangId = rangId == null ? null : rangId.trim();
    }

    public String getRangName() {
        return rangName;
    }

    public void setRangName(String rangName) {
        this.rangName = rangName == null ? null : rangName.trim();
    }

}
