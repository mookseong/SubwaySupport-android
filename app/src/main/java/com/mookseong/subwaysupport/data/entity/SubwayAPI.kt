package com.mookseong.subwaysupport.data.entity

import com.mookseong.subwaysupport.data.entity.subway.ChangeInfoSet
import com.mookseong.subwaysupport.data.entity.subway.DriveInfoSet
import com.mookseong.subwaysupport.data.entity.subway.StationSet

data class SubwayAPI(
    val globalStartName: String,
    val globalEndName: String,
    val globalTravelTime: Int,
    val globalDistance: Double,
    val globalStationCount: Int,
    val fare: Int,
    val cashFare: Int,
    val driveInfoSet: DriveInfoSet,
    val exChangeInfoSet: ChangeInfoSet,
    val stationSet: StationSet
)
