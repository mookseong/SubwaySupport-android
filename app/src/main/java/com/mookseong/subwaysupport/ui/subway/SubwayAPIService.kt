package com.mookseong.subwaysupport.ui.subway

import com.mookseong.subwaysupport.data.SubwayReq
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SubwayAPIService {
    @GET("subwayPath")
    fun getSubwayRouterSearch(
        @Query("lang") lang: Int,
        @Query("CID") CID: Int,
        @Query("SID") SID: Int,
        @Query("EID") EID: Int,
        @Query("Sopt") Sopt: Int,
        @Query("apiKey") apiKey: String,
    ) : Call<SubwayReq>

}