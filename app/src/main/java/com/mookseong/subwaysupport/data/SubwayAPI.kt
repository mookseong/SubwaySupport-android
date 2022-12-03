package com.mookseong.subwaysupport.data

import com.mookseong.subwaysupport.data.subway.ChangeInfoSet
import com.mookseong.subwaysupport.data.subway.DriveInfoSet
import com.mookseong.subwaysupport.data.subway.StationSet

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
