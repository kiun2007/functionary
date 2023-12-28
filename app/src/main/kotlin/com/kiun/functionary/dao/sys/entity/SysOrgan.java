package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 *  机构单位
 *
 * sys_organ
 *
 * 2023-11-12 12:45:59
 */
@ApiModel(description="机构单位")
@ListBuild(value = "SysOrgan", title = "机构单位", operate = {
        @Operate(title = "添加", url = "/general/add/@{formId}", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/SysOrgan?organId={organId}"),
        @Operate(title = "删除", url = "/general/delete", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class SysOrgan extends IdRandom {

    /**
     * 机构id
     */
    @ApiModelProperty("机构id")
    @ListBuildItem(title = "主键", flag = FormFlag.Non)
    private String organId;

    /**
     * 机构名
     */
    @ApiModelProperty("机构名")
    @ListBuildItem(title = "机构名")
    private String organName;

    /**
     * 机构类型
     */
    @ApiModelProperty("机构类型")
    private String organType;

    /**
     * 父机构id
     */
    @ApiModelProperty("父机构id")
    @ListBuildItem(title = "所属机构", flag = FormFlag.Table | FormFlag.Search)
    private String parentId;

    /**
     * 机构地址
     */
    @ApiModelProperty("机构地址")
    @ListBuildItem(title = "机构地址", flag = FormFlag.Add)
    private String address;

    /**
     * 邮编
     */
    @ApiModelProperty("邮编")
    @ListBuildItem(title = "邮编", flag = FormFlag.Add)
    private String postNo;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @ListBuildItem(title = "手机号", flag = FormFlag.Add)
    private String phoneNo;

    /**
     * 传真
     */
    @ApiModelProperty("传真")
    @ListBuildItem(title = "传真", flag = FormFlag.Add)
    private String faxNo;

    /**
     * 区域编码
     */
    @ApiModelProperty("区域编码")
    @ListBuildItem(title = "所属地区", type = FormType.Select, selectOpt = @Select(
            label = "rangId",
            formLabel = "itemVal",
            formValue = "itemKey",
            url = "/general/select-tree/VSysDictItemTree?dictId=gks_region&parentCode=parentId&code=id")
    )
    private String rangCd;

    /**
     * 区域标识
     */
    @ApiModelProperty("区域标识")
    private String rangId;

    /**
     * 区域名称
     */
    @ApiModelProperty("区域名称")
    private String rangName;

    public String getRangName() {
        return rangName;
    }

    public void setRangName(String rangName) {
        this.rangName = rangName;
    }

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    private String addUserId;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    private Date addTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private String updUserId;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updTime;

    /**
     * 终端IP
     */
    @ApiModelProperty("终端IP")
    private String updTerminalIp;

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

    public String getOrganType() {
        return organType;
    }

    public void setOrganType(String organType) {
        this.organType = organType == null ? null : organType.trim();
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

    public String getRangCd() {
        return rangCd;
    }

    public void setRangCd(String rangCd) {
        this.rangCd = rangCd == null ? null : rangCd.trim();
    }

    public String getRangId() {
        return rangId;
    }

    public void setRangId(String rangId) {
        this.rangId = rangId == null ? null : rangId.trim();
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
     * This method corresponds to the database table sys_organ
     * 2023-08-02 21:27:48
     */
    public void setId(String id) {
        this.organId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organ
     * 2023-08-02 21:27:48
     */
    public String getId() {
        return organId;
    }
}
