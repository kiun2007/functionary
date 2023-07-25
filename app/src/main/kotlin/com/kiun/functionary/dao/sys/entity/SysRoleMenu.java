package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色和菜单关联
 * 
 * sys_role_menu
 *
 * 2023-07-23 22:37:00
 */
@ApiModel(description="角色和菜单关联")
@ListBuild(value = "SysRoleMenu", title = "角色和菜单关联")
public class SysRoleMenu {
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    @ListBuildItem(title = "角色ID")
    private String roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    @ListBuildItem(title = "菜单ID")
    private String menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}