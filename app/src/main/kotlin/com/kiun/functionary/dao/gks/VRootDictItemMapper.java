package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VRootDictItem;
import com.kiun.functionary.dao.gks.entity.VRootDictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VRootDictItemMapper extends com.kiun.functionary.base.BaseExampleMapper<VRootDictItemExample, VRootDictItem> {
    List<VRootDictItem> selectById(String id);

    List<VRootDictItem> selectByDictId(String dictId);

    List<VRootDictItem> selectByDictName(String dictName);

    List<VRootDictItem> selectByItemKey(String itemKey);

    List<VRootDictItem> selectByItemKeyHead(String itemKeyHead);

    List<VRootDictItem> selectByParentId(String parentId);

    List<VRootDictItem> selectByItemVal(String itemVal);

    List<VRootDictItem> selectByItemOrder(Integer itemOrder);

    List<VRootDictItem> selectByAddUserId(String addUserId);

    List<VRootDictItem> selectByAddUserNm(String addUserNm);

    List<VRootDictItem> selectByAddTime(java.util.Date addTime);

    List<VRootDictItem> selectByUpdUserId(String updUserId);

    List<VRootDictItem> selectByUpdUserNm(String updUserNm);

    List<VRootDictItem> selectByUpdTime(java.util.Date updTime);

    List<VRootDictItem> selectByUpdTerminalIp(String updTerminalIp);
}