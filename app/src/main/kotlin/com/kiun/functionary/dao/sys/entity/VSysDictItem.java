package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * VIEW
 *
 * v_sys_dict_item
 *
 * 2023-09-24 17:19:58
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VSysDictItem", title = "VIEW")
public class VSysDictItem extends IdRandom {
    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String id;

    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    @ListBuildItem(title = "字典ID")
    private String dictId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
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
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String addUserId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间")
    private Date addTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updUserId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String updTerminalIp;

    /**
     */
    @ApiModelProperty("子项数量")
    @ListBuildItem(title = "子项数量")
    private Long childCount;

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

    public Long getChildCount() {
        return childCount;
    }

    public void setChildCount(Long childCount) {
        this.childCount = childCount;
    }
}
