package com.kiun.functionary.dao.gks;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.gks.entity.VJobNotice;
import com.kiun.functionary.dao.gks.entity.VJobNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VJobNoticeMapper extends com.kiun.functionary.base.BaseExampleMapper<VJobNoticeExample, VJobNotice> {
    List<VJobNotice> selectById(String id);

    List<VJobNotice> selectByTitle(String title);

    List<VJobNotice> selectByPublishTime(java.util.Date publishTime);

    List<VJobNotice> selectByOrganId(String organId);

    List<VJobNotice> selectByOrganName(String organName);

    List<VJobNotice> selectByInfoUrl(String infoUrl);

    List<VJobNotice> selectByJobUrl(String jobUrl);

    List<VJobNotice> selectByDetailUrl(String detailUrl);

    List<VJobNotice> selectByAddUserId(String addUserId);

    List<VJobNotice> selectByAddUserNm(String addUserNm);

    List<VJobNotice> selectByAddTime(java.util.Date addTime);

    List<VJobNotice> selectByUpdUserId(String updUserId);

    List<VJobNotice> selectByUpdUserNm(String updUserNm);

    List<VJobNotice> selectByUpdTime(java.util.Date updTime);

    List<VJobNotice> selectByUpdTerminalIp(String updTerminalIp);
}