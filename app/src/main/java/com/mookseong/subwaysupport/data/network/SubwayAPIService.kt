package com.mookseong.subwaysupport.data.network

import com.mookseong.subwaysupport.data.entity.SubwayReq
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SubwayAPIService {
    @GET("subwayPath")
    suspend fun getSubwayRouterSearch(
        @Query("lang") lang: Int,
        @Query("CID") CID: Int,
        @Query("SID") SID: Int,
        @Query("EID") EID: Int,
        @Query("Sopt") Sopt: Int,
        @Query("apiKey") apiKey: String,
    ) : Response<SubwayReq>

}