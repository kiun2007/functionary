package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VUserCollect;
import com.kiun.functionary.dao.gks.entity.VUserCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VUserCollectMapper extends com.kiun.functionary.base.BaseExampleMapper<VUserCollectExample, VUserCollect> {
    List<VUserCollect> selectById(String id);

    List<VUserCollect> selectByViewId(String viewId);

    List<VUserCollect> selectByViewType(String viewType);

    List<VUserCollect> selectByUserId(String userId);

    List<VUserCollect> selectByAddTime(java.util.Date addTime);

    List<VUserCollect> selectByAddUserId(String addUserId);

    List<VUserCollect> selectByTitle(String title);
}