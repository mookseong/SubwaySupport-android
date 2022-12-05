package com.mookseong.subwaysupport.data.entity.subway

data class Stations(
    val startID : Int,
    val startName : String,
    val endSID : Int,
    val endName : String,
    val travelTime : Int
)
