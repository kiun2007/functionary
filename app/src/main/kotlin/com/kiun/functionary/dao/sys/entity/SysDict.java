package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 字典项
 *
 * sys_dict
 *
 * 2023-07-24 23:20:49
 */
@ApiModel(description="字典项")
@ListBuild(value = "SysDict", title = "字典项")
public class SysDict extends IdRandom {
    /**
     * 字典ID
     */
    @ApiModelProperty("字典ID")
    @ListBuildItem(title = "字典ID", addWith = false, editWith = false)
    private String dictId;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    @ListBuildItem(title = "字典名称")
    private String dictName;

    /**
     * 父字典
     */
    @ApiModelProperty("父字典")
    @ListBuildItem(title = "父字典")
    private String groupDict;

    /**
     * 添加用户ID
     */
    @ApiModelProperty("添加用户ID")
    private String addUserId;

    /**
     * 添加用户名称
     */
    @ApiModelProperty("添加用户名称")
    @ListBuildItem(title = "添加用户", addWith = false, editWith = false)
    private String addUserMn;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间", addWith = false, editWith = false)
    private Date addTime;

    /**
     * 修改用户ID
     */
    @ApiModelProperty("修改用户ID")
    private String updUserId;

    /**
     * 修改用户名称
     */
    @ApiModelProperty("修改用户名称")
    @ListBuildItem(title = "修改用户", addWith = false, editWith = false)
    private String updUserMn;

    /**
     * 修改用户时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间", addWith = false, editWith = false)
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
    private String updTerminalIp;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getGroupDict() {
        return groupDict;
    }

    public void setGroupDict(String groupDict) {
        this.groupDict = groupDict == null ? null : groupDict.trim();
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId == null ? null : addUserId.trim();
    }

    public String getAddUserMn() {
        return addUserMn;
    }

    public void setAddUserMn(String addUserMn) {
        this.addUserMn = addUserMn == null ? null : addUserMn.trim();
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

    public String getUpdUserMn() {
        return updUserMn;
    }

    public void setUpdUserMn(String updUserMn) {
        this.updUserMn = updUserMn == null ? null : updUserMn.trim();
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
     * This method corresponds to the database table sys_dict
     * 2023-07-24 23:20:49
     */
    public void setId(String id) {
        this.dictId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dict
     * 2023-07-24 23:20:49
     */
    public String getId() {
        return dictId;
    }
}
