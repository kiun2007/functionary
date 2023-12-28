package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.FormFlag;
import com.kiun.functionary.base.general.FormType;
import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 字典项详情
 *
 * sys_dict_item
 *
 * 2023-07-26 21:14:35
 */
@ApiModel(description="字典项详情")
@ListBuild(value = "SysDictItem", title = "字典项详情")
public class SysDictItem1 extends IdRandom {

    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    @ListBuildItem(title = "字典", flag = FormFlag.AddDisable|FormFlag.Add|FormFlag.Edit|FormFlag.EditDisable, type = FormType.Hidden)
    private String dictId;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    private String dictName;

    /**
     * 父项
     */
    @ApiModelProperty("父项")
    @ListBuildItem(title = "父项", flag = FormFlag.Update | FormFlag.AddDisable | FormFlag.EditDisable, type = FormType.Hidden)
    private String parentId;

    /**
     * 字典键
     */
    @ApiModelProperty("字典键")
    @ListBuildItem(title = "字典键")
    private String itemKey;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Non)
    private String id;

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    @ListBuildItem(title = "字典值")
    private String itemVal;

    @ApiModelProperty("别称")
    private String itemAlias;

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
     * 修改用户ID
     */
    @ApiModelProperty("修改用户ID")
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

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey == null ? null : itemKey.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
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

    public String getItemAlias() {
        return itemAlias;
    }

    public void setItemAlias(String itemAlias) {
        this.itemAlias = itemAlias;
    }
}
