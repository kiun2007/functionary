package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VJobNoticeSelect;
import com.kiun.functionary.dao.gks.entity.VJobNoticeSelectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VJobNoticeSelectMapper extends com.kiun.functionary.base.BaseExampleMapper<VJobNoticeSelectExample, VJobNoticeSelect> {
    List<VJobNoticeSelect> selectById(String id);

    List<VJobNoticeSelect> selectByTitle(String title);

    List<VJobNoticeSelect> selectByPublishTime(java.util.Date publishTime);

    List<VJobNoticeSelect> selectByTypeName(String typeName);

    List<VJobNoticeSelect> selectByRangName(String rangName);

    List<VJobNoticeSelect> selectByInputType(String inputType);
}