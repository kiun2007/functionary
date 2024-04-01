package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.base.general.UserId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * VIEW
 *
 * v_agency_record
 *
 * 2024-01-14 22:36:05
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VAgencyRecord", title = "访问记录", operate = {})
public class VAgencyRecord1 {

    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    private String agencyId;

    /**
     * 机构名称
     */
    @ApiModelProperty("机构名称")
    private String agencyName;

    /**
     * 访问人员ID
     */
    @ApiModelProperty("访问人员ID")
    private String userId;

    /**
     * 机构名称
     */
    @ApiModelProperty("机构名称")
    private String name;

    /**
     * 管理员ID
     */
    @ApiModelProperty("管理员ID")
    @UserId
    private String admin;

    /**
     * 机构简称标题
     */
    @ApiModelProperty("机构简称标题")
    private String title;


    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @ListBuildItem(title = "用户名")
    private String userName;

    /**
     * 登陆名
     */
    @ApiModelProperty("登陆名")
    @ListBuildItem(title = "手机号")
    private String loginName;



    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobileNo;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "最后访问时间")
    private Date updTime;

    /**
     */
    @ApiModelProperty("学历")
    @ListBuildItem(title = "学历")
    private String education;

    /**
     */
    @ApiModelProperty("专业")
    @ListBuildItem(title = "专业")
    private String speciality;

    /**
     */
    @ApiModelProperty("政治面貌")
    @ListBuildItem(title = "政治面貌")
    private String political;

    /**
     */
    @ApiModelProperty("搜索类型")
    @ListBuildItem(title = "搜索类型")
    private String type;

    /**
     */
    @ApiModelProperty("搜索区域")
    @ListBuildItem(title = "搜索区域")
    private String region;

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId == null ? null : agencyId.trim();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }
}
