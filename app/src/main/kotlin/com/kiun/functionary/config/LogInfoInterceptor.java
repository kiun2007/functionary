package com.kiun.functionary.config;

import com.kiun.functionary.context.AppContext;
import com.kiun.functionary.dao.sys.entity.SysUser;
import com.kiun.functionary.utils.ObjectUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.Connection;
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
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class LogInfoInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        return null;
    }

    @Override
    public Object plugin(Object target) {
        // 只对要拦截制定类型的对象生成代理
//        if(target instanceof Executor){
//            // 调用插件
        return Plugin.wrap(target, this);
//        }
//        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        int a = 0;
    }
}
