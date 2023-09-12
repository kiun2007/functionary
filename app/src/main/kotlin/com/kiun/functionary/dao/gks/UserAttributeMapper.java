package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.UserAttribute;
import com.kiun.functionary.dao.gks.entity.UserAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttributeMapper extends com.kiun.functionary.base.BaseExampleMapper<UserAttributeExample, UserAttribute> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_user_attribute
     * 2023-08-29 22:08:35
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_user_attribute
     * 2023-08-29 22:08:35
     */
    UserAttribute selectByPrimaryKey(String id);

    List<UserAttribute> selectById(String id);

    List<UserAttribute> selectByUserId(String userId);

    List<UserAttribute> selectByDictId(String dictId);

    List<UserAttribute> selectByDictItemId(String dictItemId);

    List<UserAttribute> selectByDictItemKey(String dictItemKey);

    List<UserAttribute> selectByParentItemId(String parentItemId);

    List<UserAttribute> selectByDictItemVal(String dictItemVal);

    List<UserAttribute> selectByTag(String tag);

    List<UserAttribute> selectByAddUserId(String addUserId);

    List<UserAttribute> selectByAddUserNm(String addUserNm);

    List<UserAttribute> selectByAddTime(java.util.Date addTime);

    List<UserAttribute> selectByUpdUserId(String updUserId);

    List<UserAttribute> selectByUpdUserNm(String updUserNm);

    List<UserAttribute> selectByUpdTime(java.util.Date updTime);

    List<UserAttribute> selectByUpdTerminalIp(String updTerminalIp);
}