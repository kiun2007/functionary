package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import static com.kiun.functionary.base.general.FormFlag.*;

/**
 *
 * gks_plan_column
 *
 * 2023-11-13 09:15:20
 */
@ApiModel(description="")
@ListBuild(value = "ImportPlanColumn", title = "列信息", operate = {
        @Operate(title = "添加", url = "/general/add/ImportPlanColumn?planId={planId}", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/ImportPlanColumn?id={id}&planId={planId}"),
        @Operate(title = "删除", url = "/api/general/@{formId}/remove?id={id}", function = "removeUrl", color = ButtonColor.Danger, icon = "fa-remove")
})
public class ImportPlanColumn extends IdRandom {


    /**
     * 编号
     */
    @ApiModelProperty("编号")
    @ListBuildItem(title = "编号", flag = Edit | EditDisable, type = FormType.Hidden)
    private String id;

    /**
     * 导入方案ID
     */
    @ApiModelProperty("导入方案ID")
    @ListBuildItem(title = "导入方案ID", flag = Update|Search, type = FormType.Hidden)
    private String planId;

    /**
     * 列索引
     */
    @ApiModelProperty("列索引")
    @ListBuildItem(title = "列索引")
    private Integer columnIndex;

    /**
     * 列原标题
     */
    @ApiModelProperty("列原标题")
    @ListBuildItem(title = "列原标题")
    private String columnField;

    /**
     * 列标题
     */
    @ApiModelProperty("列标题")
    @ListBuildItem(title = "列标题", type = FormType.Enum, enums = {
            "年龄要求", "年龄要求",
            "专业要求", "专业要求",
            "备注", "备注",
            "职位名称", "职位名称",
            "联系电话", "联系电话",
            "户籍地", "户籍地",
            "基层工作经验", "基层工作经验",
            "学位要求", "学位要求",
            "学历要求", "学历要求",
            "性别要求", "性别要求",
            "政治面貌", "政治面貌",
            "工作单位", "工作单位",
            "职位介绍", "职位介绍",
            "区域", "区域",
            "recruitNum", "招聘人数",
    })
    private String columnTitle;

    /**
     * 列格式
     */
    @ApiModelProperty("列格式")
    @ListBuildItem(title = "列格式")
    private String columnFormat;

    /**
     */
    @ApiModelProperty("")
    private String addUserId;

    /**
     */
    @ApiModelProperty("")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    private Date addTime;

    /**
     */
    @ApiModelProperty("")
    private String updUserId;

    /**
     */
    @ApiModelProperty("")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updTime;

    /**
     */
    @ApiModelProperty("")
    private String updTerminalIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(Integer columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle == null ? null : columnTitle.trim();
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

    public String getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(String columnFormat) {
        this.columnFormat = columnFormat == null ? null : columnFormat.trim();
    }

    public String getColumnField() {
        return columnField;
    }

    public void setColumnField(String columnField) {
        this.columnField = columnField;
    }
}
