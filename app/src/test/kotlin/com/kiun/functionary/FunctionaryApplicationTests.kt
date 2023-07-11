package com.kiun.functionary

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.security.SecureRandom

@SpringBootTest
class FunctionaryApplicationTests {

    @Test
    fun contextLoads() {

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
}
