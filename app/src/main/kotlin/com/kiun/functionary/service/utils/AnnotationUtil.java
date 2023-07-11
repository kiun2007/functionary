package com.kiun.functionary.service.utils;

import com.kiun.functionary.dao.BaseExample;
import kotlin.jvm.functions.Function2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.lang.annotation.Annotation;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnnotationUtil {

    /**
     * 循环搜索指定注解类型与注解
     * @param annotationType 注解类型
     * @param searchPage 搜索包列表
     * @param call 回调
     * @param <T>
     */
    public static <T extends Annotation> void foreach(Class<T> annotationType, List<String> searchPage, Function2<T, Class<?>, Boolean> call){

        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(annotationType));
        List<BeanDefinition> candidates = new LinkedList<>();
        searchPage.forEach(item-> {
            candidates.addAll(provider.findCandidateComponents(item));
        });

        for (BeanDefinition definition : candidates){
            try {
                Class clz = Class.forName(definition.getBeanClassName());
                T annotation = (T) clz.getAnnotation(annotationType);

                if(!call.invoke(annotation, clz)){
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Class<?>> getChildClass(Class<?> clz, List<String> searchPage){

        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(clz));
        List<BeanDefinition> candidates = new LinkedList<>();

        if (searchPage == null || searchPage.isEmpty()){
            candidates.addAll(provider.findCandidateComponents("**"));
        }else{
            searchPage.forEach(item-> {
                candidates.addAll(provider.findCandidateComponents(item));
            });
        }

        Class<? extends BaseExample> clz1 = null;

        return candidates.stream().map(item-> {
            try {
                return Class.forName(item.getBeanClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
