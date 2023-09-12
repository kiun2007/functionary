package com.kiun.functionary.config;

import com.kiun.functionary.context.AppContext;
import com.kiun.functionary.dao.sys.entity.SysUser;
import com.kiun.functionary.utils.ObjectUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * 公共参数填充
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
@Component
public class CommonInfoInterceptor implements Interceptor {

    private String getIp() {
        HttpServletRequest request = AppContext.getRequest();
        String ip = Stream.of("x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR")
                .map(item-> request.getHeader(item))
                .filter(item-> !(item == null || item.isEmpty() || "unknown".equalsIgnoreCase(item)))
                .findFirst()
                .orElse(null);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        HttpServletRequest request = AppContext.getRequest();
        Executor executor = (Executor) invocation.getTarget();
        Object[] args = invocation.getArgs();

        MappedStatement ms = (MappedStatement)args[0];
        Object parameter = args[1];
        String ip = getIp();

        SqlCommandType commandType = ms.getSqlCommandType();
        SysUser mUser = AppContext.currentUser();
        Object putTemplate = parameter;

        if (mUser != null && (commandType == SqlCommandType.INSERT || commandType == SqlCommandType.UPDATE)){

            if (commandType == SqlCommandType.INSERT){
                //创建日期
                ObjectUtil.setValue(putTemplate, "addTime", new Object[]{new Date(), LocalDate.now(), LocalTime.now(), LocalDateTime.now()});
                //创建用户ID
                ObjectUtil.setValue(putTemplate, "addUserId", mUser.getUserId());
                //创建用户名称
                ObjectUtil.setValue(putTemplate, "addUserNm", mUser.getUserName());
            }
            //终端IP
            ObjectUtil.setValue(putTemplate, "updTerminalIp", ip);
            //修改日期
            ObjectUtil.setValue(putTemplate, "updTime", new Object[]{new Date(), LocalDate.now(), LocalTime.now(), LocalDateTime.now()});
            //创建用户ID
            ObjectUtil.setValue(putTemplate, "updUserId", mUser.getUserId());
            //创建用户名称
            ObjectUtil.setValue(putTemplate, "updUserNm", mUser.getUserName());
        }
        return executor.update(ms, parameter);
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        int a = 0;
    }
}