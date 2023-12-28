package com.kiun.functionary.web.controller

import com.google.gson.Gson
import com.kiun.functionary.base.DataWrap
import com.kiun.functionary.dao.sys.SysUserMapper
import com.kiun.functionary.fegin.wx.WxOpenService
import com.kiun.functionary.fegin.wx.entry.AccessToken
import com.kiun.functionary.fegin.wx.entry.MiniAppLoginResponse
import com.kiun.functionary.fegin.wx.entry.PhoneInfoResponse
import com.kiun.functionary.fegin.wx.entry.PhoneRequest
import com.kiun.functionary.service.utils.toJson
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WxController {

    @Autowired
    var wxOpenService: WxOpenService? = null

    @Autowired
    var sysUserMapper: SysUserMapper? = null

    @Resource(name = "officialService")
    var officialService: WxOpenService? = null

    /**
     * 检测微信是否注册过
     */
    @GetMapping("api/wx/wxIsRegister")
    fun wxOpenid(@RequestParam("code") code: String): DataWrap<Boolean> {
        val data = wxOpenService?.jscode2session(code)
        val response = Gson().fromJson(data, MiniAppLoginResponse::class.java)
        return DataWrap.success(sysUserMapper?.selectBySalt(response.openid)?.isNotEmpty() == true)
    }

    @GetMapping("api/wx/getTicket")
    fun getTicket(): DataWrap<String> {

        val result = officialService?.getTicket()
        if (result?.errcode == 0){
            return DataWrap.success(result?.ticket)
        }
        return DataWrap.fail(result?.errmsg)
    }

    @GetMapping("/1D7N5m7ggN.txt")
    fun verity1(): String{
        return "88b4d7545b2abf8101cfd124f8f19b76"
    }

    @GetMapping("/MP_verify_qRCE1kavkXN7hW4i.txt")
    fun verity2(): String{
        return "qRCE1kavkXN7hW4i"
    }

    @GetMapping("/app/MP_verify_qRCE1kavkXN7hW4i.txt")
    fun verity3(): String{
        return "qRCE1kavkXN7hW4i"
    }
}
