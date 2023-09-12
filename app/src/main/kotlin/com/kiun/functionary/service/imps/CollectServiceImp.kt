package com.kiun.functionary.service.imps

import com.kiun.functionary.context.AppContext
import com.kiun.functionary.dao.gks.UserCollectMapper
import com.kiun.functionary.dao.gks.entity.CollectCount
import com.kiun.functionary.dao.gks.entity.UserCollectExample
import com.kiun.functionary.service.CollectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollectServiceImp : CollectService {

    @Autowired
    val collectMapper: UserCollectMapper? = null

    override fun count(): CollectCount {

        val userId = AppContext.currentUser()?.id

        val detailsExample = UserCollectExample()
        detailsExample.createCriteria().andUserIdEqualTo(userId).andViewTypeEqualTo("D")

        val noticeExample = UserCollectExample()
        noticeExample.createCriteria().andUserIdEqualTo(userId).andViewTypeEqualTo("N")
        return CollectCount(
            detailsCount = collectMapper?.countByExample(detailsExample) ?: 0,
            noticeCount = collectMapper?.countByExample(noticeExample) ?: 0,
        )
    }
}
