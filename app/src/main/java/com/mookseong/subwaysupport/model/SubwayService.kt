package com.mookseong.subwaysupport.model

import com.mookseong.subwaysupport.data.network.SubwayAPIService

object SubwayService {
    private const val AIP_URL = "https://api.odsay.com/v1/api/"

    val client = BaseService().getSubway(AIP_URL)?.create(SubwayAPIService::class.java)
}

