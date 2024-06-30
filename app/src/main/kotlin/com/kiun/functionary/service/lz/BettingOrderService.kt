package com.kiun.functionary.service.lz

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.gks.entity.pay.ChooseWXPay
import com.kiun.functionary.dao.lz.BettingDetailsMapper
import com.kiun.functionary.dao.lz.BettingHeadMapper
import com.kiun.functionary.dao.lz.BettingPayMapper
import com.kiun.functionary.dao.lz.entity.BettingCreate
import com.kiun.functionary.dao.lz.entity.BettingDetails
import com.kiun.functionary.dao.lz.entity.BettingHead
import com.kiun.functionary.dao.lz.entity.BettingHeadExample
import com.kiun.functionary.dao.lz.entity.BettingPay
import com.kiun.functionary.utils.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Date
import java.util.LinkedList

@Service
class BettingOrderService {

    @Autowired
    var bettingDetailsMapper: BettingDetailsMapper? = null

    @Autowired
    var bettingHeadMapper: BettingHeadMapper? = null

    @Autowired
    var bettingPayMapper: BettingPayMapper? = null

    /**
     * 下注订单创建
     */
    @Transactional(rollbackFor = [Exception::class])
    fun create(req: BettingCreate) : DataWrap<ChooseWXPay> {

        //当前登录用户
        val userId = AppContext.currentUser().userId

        //查询当前用户当天投注数,未支付的不算
        val countExample = BettingHeadExample()
        countExample
            .createCriteria()
            .andUserIdEqualTo(userId)
            .andBettingTimeBetween(Date().firstSecond(), Date().firstSecond() + DateSpan(1, SpanType.Day))
            .andStateEqualTo("1")

        val todayBettingCount = bettingHeadMapper?.selectByExample(countExample)?.sumOf { it.bettingCount } ?: 0

        if(todayBettingCount >= 10){
            throw Exception("今日已投10注，无法投注")
        }

        if ((todayBettingCount + req.count!!) > 10){
            throw Exception("投注后投注数超过当天限制,请修改投注数量(最多还可以投${10 - todayBettingCount}注)")
        }

        //创建下注信息
        val head = BettingHead()
        head.bettingCount = req.count
        //计算下注总价
        (req.count!! * ConstValue.BettingPrice).also { head.bettingAmount = it.toBigDecimal() }
        head.bettingType = req.type
        head.userId = userId
        //初始状态未支付
        head.state = "0"
        head.bettingTime = Date()

        val result = bettingHeadMapper?.insertOne(head)
        if(result == 0){
            throw Exception("创建投注信息失败")
        }

        //插入明细
        var insertCount = 0
        req.selectedItems?.forEach {
            val details = BettingDetails()
            details.addTime = Date()
            details.bettingValue = it
            details.userId = userId
            details.headId = head.id

            if(bettingDetailsMapper?.insertOne(details)!! > 0){
                insertCount++
            }
        }

        if(req.selectedItems?.size == insertCount){
            throw Exception("创建投注详情失败")
        }

        val bettingPay = BettingPay()
        bettingPay.bettingId = head.id
        bettingPay.createTime = Date()

        return DataWrap.success(null)
    }

    /**
     * 下注历史记录
     */
    fun history() : List<BettingHead>{
        return LinkedList()
    }
}
