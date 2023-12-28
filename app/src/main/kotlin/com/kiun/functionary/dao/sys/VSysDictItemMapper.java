package com.kiun.functionary.dao.sys;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.sys.entity.VSysDictItem;
import com.kiun.functionary.dao.sys.entity.VSysDictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VSysDictItemMapper extends com.kiun.functionary.base.BaseExampleMapper<VSysDictItemExample, VSysDictItem> {
    List<VSysDictItem> selectById(String id);

    List<VSysDictItem> selectByDictId(String dictId);

    List<VSysDictItem> selectByDictName(String dictName);

    List<VSysDictItem> selectByItemKey(String itemKey);

    List<VSysDictItem> selectByParentId(String parentId);

    List<VSysDictItem> selectByItemVal(String itemVal);

    List<VSysDictItem> selectByItemOrder(Integer itemOrder);

    List<VSysDictItem> selectByAddUserId(String addUserId);

    List<VSysDictItem> selectByAddUserNm(String addUserNm);

    List<VSysDictItem> selectByAddTime(java.util.Date addTime);

    List<VSysDictItem> selectByUpdUserId(String updUserId);

    List<VSysDictItem> selectByUpdUserNm(String updUserNm);

    List<VSysDictItem> selectByUpdTime(java.util.Date updTime);

    List<VSysDictItem> selectByUpdTerminalIp(String updTerminalIp);

    List<VSysDictItem> selectByChildCount(Long childCount);
}