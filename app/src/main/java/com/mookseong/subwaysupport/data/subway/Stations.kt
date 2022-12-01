package com.mookseong.subwaysupport.data.subway

data class Stations(
    val startID : Int,
    val startName : String,
    val endSID : Int,
    val endName : String,
    val travelTime : Int
)
