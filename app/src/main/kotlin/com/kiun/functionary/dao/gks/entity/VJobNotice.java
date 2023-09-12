package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * VIEW
 *
 * v_gks_job_notice
 *
 * 2023-08-08 23:13:18
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VJobNotice", title = "岗位公告", operate = {
        @Operate(title = "添加", url = "/general/add/JobNotice", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/JobNotice?id={id}"),
        @Operate(title = "添加岗位", url = "/general/list/JobDetails?jobNotice={id}", icon = "fa-plus"),
        @Operate(title = "删除", url = "/general/delete", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class VJobNotice extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Update)
    private String id;

    /**
     * 招聘标题
     */
    @ApiModelProperty("招聘标题")
    @ListBuildItem(title = "招聘标题")
    private String title;

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    @ListBuildItem(title = "发布时间")
    private Date publishTime;

    /**
     * 招聘单位
     */
    @ApiModelProperty("招聘单位")
    @ListBuildItem(title = "招聘单位", flag = FormFlag.Non)
    private String organId;

    /**
     * 机构名
     */
    @ApiModelProperty("机构名")
    @ListBuildItem(title = "招聘单位")
    private String organName;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
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
