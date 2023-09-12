package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * VIEW
 * 
 * v_gks_job_notice_details
 *
 * 2023-08-16 13:15:32
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VJobNoticeDetails", title = "VIEW")
public class VJobNoticeDetails extends IdRandom {
    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String id;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String title;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Date publishTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Date endTime;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String organId;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String organName;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private BigDecimal jobCount;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private Long count;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String details;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String infoUrl;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String jobUrl;

    /**
     */
    @ApiModelProperty("")
    @ListBuildItem(title = "")
    private String detailUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public BigDecimal getJobCount() {
        return jobCount;
    }

    public void setJobCount(BigDecimal jobCount) {
        this.jobCount = jobCount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl == null ? null : infoUrl.trim();
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl == null ? null : jobUrl.trim();
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
    }
}