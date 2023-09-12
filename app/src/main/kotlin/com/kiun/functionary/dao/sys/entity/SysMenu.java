package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 系统菜单表
 *
 * sys_menu
 *
 * 2023-08-02 00:18:30
 */
@ApiModel(description="系统菜单表")
@ListBuild(value = "SysMenu", title = "系统菜单表")
public class SysMenu extends IdRandom {
    /**
     * 菜单编号
     */
    @ApiModelProperty("菜单编号")
    @ListBuildItem(title = "菜单编号")
    private String menuId;

    /**
     * 模块编号
     */
    @ApiModelProperty("模块编号")
    @ListBuildItem(title = "模块编号")
    private String moduleId;

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
    @ListBuildItem(title = "上级菜单编号")
    private String parentId;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    @ListBuildItem(title = "显示顺序")
    private Integer displayId;

    /**
     * 数据操作ID
     */
    @ApiModelProperty("数据操作ID")
    @ListBuildItem(title = "数据操作ID")
    private String sqlId;

    /**
     * 链接地址
     */
    @ApiModelProperty("链接地址")
    @ListBuildItem(title = "链接地址")
    private String linkUrl;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    @ListBuildItem(title = "菜单图标")
    private String img;

    /**
     * 菜单状态Y-正常N-注销
     */
    @ApiModelProperty("菜单状态Y-正常N-注销")
    @ListBuildItem(title = "菜单状态Y-正常N-注销")
    private String status;

    /**
     * M-表示菜单
     */
    @ApiModelProperty("M-表示菜单")
    @ListBuildItem(title = "M-表示菜单")
    private String menuType;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String remark;

    /**
     * code
     */
    @ApiModelProperty("code")
    @ListBuildItem(title = "code")
    private String code;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @ListBuildItem(title = "排序")
    private Integer orderNum;

    /**
     * 0 显示 1不显示
     */
    @ApiModelProperty("0 显示 1不显示")
    @ListBuildItem(title = "0 显示 1不显示")
    private String visible;

    /**
     * 添加用户ID
     */
    @ApiModelProperty("添加用户ID")
    @ListBuildItem(title = "添加用户ID")
    private String addUserId;

    /**
     * 添加用户名称
     */
    @ApiModelProperty("添加用户名称")
    @ListBuildItem(title = "添加用户名称")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间")
    private Date addTime;

    /**
     * 修改用户ID
     */
    @ApiModelProperty("修改用户ID")
    @ListBuildItem(title = "修改用户ID")
    private String updUserId;

    /**
     * 修改用户名称
     */
    @ApiModelProperty("修改用户名称")
    @ListBuildItem(title = "修改用户名称")
    private String updUserNm;

    /**
     * 修改用户时间
     */
    @ApiModelProperty("修改用户时间")
    @ListBuildItem(title = "修改用户时间")
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
    @ListBuildItem(title = "修改数据人员IP")
    private String updTerminalIp;

    private List<SysMenu> children = new LinkedList<>();

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public List<SysMenu> getChildren() {
        return children;
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

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId == null ? null : sqlId.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
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
     * This method corresponds to the database table sys_menu
     * 2023-08-02 00:18:30
     */
    public void setId(String id) {
        this.menuId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     * 2023-08-02 00:18:30
     */
    public String getId() {
        return menuId;
    }
}
