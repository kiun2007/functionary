package com.kiun.functionary.web.view;

import com.kiun.functionary.base.DataWrap;
import com.kiun.functionary.context.AppContext;
import com.kiun.functionary.dao.sys.SysUserMapper;
import com.kiun.functionary.dao.sys.entity.SysUser;
import com.kiun.functionary.service.ruoyi.SysPasswordService;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * 个人信息 业务处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController
{
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private String prefix = "system/user/profile";

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPasswordService passwordService;

    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(ModelMap mmap)
    {
//        SysUser user = ShiroUtils.getSysUser();
//        mmap.put("user", user);
//        mmap.put("roleGroup", userService.selectUserRoleGroup(user.getUserId()));
//        mmap.put("postGroup", userService.selectUserPostGroup(user.getUserId()));
        return "system/user/profile/profile";
    }

    @GetMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password)
    {
        SysUser user = sysUserMapper.selectByPrimaryKey(AppContext.currentUser().getId());
        if (passwordService.matches(user, password)) {
            return true;
        }
        return false;
    }

    @GetMapping("/resetPwd")
    public String resetPwd(ModelMap mmap)
    {
        SysUser user = AppContext.currentUser();
        mmap.put("user", sysUserMapper.selectByPrimaryKey(user.getUserId()));
        return "system/user/profile/resetPwd";
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public DataWrap<Boolean> resetPwd(String oldPassword, String newPassword)
    {
        SysUser user = AppContext.currentUser();
        if (StringUtils.isNotEmpty(newPassword) && passwordService.matches(sysUserMapper.selectByPrimaryKey(user.getUserId()), oldPassword))
        {
            user.setLoginPwd(passwordService.encryptPassword(user.getLoginName(), newPassword));
            if (sysUserMapper.updateByPrimaryKey(user) > 0)
            {
                return DataWrap.success(true);
            }
            return DataWrap.fail("修改密码失败");
        }
        else
        {
            return DataWrap.fail("修改密码失败，旧密码错误");
        }
    }

//    /**
//     * 修改用户
//     */
//    @GetMapping("/edit")
//    public String edit(ModelMap mmap)
//    {
//        SysUser user = ShiroUtils.getSysUser();
//        mmap.put("user", userService.selectUserById(user.getUserId()));
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改头像
//     */
//    @GetMapping("/avatar")
//    public String avatar(ModelMap mmap)
//    {
//        SysUser user = ShiroUtils.getSysUser();
//        mmap.put("user", userService.selectUserById(user.getUserId()));
//        return prefix + "/avatar";
//    }
//
//    /**
//     * 修改用户
//     */
//    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
//    @PostMapping("/update")
//    @ResponseBody
//    public AjaxResult update(SysUser user)
//    {
//        SysUser currentUser = ShiroUtils.getSysUser();
//        currentUser.setUserName(user.getUserName());
//        currentUser.setEmail(user.getEmail());
//        currentUser.setPhonenumber(user.getPhonenumber());
//        currentUser.setSex(user.getSex());
//        if (userService.updateUserInfo(currentUser) > 0)
//        {
//            ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
//            return success();
//        }
//        return error();
//    }
//
//    /**
//     * 保存头像
//     */
//    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
//    @PostMapping("/updateAvatar")
//    @ResponseBody
//    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file)
//    {
//        SysUser currentUser = ShiroUtils.getSysUser();
//        try
//        {
//            if (!file.isEmpty())
//            {
//                String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
//                currentUser.setAvatar(avatar);
//                if (userService.updateUserInfo(currentUser) > 0)
//                {
//                    ShiroUtils.setSysUser(userService.selectUserById(currentUser.getUserId()));
//                    return success();
//                }
//            }
//            return error();
//        }
//        catch (Exception e)
//        {
//            log.error("修改头像失败！", e);
//            return error(e.getMessage());
//        }
//    }
}
