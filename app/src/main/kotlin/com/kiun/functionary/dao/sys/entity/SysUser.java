package com.kiun.functionary.dao.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 后台用户表
 *
 * sys_user
 *
 * 2023-07-09 23:03:19
 */
@ApiModel(description="后台用户表")
public class SysUser implements UserDetails {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 登陆名
     */
    @ApiModelProperty("登陆名")
    private String loginName;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String loginPwd;

    /**
     * 密码盐
     */
    @ApiModelProperty("密码盐")
    private String salt;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     */
    @ApiModelProperty("")
    private String modifyLoginPwd;

    /**
     * 密码错误次数
     */
    @ApiModelProperty("密码错误次数")
    private Integer failedLoginNum;

    /**
     * 最多尝试次数
     */
    @ApiModelProperty("最多尝试次数")
    private Integer maxLoginNum;

    /**
     * 密码过期日
     */
    @ApiModelProperty("密码过期日")
    private Integer pwdExpiryDay;

    /**
     * 上次密码修改日期
     */
    @ApiModelProperty("上次密码修改日期")
    private String lastPwdUpdateDate;

    /**
     * 上次密码修改时间
     */
    @ApiModelProperty("上次密码修改时间")
    private String lastPwdUpdateTime;

    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String userType;

    /**
     * 用户状态
     */
    @ApiModelProperty("用户状态")
    private String status;

    /**
     * 重复登录标识
     */
    @ApiModelProperty("重复登录标识")
    private String repeatLoginFlag;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobileNo;

    /**
     * 家庭地址
     */
    @ApiModelProperty("家庭地址")
    private String homeNo;

    /**
     * 工作地址
     */
    @ApiModelProperty("工作地址")
    private String officeNo;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createrId;

    /**
     * 创建日期
     */
    @ApiModelProperty("创建日期")
    private String createDate;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateId;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private String updateDate;

    /**
     * 机构
     */
    @ApiModelProperty("机构")
    private String ownerOrgan;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private String updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getModifyLoginPwd() {
        return modifyLoginPwd;
    }

    public void setModifyLoginPwd(String modifyLoginPwd) {
        this.modifyLoginPwd = modifyLoginPwd == null ? null : modifyLoginPwd.trim();
    }

    public Integer getFailedLoginNum() {
        return failedLoginNum;
    }

    public void setFailedLoginNum(Integer failedLoginNum) {
        this.failedLoginNum = failedLoginNum;
    }

    public Integer getMaxLoginNum() {
        return maxLoginNum;
    }

    public void setMaxLoginNum(Integer maxLoginNum) {
        this.maxLoginNum = maxLoginNum;
    }

    public Integer getPwdExpiryDay() {
        return pwdExpiryDay;
    }

    public void setPwdExpiryDay(Integer pwdExpiryDay) {
        this.pwdExpiryDay = pwdExpiryDay;
    }

    public String getLastPwdUpdateDate() {
        return lastPwdUpdateDate;
    }

    public void setLastPwdUpdateDate(String lastPwdUpdateDate) {
        this.lastPwdUpdateDate = lastPwdUpdateDate == null ? null : lastPwdUpdateDate.trim();
    }

    public String getLastPwdUpdateTime() {
        return lastPwdUpdateTime;
    }

    public void setLastPwdUpdateTime(String lastPwdUpdateTime) {
        this.lastPwdUpdateTime = lastPwdUpdateTime == null ? null : lastPwdUpdateTime.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRepeatLoginFlag() {
        return repeatLoginFlag;
    }

    public void setRepeatLoginFlag(String repeatLoginFlag) {
        this.repeatLoginFlag = repeatLoginFlag == null ? null : repeatLoginFlag.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo == null ? null : homeNo.trim();
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo == null ? null : officeNo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    public String getOwnerOrgan() {
        return ownerOrgan;
    }

    public void setOwnerOrgan(String ownerOrgan) {
        this.ownerOrgan = ownerOrgan == null ? null : ownerOrgan.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     * 2023-07-09 23:03:19
     */
    public void setId(String id) {
        this.userId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     * 2023-07-09 23:03:19
     */
    public String getId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return loginPwd;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
