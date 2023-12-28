package com.kiun.functionary

import com.kiun.functionary.dao.gks.entity.NoticeListItem
import com.kiun.functionary.pyspider.ageEntryByGkld
import com.kiun.functionary.pyspider.specialityByGkld
import com.kiun.functionary.service.PySpiderService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.security.SecureRandom

@SpringBootTest
class FunctionaryApplicationTests {

    @Autowired
    private val pySpiderService: PySpiderService? = null

    @Test
    fun contextLoads() {

        val o = "若干".toIntOrNull()
        val s1 = "本科：历史学类（B0601）； 研究生：历史学（A0601）；"
        val s2 = "本科：水利类（B0812）大气科学类（B0706）计算机类（B0809）中国语言文学类（B0501）新闻传播学类（B0503）； 研究生：不限"
        val s3 = "本科：不限； 研究生：不限"
        val s4 = "环境科学与工程（A0830）；法学（A0301）；风景园林学（A0834）；思想政治教育（A030505）；应用化学（A081704）；教育学（A04）；作物学（A0901）"
        val s5 = "专科：学前教育C040102； 本科：不限； 研究生：不限"
        val s6 = "本科：中国语言文学类（B0501），新闻传播学类（B0503）； 研究生：中国语言文学（A0501），新闻传播学（A0503）；"
        val s7 = "不限"
        val s8 = "大气科学类、计算机科学与技术、通信工程"

        println(s8.specialityByGkld())
        println(s6.specialityByGkld())

//        println(s1.specialityByGkld())
//        println(s2.specialityByGkld())
//        println(s3.specialityByGkld())
//        println(s4.specialityByGkld())
//        println(s5.specialityByGkld())
//        println(s6.specialityByGkld())
//        println(s7.specialityByGkld())
    }

    @Test
    fun testAge() {
        val s1 = "50周岁以下（1973年10月8日至2005年10月8日期间出生）"
        val s2 = "18周岁以上，35周岁以下，具有博士学位的放宽至40周岁以下，年龄的计算时间截至2024年8月31日"
        val s3 = "35周岁及以下（年龄计算截止日期为2023年10月20日）"
        val s4 = "35周岁及以下"
        val s5 = "40岁以下（即1982年10月9日之后出生）"
        val s6 = "本科18周岁以上，35周岁以下，具有博士学位的放宽至40周岁以下，年龄的计算时间截至2024年8月31日"
        val s7 = "18-35周岁，计算截止时间为2023年9月30日(1987年9月30日以后出生)"
        s7.ageEntryByGkld()
//        println(s1.ageEntryByGkld())
//        println(s2.ageEntryByGkld())
//        println(s3.ageEntryByGkld())
//        println(s4.ageEntryByGkld())
//        println(s5.ageEntryByGkld())
//        println(s6.ageEntryByGkld())
    }

    @Test
    fun cryptEncoder(){
        val non = BCryptPasswordEncoder()
        val salt1 = BCryptPasswordEncoder(-1, SecureRandom("salt2".toByteArray()))
        val salt2 = BCryptPasswordEncoder(-1, SecureRandom("salt3".toByteArray()))

        val encode1 = non.encode("123456")
        val encode2 = salt1.encode("123456")
        val encode3 = salt2.encode("123456")
        val encode4 = salt2.encode("123456")

        System.out.println(encode1)
        System.out.println(encode2)
        System.out.println(encode3)
        System.out.println(encode4)

        System.out.println(salt1.matches("123456", encode2))
        System.out.println(salt1.matches("123456", encode3))
    }

    @Test
    fun testPySpider(){

        val isOk = pySpiderService?.verifyNotice(NoticeListItem(
            "庐江县民宿监管服务中心2023年公开选调事业单位工作人员公告",
            "http://www.baidu.com",
            "事业1单位",
            "2023-11-1"))

        assert(isOk == 0)
    }
}
