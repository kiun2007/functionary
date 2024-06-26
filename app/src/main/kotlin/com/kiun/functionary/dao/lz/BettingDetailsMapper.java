package com.kiun.functionary.dao.lz;

import com.kiun.functionary.base.BaseExampleMapper;
import com.kiun.functionary.dao.lz.entity.BettingDetails;
import com.kiun.functionary.dao.lz.entity.BettingDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BettingDetailsMapper extends com.kiun.functionary.base.BaseExampleMapper<BettingDetailsExample, BettingDetails> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_betting_details
     * 2024-05-26 11:13:22
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lz_betting_details
     * 2024-05-26 11:13:22
     */
    BettingDetails selectByPrimaryKey(String id);

    List<BettingDetails> selectById(String id);

    List<BettingDetails> selectByHeadId(String headId);

    List<BettingDetails> selectByUserId(String userId);

    List<BettingDetails> selectByAddTime(java.util.Date addTime);

    List<BettingDetails> selectByBettingValue(String bettingValue);
}