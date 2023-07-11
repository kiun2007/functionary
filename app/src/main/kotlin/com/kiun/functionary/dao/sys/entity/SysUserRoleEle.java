package com.kiun.functionary.dao.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色关联表
 * 
 * sys_user_role_ele
 *
 * 2023-07-10 20:55:36
 */
@ApiModel(description="用户角色关联表")
public class SysUserRoleEle {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;

    /**
     * 权限ID
     */
    @ApiModelProperty("权限ID")
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