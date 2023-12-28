package com.kiun.functionary.service

import com.kiun.functionary.dao.sys.entity.SysOrgan

interface OrganService {

    fun createOrSearch(organName: String, type: String, region: String?, split: String = "，"): SysOrgan
}
