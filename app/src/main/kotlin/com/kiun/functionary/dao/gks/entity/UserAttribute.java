package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 用户属性
 *
 * gks_user_attribute
 *
 * 2023-08-29 22:08:35
 */
@ApiModel(description="用户属性")
@ListBuild(value = "UserAttribute", title = "用户属性")
public class UserAttribute extends IdRandom {
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
    private String userId;

    /**
     * 字典
     */
    @ApiModelProperty("字典")
    @ListBuildItem(title = "字典")
    private String dictId;

    /**
     * 字典项
     */
    @ApiModelProperty("字典项")
    @ListBuildItem(title = "字典项")
    private String dictItemId;

    /**
     * 字典项键
     */
    @ApiModelProperty("字典项键")
    @ListBuildItem(title = "字典项键")
    private String dictItemKey;

    /**
     * 字典项父项
     */
    @ApiModelProperty("字典项父项")
    @ListBuildItem(title = "字典项父项")
    private String parentItemId;

    /**
     * 字典项值
     */
    @ApiModelProperty("字典项值")
    @ListBuildItem(title = "字典项值")
    private String dictItemVal;

    /**
     * 标识
     */
    @ApiModelProperty("标识")
    @ListBuildItem(title = "标识")
    private String tag;

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

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictItemId() {
        return dictItemId;
    }

    public void setDictItemId(String dictItemId) {
        this.dictItemId = dictItemId == null ? null : dictItemId.trim();
    }

    public String getDictItemKey() {
        return dictItemKey;
    }

    public void setDictItemKey(String dictItemKey) {
        this.dictItemKey = dictItemKey == null ? null : dictItemKey.trim();
    }

    public String getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(String parentItemId) {
        this.parentItemId = parentItemId == null ? null : parentItemId.trim();
    }

    public String getDictItemVal() {
        return dictItemVal;
    }

    public void setDictItemVal(String dictItemVal) {
        this.dictItemVal = dictItemVal == null ? null : dictItemVal.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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
