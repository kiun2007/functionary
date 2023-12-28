package com.kiun.functionary.dao.gks.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位需求列表
 *
 * gks_job_must
 *
 * 2023-10-11 08:32:41
 */
@ApiModel(description="岗位需求列表")
@ListBuild(value = "JobMust", title = "岗位需求列表")
public class JobMust {
    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    @ListBuildItem(title = "岗位ID")
    private String jobId;

    /**
     * 要求字典ID
     */
    @ApiModelProperty("要求字典ID")
    @ListBuildItem(title = "要求字典ID")
    private String dictItemId;

    /**
     * 公告ID
     */
    @ApiModelProperty("公告ID")
    @ListBuildItem(title = "公告ID")
    private String noticeId;

    /**
     * 要求字典Key
     */
    @ApiModelProperty("要求字典Key")
    @ListBuildItem(title = "要求字典Key")
    private String dictItemKey;

    /**
     * 要求字典显示值
     */
    @ApiModelProperty("要求字典显示值")
    @ListBuildItem(title = "要求字典显示值")
    private String dictItemValue;

    /**
     * 岗位要求字典项
     */
    @ApiModelProperty("岗位要求字典项")
    @ListBuildItem(title = "岗位要求字典项")
    private String dictId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getDictItemId() {
        return dictItemId;
    }

    public void setDictItemId(String dictItemId) {
        this.dictItemId = dictItemId == null ? null : dictItemId.trim();
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public String getDictItemKey() {
        return dictItemKey;
    }

    public void setDictItemKey(String dictItemKey) {
        this.dictItemKey = dictItemKey == null ? null : dictItemKey.trim();
    }

    public String getDictItemValue() {
        return dictItemValue;
    }

    public void setDictItemValue(String dictItemValue) {
        this.dictItemValue = dictItemValue == null ? null : dictItemValue.trim();
    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }
}
