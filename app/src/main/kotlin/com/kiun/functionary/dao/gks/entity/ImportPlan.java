package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.*;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import static com.kiun.functionary.base.general.FormFlag.Table;

/**
 *
 * gks_import_plan
 *
 * 2023-11-11 21:57:49
 */
@ApiModel(description="")
@ListBuild(value = "ImportPlan", title = "导入方案", operate = {
        @Operate(title = "删除", function = "removeAll", color = ButtonColor.Danger, icon = "fa-remove", toolbar = true),
        @Operate(title = "添加", url = "/general/add/@{formId}", icon = "fa-plus", toolbar = true),
        @Operate(title = "编辑", url = "/general/edit/ImportPlan?id={id}"),
        @Operate(title = "列属性", url = "/general/list/ImportPlanColumn?planId={id}"),
        @Operate(title = "删除", url = "remove", function = "remove", color = ButtonColor.Danger, icon = "fa-remove")
})
public class ImportPlan extends IdRandom {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @ListBuildItem(title = "主键", flag = Table)
    private String id;

    /**
     * 方案标题
     */
    @ApiModelProperty("方案标题")
    @ListBuildItem(title = "方案标题")
    private String title;

    /**
     * 头部行号
     */
    @ApiModelProperty("头部行号")
    @ListBuildItem(title = "头部行号")
    private Integer headIndex;

    /**
     * 分页字段
     */
    @ApiModelProperty("分页字段")
    @ListBuildItem(title = "分页字段", type = FormType.Enum, enums = {
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
    private String sheetField;

    /**
     * 方案描述
     */
    @ApiModelProperty("方案描述")
    @ListBuildItem(title = "方案描述")
    private String planDesc;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getHeadIndex() {
        return headIndex;
    }

    public void setHeadIndex(Integer headIndex) {
        this.headIndex = headIndex;
    }

    public String getSheetField() {
        return sheetField;
    }

    public void setSheetField(String sheetField) {
        this.sheetField = sheetField == null ? null : sheetField.trim();
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc == null ? null : planDesc.trim();
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
