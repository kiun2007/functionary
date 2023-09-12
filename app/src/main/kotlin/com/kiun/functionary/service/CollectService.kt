package com.kiun.functionary.service

import com.kiun.functionary.dao.gks.entity.CollectCount
import com.kiun.functionary.dao.gks.entity.UserCollect


interface CollectService {

    fun count() : CollectCount
}
