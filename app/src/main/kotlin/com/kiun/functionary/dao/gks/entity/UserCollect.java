package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.base.general.UserId;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 收藏
 *
 * gks_user_collect
 *
 * 2023-08-30 21:33:43
 */
@ApiModel(description="收藏")
@ListBuild(value = "UserCollect", title = "收藏")
public class UserCollect extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键")
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @ListBuildItem(title = "用户ID")
    @UserId
    private String userId;

    /**
     * 引用画面
     */
    @ApiModelProperty("引用画面")
    @ListBuildItem(title = "引用画面")
    private String viewId;

    /**
     * 画面类型
     */
    @ApiModelProperty("画面类型")
    @ListBuildItem(title = "画面类型")
    private String viewType;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    @ListBuildItem(title = "添加用户")
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
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @ListBuildItem(title = "修改用户")
    private String updUserId;

    /**
     * 修改用户名称
     */
    @ApiModelProperty("修改用户名称")
    @ListBuildItem(title = "修改用户名称")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
    @ListBuildItem(title = "修改数据人员IP")
    private String updTerminalIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId == null ? null : viewId.trim();
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType == null ? null : viewType.trim();
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
