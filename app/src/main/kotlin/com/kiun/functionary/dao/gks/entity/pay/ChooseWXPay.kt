package com.kiun.functionary.dao.gks.entity.pay

data class ChooseWXPay(

    /**
     * 公众号ID，由商户传入
     */
    var appId: String?,

    /**
     * 时间戳，自1970年以来的秒数
     */
    var timeStamp: String?,

    /**
     * 随机串
     */
    var nonceStr: String?,

    /**
     * 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
     */
    var `package`: String?,

    /**
     * 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
     */
    var signType: String?,

    /**
     * 支付签名
     */
    var paySign: String?
)
