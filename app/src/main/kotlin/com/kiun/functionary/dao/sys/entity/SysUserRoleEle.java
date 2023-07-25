package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色关联表
 * 
 * sys_user_role_ele
 *
 * 2023-07-23 22:37:00
 */
@ApiModel(description="用户角色关联表")
@ListBuild(value = "SysUserRoleEle", title = "用户角色关联表")
public class SysUserRoleEle {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @ListBuildItem(title = "用户ID")
    private String userId;

    /**
     * 权限ID
     */
    @ApiModelProperty("权限ID")
    @ListBuildItem(title = "权限ID")
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}