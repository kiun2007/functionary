package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.FormFlag;
import com.kiun.functionary.base.general.FormType;
import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.ss.usermodel.Table;

import java.util.Date;

/**
 * VIEW
 *
 * v_job_notice_select
 *
 * 2024-01-20 15:54:48
 */
@ApiModel(description="VIEW")
@ListBuild(value = "VJobNoticeSelect", title = "公告选择", operate = {})
public class VJobNoticeSelect extends IdRandom {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = FormFlag.Edit|FormFlag.EditDisable, type = FormType.Hidden)
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
    @ListBuildItem(title = "发布时间", flag = FormFlag.Table)
    private Date publishTime;

    /**
     * 字典值
     */
    @ApiModelProperty("字典值")
    @ListBuildItem(title = "考试类型", flag = FormFlag.Table)
    private String typeName;

    /**
     * 区域名称
     */
    @ApiModelProperty("区域名称")
    @ListBuildItem(title = "考试区域")
    private String rangName;

    /**
     * 输入类型
     */
    @ApiModelProperty("输入类型")
    @ListBuildItem(title = "录入类型", type = FormType.Enum, enums = {"0", "自动导入/爬虫", "1", "手动录入"})
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
