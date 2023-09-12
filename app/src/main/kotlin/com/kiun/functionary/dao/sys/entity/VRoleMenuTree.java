package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * VIEW
 *
 * v_role_menu_tree
 *
 * 2023-08-06 01:43:04
 */
@ApiModel(description="权限菜单关联")
@ListBuild(value = "VRoleMenuTree", title = "权限关联", operate = {
        @Operate(title = "关联菜单", url = "/generalList/SysRoleMenu/add?roleId={roleId}&menuId={menuId}", function = "removeUrl", icon = "fa-plus"),
        @Operate(title = "取消关联", url = "/generalList/SysRoleMenu/removeQuery?roleId={roleId}&menuId={menuId}", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class VRoleMenuTree  {
    /**
     * 功能名称
     */
    @ApiModelProperty("功能名称")
    @ListBuildItem(title = "功能名称")
    private String menuName;

    /**
     * 上级菜单编号
     */
    @ApiModelProperty("上级菜单编号")
    @ListBuildItem(title = "上级菜单编号", flag = FormFlag.Non)
    private String parentId;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer displayId;

    /**
     * M-表示菜单
     */
    @ApiModelProperty("M-表示菜单")
    @ListBuildItem(title = "类型", flag = FormFlag.Table, type = FormType.Enum, enums = {"C", "菜单", "M", "目录"})
    private String menuType;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    @ListBuildItem(title = "角色", flag = FormFlag.Search, type = FormType.Hidden)
    private String roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    @ListBuildItem(title = "菜单ID", flag = FormFlag.Non)
    private String menuId;

    /**
     * 模块编号
     */
    @ApiModelProperty("模块编号")
    private String moduleId;

    /**
     */
    @ApiModelProperty("是否激活")
    @ListBuildItem(title = "是否关联", flag = FormFlag.Table, type = FormType.Enum, enums = {"Y", "关联", "N", "未关联"})
    private String active;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getDisplayId() {
        return displayId;
    }

    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }
}
