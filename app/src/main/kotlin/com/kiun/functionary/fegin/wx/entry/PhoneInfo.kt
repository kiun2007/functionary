package com.kiun.functionary.fegin.wx.entry

data class Watermark(

    /**
     * 用户获取手机号操作的时间戳
     */
    var timestamp: Long? = null,

    /**
     * 小程序appid
     */
    var appid: String? = null
)

/**
 * 手机号验证结果
 */
data class PhoneInfo(

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    var phoneNumber: String? = null,

    /**
     * 没有区号的手机号
     */
    var purePhoneNumber: String? = null,

    /**
     * 区号
     */
    var countryCode: String? = null,

    /**
     * 数据水印
     */
    var watermark: Watermark? = null
)

/**
 * 手机号验证结果
 */
data class PhoneInfoResponse(
    var phone_info: PhoneInfo? = null
) : WxResponseError()
