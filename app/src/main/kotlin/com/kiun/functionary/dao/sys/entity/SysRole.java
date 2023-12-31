package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 角色管理
 *
 * sys_role
 *
 * 2023-08-02 22:48:51
 */
@ApiModel(description="角色管理")
@ListBuild(value = "SysRole", title = "角色管理", operate = {
        @Operate(title = "添加", url = "/general/add/SysRole", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/SysRole/{id}"),
        @Operate(title = "管理菜单", url = "/general/tree/VRoleMenuTree?roleId={id}&parentCode=parentId&code=menuId"),
        @Operate(title = "删除", url = "/{formId}/removeQuery", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class SysRole extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Edit | FormFlag.EditDisable)
    private String roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @ListBuildItem(title = "角色名称")
    private String roleName;

    /**
     * 角色类型
     */
    @ApiModelProperty("角色类型")
    @ListBuildItem(title = "角色类型")
    private String roleType;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @ListBuildItem(title = "备注")
    private String remark;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    private String addUserId;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    @ListBuildItem(title = "添加用户", flag = FormFlag.Table)
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间", flag = FormFlag.Table)
    private Date addTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private String updUserId;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @ListBuildItem(title = "修改用户", flag = FormFlag.Table)
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间", flag = FormFlag.Table)
    private Date updTime;

    /**
     * 终端IP
     */
    @ApiModelProperty("终端IP")
    @ListBuildItem(title = "终端IP", flag = FormFlag.Table)
    private String updTerminalIp;

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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     * 2023-08-02 22:48:51
     */
    public void setId(String id) {
        this.roleId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     * 2023-08-02 22:48:51
     */
    public String getId() {
        return roleId;
    }
}
