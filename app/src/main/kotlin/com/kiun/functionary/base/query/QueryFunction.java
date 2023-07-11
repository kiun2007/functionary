package com.kiun.functionary.base.query;

import com.kiun.functionary.base.BaseCriteria;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * 字段查询方式转换基础类
 */
public abstract class QueryFunction<E extends Object> {

	protected E fieldValue;

	protected String fieldName;

	public final void fieldValue(E fieldValue) {
		this.fieldValue = fieldValue;
	}

	public final void fieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public QueryFunction(String setting) {

		if (!StringUtils.isEmpty(setting)){
			String[] settings = setting.split(";");

			for (String item: settings){
				String[] keyValue = item.split("=");
				try {
					Field field = this.getClass().getDeclaredField(keyValue[0]);
					field.setAccessible(true);

					if(Number.class.isAssignableFrom(field.getType())){
						Double value = Double.parseDouble(keyValue[1]);
						if(field.getType().equals(Integer.class)){
							field.set(this, value.intValue());
						}else if (field.getType().equals(Long.class)){
							field.set(this, value.longValue());
						}else if (field.getType().equals(Float.class)){
							field.set(this, value.floatValue());
						}else if (field.getType().equals(Double.class)){
							field.set(this, value);
						}else if (field.getType().equals(Short.class)){
							field.set(this, value.shortValue());
						}else if (field.getType().equals(Byte.class)){
							field.set(this, value.byteValue());
						}
					}else if (String.class.equals(field.getType())){
						field.set(this, keyValue[1]);
					}
				} catch (NoSuchFieldException | IllegalAccessException|NumberFormatException ignored) {
				}
			}
		}
	}

	public abstract void convert(BaseCriteria criteria);

	public abstract boolean isDelete();
}
