package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典项详情
 * 
 * sys_dict_item
 *
 * 2023-07-10 17:23:50
 */
@ApiModel(description="字典项详情")
public class SysDictItem extends IdRandom {
    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    private String dictId;

    /**
     * 字典主键
     */
    @ApiModelProperty("字典主键")
    private String itemKey;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String id;

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    private String itemVal;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer itemOrder;

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