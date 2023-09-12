package com.kiun.functionary.dao.sys.entity;

import com.kiun.functionary.base.general.ListBuild;
import com.kiun.functionary.base.general.ListBuildItem;
import com.kiun.functionary.dao.IdRandom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 后台用户表
 *
 * sys_user
 *
 * 2023-09-05 22:13:52
 */
@ApiModel(description="后台用户表")
@ListBuild(value = "SysUser", title = "后台用户表")
public class SysUser extends IdRandom implements UserDetails {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @ListBuildItem(title = "用户id")
    private String userId;

    /**
     * 登陆名
     */
    @ApiModelProperty("登陆名")
    @ListBuildItem(title = "登陆名")
    private String loginName;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    @ListBuildItem(title = "登录密码")
    private String loginPwd;

    /**
     * 密码盐
     */
    @ApiModelProperty("密码盐")
    @ListBuildItem(title = "密码盐")
    private String salt;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @ListBuildItem(title = "用户名")
    private String userName;

    /**
     * 密码错误次数
     */
    @ApiModelProperty("密码错误次数")
    @ListBuildItem(title = "密码错误次数")
    private Integer failedLoginNum;

    /**
     * 最多尝试次数
     */
    @ApiModelProperty("最多尝试次数")
    @ListBuildItem(title = "最多尝试次数")
    private Integer maxLoginNum;

    /**
     * 密码过期日
     */
    @ApiModelProperty("密码过期日")
    @ListBuildItem(title = "密码过期日")
    private Integer pwdExpiryDay;

    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    @ListBuildItem(title = "用户类型")
    private String userType;

    /**
     * 用户状态
     */
    @ApiModelProperty("用户状态")
    @ListBuildItem(title = "用户状态")
    private String status;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    @ListBuildItem(title = "电子邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @ListBuildItem(title = "手机号")
    private String mobileNo;

    /**
     * 家庭地址
     */
    @ApiModelProperty("家庭地址")
    @ListBuildItem(title = "家庭地址")
    private String homeNo;

    /**
     * 工作地址
     */
    @ApiModelProperty("工作地址")
    @ListBuildItem(title = "工作地址")
    private String officeNo;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    @ListBuildItem(title = "地址")
    private String address;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @ListBuildItem(title = "备注")
    private String remark;

    /**
     * 添加用户
     */
    @ApiModelProperty("添加用户")
    @ListBuildItem(title = "添加用户")
    private String addUserId;

    /**
     * 添加用户名称
     */
    @ApiModelProperty("添加用户名称")
    @ListBuildItem(title = "添加用户名称")
    private String addUserNm;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @ListBuildItem(title = "添加时间")
    private Date addTime;

    /**
     * 修改用户
     */
    @ApiModelProperty("修改用户")
    @ListBuildItem(title = "修改用户")
    private String updUserId;

    /**
     * 修改用户名称
     */
    @ApiModelProperty("修改用户名称")
    @ListBuildItem(title = "修改用户名称")
    private String updUserNm;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @ListBuildItem(title = "修改时间")
    private Date updTime;

    /**
     * 修改数据人员IP
     */
    @ApiModelProperty("修改数据人员IP")
    @ListBuildItem(title = "修改数据人员IP")
    private String updTerminalIp;

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

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     * 2023-09-05 22:13:52
     */
    public void setId(String id) {
        this.userId=id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     * 2023-09-05 22:13:52
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
