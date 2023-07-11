package com.kiun.functionary.context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.File;

@Component
public class AppContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    //========== PATH ==========
    public static String getClassRootPath() {
        return ClassUtils.getDefaultClassLoader().getResource("").getPath() + File.separator;
    }

    public static File getClassRoot() {
        return getSpace(getClassRootPath());
    }

    public static File getClassRoot(String name) {
        return getSpace(getClassRoot(), name + File.separator);
    }

    private static File getSpace(String name) {
        return getSpace(null, name);
    }

    private static File getSpace(File parent, String name) {
        File file = parent!=null ? new File(parent, name) : new File(name);
        if(!file.isDirectory()) {
            boolean r = file.mkdirs();
            if(!r) throw new RuntimeException(" create localspace:'"+file.getPath()+"' is wrong! ");
        }
        return file;
    }
}
