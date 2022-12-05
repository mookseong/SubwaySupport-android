package com.mookseong.subwaysupport.data.entity.subway

data class DriveInfo(
    val laneID : String,
    val laneName : String,
    val startName : String,
    val stationCount : Int,
    val wayCode : Int,
    val wayName : String
)
