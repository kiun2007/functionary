package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 *  机构
 * 
 * sys_organ
 *
 * 2023-07-10 20:55:36
 */
@ApiModel(description=" 机构")
public class SysOrgan extends IdRandom {
    /**
     * 机构id
     */
    @ApiModelProperty("机构id")
    private String organId;

    /**
     * 机构名
     */
    @ApiModelProperty("机构名")
    private String organName;

    /**
     * 级别
     */
    @ApiModelProperty("级别")
    private Integer levelNo;

    /**
     * 父机构id
     */
    @ApiModelProperty("父机构id")
    private String parentId;

    /**
     * 机构地址
     */
    @ApiModelProperty("机构地址")
    private String address;

    /**
     */
    @ApiModelProperty("")
    private String cuntryName;

    /**
     * 邮编
     */
    @ApiModelProperty("邮编")
    private String postNo;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phoneNo;

    /**
     * 传真
     */
    @ApiModelProperty("传真")
    private String faxNo;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createrId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createDate;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateId;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateDate;

    /**
     * 机构类型 1-总行 2-分行 3-网点
     */
    @ApiModelProperty("机构类型 1-总行 2-分行 3-网点")
    private String organType;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public Integer getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Integer levelNo) {
        this.levelNo = levelNo;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCuntryName() {
        return cuntryName;
    }

    public void setCuntryName(String cuntryName) {
        this.cuntryName = cuntryName == null ? null : cuntryName.trim();
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo == null ? null : postNo.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo == null ? null : faxNo.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType == null ? null : organType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organ
     * 2023-07-10 20:55:36
     */
    public void setId(String id) {
        this.organId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organ
     * 2023-07-10 20:55:36
     */
    public String getId() {
        return organId;
    }
}