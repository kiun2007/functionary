package com.kiun.functionary.dao.gks;

import com.kiun.functionary.dao.gks.entity.JobDetails;
import com.kiun.functionary.dao.gks.entity.JobNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchNoticeMapper {

    /**
     * 根据用户定制搜索公告
     * @param userId 用户ID
     * @param searchType 搜索类型
     * @param type 考试类型
     * @param region 考试区域
     * @return 搜索结果
     */
    List<JobNotice> searchNoticeByUserId(
            @Param("userId") String userId,
            @Param("searchType") String searchType,
            @Param("type") String type,
            @Param("region") String region
    );

    List<JobDetails> searchDetailsByNoticeId(
            @Param("userId") String userId,
            @Param("noticeId") String noticeId
    );
}
