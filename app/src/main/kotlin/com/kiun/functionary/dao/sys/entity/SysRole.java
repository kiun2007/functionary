package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色表
 * 
 * sys_role
 *
 * 2023-07-23 22:37:00
 */
@ApiModel(description="角色表")
@ListBuild(value = "SysRole", title = "角色表")
public class SysRole extends IdRandom {
    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String roleId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String roleName;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String roleType;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String remark;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String createrId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String createDate;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String createTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updateId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updateDate;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updateTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String status;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
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

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     * 2023-07-23 22:37:00
     */
    public void setId(String id) {
        this.roleId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     * 2023-07-23 22:37:00
     */
    public String getId() {
        return roleId;
    }
}