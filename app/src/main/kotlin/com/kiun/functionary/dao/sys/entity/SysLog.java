package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统操作日志表
 * 
 * sys_log
 *
 * 2023-07-10 20:55:36
 */
@ApiModel(description="系统操作日志表")
public class SysLog extends IdRandom {
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String logId;

    /**
     * 登录用户
     */
    @ApiModelProperty("登录用户")
    private String loginName;

    /**
     * 日志模块
     */
    @ApiModelProperty("日志模块")
    private String moduleId;

    /**
     * 登录IP
     */
    @ApiModelProperty("登录IP")
    private String regId;

    /**
     * 日志记录
     */
    @ApiModelProperty("日志记录")
    private String logValue;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建人ID
     */
    @ApiModelProperty("创建人ID")
    private String createrId;

    /**
     * 创建日期yyyyMMdd
     */
    @ApiModelProperty("创建日期yyyyMMdd")
    private String createDate;

    /**
     * 创建时间 hhmmss
     */
    @ApiModelProperty("创建时间 hhmmss")
    private String createTime;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId == null ? null : regId.trim();
    }

    public String getLogValue() {
        return logValue;
    }

    public void setLogValue(String logValue) {
        this.logValue = logValue == null ? null : logValue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     * 2023-07-10 20:55:36
     */
    public void setId(String id) {
        this.logId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     * 2023-07-10 20:55:36
     */
    public String getId() {
        return logId;
    }
}