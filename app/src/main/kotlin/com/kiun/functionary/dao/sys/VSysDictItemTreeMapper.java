package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.VSysDictItemTree;
import com.kiun.functionary.dao.sys.entity.VSysDictItemTreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VSysDictItemTreeMapper extends com.kiun.functionary.base.BaseExampleMapper<VSysDictItemTreeExample, VSysDictItemTree> {
    List<VSysDictItemTree> selectById(String id);

    List<VSysDictItemTree> selectByDictId(String dictId);

    List<VSysDictItemTree> selectByDictName(String dictName);

    List<VSysDictItemTree> selectByItemKey(String itemKey);

    List<VSysDictItemTree> selectByParentId(String parentId);

    List<VSysDictItemTree> selectByParentCd(String parentCd);

    List<VSysDictItemTree> selectByItemVal(String itemVal);

    List<VSysDictItemTree> selectByItemOrder(Integer itemOrder);
}