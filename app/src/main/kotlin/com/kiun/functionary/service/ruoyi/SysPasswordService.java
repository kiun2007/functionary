package com.kiun.functionary.service.ruoyi;

import java.util.concurrent.atomic.AtomicInteger;

import com.kiun.functionary.dao.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
 * 登录密码方法
 *
 * @author ruoyi
 */
@Component
public class SysPasswordService
{
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void validate(SysUser user, String password)
    {
        if (!matches(user, password))
        {
            throw new RuntimeException("密码错误");
        }
    }

    public boolean matches(SysUser user, String newPassword)
    {
        return passwordEncoder.matches(newPassword, user.getLoginPwd());
//        return user.getLoginPwd().equals(encryptPassword(user.getLoginName(), newPassword));
    }

    public String encryptPassword(String username, String password)
    {
        return passwordEncoder.encode(password);
    }
}
