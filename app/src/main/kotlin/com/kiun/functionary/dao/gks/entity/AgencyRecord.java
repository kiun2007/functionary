package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.base.general.UserId;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 *
 * 访问记录
 *
 * gks_agency_record
 *
 * 2023-12-27 14:36:59
 */
@ApiModel(description="访问记录")
@ListBuild(value = "AgencyRecord", title = "访问记录")
public class AgencyRecord {
    /**
     * 机构ID
     */
    @ApiModelProperty("机构ID")
    @ListBuildItem(title = "机构ID")
    private String agencyId;

    /**
     * 访问人员ID
     */
    @ApiModelProperty("访问人员ID")
    @ListBuildItem(title = "访问人员ID")
    @UserId
    private String userId;

    /**
     * 机构名称
     */
    @ApiModelProperty("机构名称")
    @ListBuildItem(title = "机构名称")
    private String agencyName;

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

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId == null ? null : agencyId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName == null ? null : agencyName.trim();
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
