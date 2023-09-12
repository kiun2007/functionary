package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * VIEW
 * 
 * v_root_dict_item
 *
 * 2023-08-26 18:40:36
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VRootDictItem", title = "VIEW")
public class VRootDictItem extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键")
    private String id;

    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    @ListBuildItem(title = "字典ID")
    private String dictId;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    @ListBuildItem(title = "字典名称")
    private String dictName;

    /**
     * 字典键
     */
    @ApiModelProperty("字典键")
    @ListBuildItem(title = "字典键")
    private String itemKey;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String itemKeyHead;

    /**
     * 父项
     */
    @ApiModelProperty("父项")
    @ListBuildItem(title = "父项")
    private String parentId;

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    @ListBuildItem(title = "字典值")
    private String itemVal;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @ListBuildItem(title = "排序")
    private Integer itemOrder;

    /**
     * 添加用户ID
     */
    @ApiModelProperty("添加用户ID")
    @ListBuildItem(title = "添加用户ID")
    private String addUserId;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    @ListBuildItem(title = "添加用户")
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
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @ListBuildItem(title = "修改用户")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     * 终端IP
     */
    @ApiModelProperty("终端IP")
    @ListBuildItem(title = "终端IP")
    private String updTerminalIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey == null ? null : itemKey.trim();
    }

    public String getItemKeyHead() {
        return itemKeyHead;
    }

    public void setItemKeyHead(String itemKeyHead) {
        this.itemKeyHead = itemKeyHead == null ? null : itemKeyHead.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getItemVal() {
        return itemVal;
    }

    public void setItemVal(String itemVal) {
        this.itemVal = itemVal == null ? null : itemVal.trim();
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
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