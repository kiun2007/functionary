package com.kiun.functionary.base.anno;

import com.kiun.functionary.base.query.QueryFunction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseQuery {

	/**
	 * 使用的查询转换方法.
	 * @return {@link QueryFunction}
	 */
	Class<? extends QueryFunction<?>> value();

	/**
	 * 构造设置参数.
	 * @return 参数内容
	 */
	String setting() default "";
}
