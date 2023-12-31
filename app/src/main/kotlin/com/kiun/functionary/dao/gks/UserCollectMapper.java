package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.UserCollect;
import com.kiun.functionary.dao.gks.entity.UserCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectMapper extends com.kiun.functionary.base.BaseExampleMapper<UserCollectExample, UserCollect> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_user_collect
     * 2023-08-30 21:33:43
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gks_user_collect
     * 2023-08-30 21:33:43
     */
    UserCollect selectByPrimaryKey(String id);

    List<UserCollect> selectById(String id);

    List<UserCollect> selectByUserId(String userId);

    List<UserCollect> selectByViewId(String viewId);

    List<UserCollect> selectByViewType(String viewType);

    List<UserCollect> selectByAddUserId(String addUserId);

    List<UserCollect> selectByAddUserNm(String addUserNm);

    List<UserCollect> selectByAddTime(java.util.Date addTime);

    List<UserCollect> selectByUpdUserId(String updUserId);

    List<UserCollect> selectByUpdUserNm(String updUserNm);

    List<UserCollect> selectByUpdTime(java.util.Date updTime);

    List<UserCollect> selectByUpdTerminalIp(String updTerminalIp);
}