package com.mookseong.subwaysupport.data

import com.mookseong.subwaysupport.data.subway.ChangeInfoSet
import com.mookseong.subwaysupport.data.subway.DriveInfo
import com.mookseong.subwaysupport.data.subway.DriveInfoSet

data class SubwayAPI(
    val globalStartName: String,
    val globalEndName: String,
    val globalTravelTime: Int,
    val globalDistance: Int,
    val globalStationCount: Int,
    val fare: Int,
    val cashFare: Int,
    val driveInfoSet: DriveInfoSet,
    val exChangeInfoSet: ChangeInfoSet,
    val stationSet: ArrayList<DriveInfo>
)
