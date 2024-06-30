package com.kiun.functionary.web.controller

import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.gks.entity.pay.ChooseWXPay
import com.kiun.functionary.dao.lz.entity.BettingCreate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/lz/betting-order")
@RestController
class BettingOrderController {

    /**
     * 下注订单创建
     */
    @RequestMapping("create")
    fun create(req: BettingCreate) : DataWrap<ChooseWXPay> {
        return DataWrap.success(null)
    }

    /**
     * 下注历史记录
     */
    @RequestMapping("history")
    fun history(){

    }
}
