package com.kiun.functionary.base.query;

import com.kiun.functionary.base.BaseCriteria;
import io.micrometer.common.util.StringUtils;

/**
 * 范围转换.
 */
public class RangeQuery extends QueryFunction<String>{

	/**
	 * 分割符号
	 */
	private String space;

	/**
	 * 需要删除的字符
	 */
	private String replace;

	/**
	 * 查询公式
	 */
	private String query;

	public RangeQuery(String setting) {
		super(setting);
	}

	@Override
	public void convert(BaseCriteria criteria) {
		if(!StringUtils.isNotBlank(fieldValue)){
			return;
		}

		String[] values = fieldValue.replace(replace, "").split(space);
		String field = StringUtils.isNotBlank(query) ? query : fieldName;
		criteria.addCriterion(field, values[0], values[1]);
	}

	@Override
	public boolean isDelete() {
		return true;
	}
}
