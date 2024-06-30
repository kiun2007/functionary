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
 * v_job_notice_select
 *
 * 2024-05-26 09:49:31
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VJobNoticeSelect", title = "VIEW")
public class VJobNoticeSelect extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键")
    private String id;

    /**
     * 招聘标题
     */
    @ApiModelProperty("招聘标题")
    @ListBuildItem(title = "招聘标题")
    private String title;

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    @ListBuildItem(title = "发布时间")
    private Date publishTime;

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    @ListBuildItem(title = "字典值")
    private String typeName;

    /**
     * 区域名称
     */
    @ApiModelProperty("区域名称")
    @ListBuildItem(title = "区域名称")
    private String rangName;

    /**
     * 输入类型
     */
    @ApiModelProperty("输入类型")
    @ListBuildItem(title = "输入类型")
    private String inputType;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getRangName() {
        return rangName;
    }

    public void setRangName(String rangName) {
        this.rangName = rangName == null ? null : rangName.trim();
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }
}