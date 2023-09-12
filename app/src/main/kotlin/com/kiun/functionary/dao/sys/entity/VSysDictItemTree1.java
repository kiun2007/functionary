package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * VIEW
 *
 * v_sys_dict_item_tree
 *
 * 2023-07-29 15:05:20
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VSysDictItemTree", title = "VIEW", operate = {
        @Operate(title = "添加", url = "/general/add/SysDictItem?dictId={dictId}&dictName={dictName}", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/SysDictItem?dictId={dictId}&itemKey={itemKey}"),
        @Operate(title = "添加子项", icon = "fa-plus", url = "/general/add/SysDictItem?dictId={dictId}&dictName={dictName}&parentId={id}"),
        @Operate(title = "删除", url = "/generalList/SysDictItem/removeQuery?id={id}", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class VSysDictItemTree1 extends IdRandom {

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    @ListBuildItem(title = "字典值", flag = FormFlag.Table)
    private String itemVal;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Non)
    private String id;

    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    @ListBuildItem(title = "字典ID", flag = FormFlag.Search, type = FormType.Hidden)
    private String dictId;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    @ListBuildItem(title = "字典名称", flag = FormFlag.Table)
    private String dictName;

    /**
     * 字典键
     */
    @ApiModelProperty("字典键")
    @ListBuildItem(title = "字典键", flag = FormFlag.Table | FormFlag.Search)
    private String itemKey;

    /**
     * 父项
     */
    @ApiModelProperty("父项")
    private String parentId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @ListBuildItem(title = "排序", flag = FormFlag.Table)
    private Integer itemOrder;

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
}
