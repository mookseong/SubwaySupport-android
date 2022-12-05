package com.mookseong.subwaysupport.repository

import com.mookseong.subwaysupport.service.SubwayService

class SubwayRepository {
    private val apiService = SubwayService.client

    suspend fun getSubwayRouterSearch(
        lang: Int,
        CID: Int,
        SID: Int,
        EID: Int,
        Sopt: Int,
        apiKey: String
    ) =
        apiService?.getSubwayRouterSearch(lang, CID, SID, EID, Sopt, apiKey)
}
