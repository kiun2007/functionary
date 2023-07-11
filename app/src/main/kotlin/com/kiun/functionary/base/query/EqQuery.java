package com.kiun.functionary.base.query;


import com.kiun.functionary.base.BaseCriteria;

public class EqQuery extends QueryFunction<String>{

	public EqQuery(String setting) {
		super(setting);
	}

	@Override
	public void convert(BaseCriteria criteria) {

	}

	@Override
	public boolean isDelete() {
		return false;
	}
}
