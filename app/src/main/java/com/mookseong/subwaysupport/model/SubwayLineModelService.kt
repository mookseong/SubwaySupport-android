package com.mookseong.subwaysupport.model

import com.mookseong.subwaysupport.data.entity.SubwayAPI
import com.mookseong.subwaysupport.data.entity.subway.ChangeInfo
import com.mookseong.subwaysupport.data.entity.subway.DriveInfo
import com.mookseong.subwaysupport.data.entity.subway.Stations
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.data.local.SubwayLineInfo
import com.mookseong.subwaysupport.data.local.SubwayLineType
import com.mookseong.subwaysupport.data.local.SubwayViewType

class SubwayLineModelService {
    fun crystalSubwayLine(subwayAPIData : SubwayAPI): ArrayList<SubWayData> {
        val driveInfo: ArrayList<DriveInfo> = subwayAPIData.driveInfoSet.driveInfo
        val exChangeInfo: ArrayList<ChangeInfo> = subwayAPIData.exChangeInfoSet.exChangeInfo
        val stations: ArrayList<Stations> = subwayAPIData.stationSet.stations

        val lineInfo: ArrayList<SubwayLineInfo> = ArrayList()
        val lineList: ArrayList<SubWayData> = ArrayList()

        driveInfo.map { i ->
            repeat(i.stationCount) {
                lineInfo.add(
                    SubwayLineInfo(
                        getLineColorToLong(
                            i.laneID.toInt()
                        ), i.laneName
                    )
                )
            }
        }
        stations.mapIndexed { index, i ->
            lineList.add(
                SubWayData(
                    i.startName,
                    lineInfo[index].lineColor,
                    when (i.startName) {
                        subwayAPIData.globalStartName -> SubwayViewType.START_LINE
                        in exChangeInfo.map { it.exName } -> SubwayViewType.TRANSFER_LINE
                        else -> SubwayViewType.PASS_LINE
                    },
                    lineInfo[index].lineInfo
                ))
        }
        lineList.add(
            SubWayData(
                subwayAPIData.globalEndName,
                lineInfo[subwayAPIData.globalStationCount - 1].lineColor,
                SubwayViewType.END_LINE,
                lineInfo[subwayAPIData.globalStationCount - 1].lineInfo,
            )
        )
        println(lineInfo[subwayAPIData.globalStationCount - 1].lineInfo)
        return lineList
    }

    private fun getLineColorToLong(index: Int): String = when (index) {
        1 -> SubwayLineType.Line1
        2 -> SubwayLineType.Line2
        3 -> SubwayLineType.Line3
        4 -> SubwayLineType.Line4
        5 -> SubwayLineType.Line5
        6 -> SubwayLineType.Line6
        7 -> SubwayLineType.Line7
        8 -> SubwayLineType.Line8
        9 -> SubwayLineType.Line8
        101 -> SubwayLineType.AirportLine
        104 -> SubwayLineType.GyeonguiJungangLine
        107 -> SubwayLineType.EverLine
        108 -> SubwayLineType.GyeongchunLine
        109 -> SubwayLineType.SinBundangLine
        110 -> SubwayLineType.UijeongbuLine
        116 -> SubwayLineType.SuinseonLine
        else -> SubwayLineType.Line1
    }
}