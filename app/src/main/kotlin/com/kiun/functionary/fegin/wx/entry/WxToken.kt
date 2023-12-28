package com.kiun.functionary.fegin.wx.entry

open class WxResponseError {
    /**
     * 错误代码
     */
    var errcode: Int = 0

    /**
     * 消息
     */
    var errmsg: String? = null
}

data class WxTicket(
    var ticket : String? = null
) : WxResponseError()

data class AccessToken(

    /**
     * 获取到的凭证
     */
    var access_token: String? = null,

    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值。
     */
    var expires_in: Int = 0

) : WxResponseError()

/**
 * 小程序登录返回值
 */
data class MiniAppLoginResponse(

    /**
     * 会话密钥
     */
    var session_key: String? = null,

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台账号下会返回，
     * 详见 UnionID 机制说明 https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/union-id.html
     */
    var unionid: String? = null,

    /**
     * openid
     */
    var openid: String? = null
) : WxResponseError()

