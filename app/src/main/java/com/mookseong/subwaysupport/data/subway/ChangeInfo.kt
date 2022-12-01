package com.mookseong.subwaysupport.data.subway

data class ChangeInfo(
    val laneName : String,
    val startName : String,
    val exName : String,
    val exSID : Int,
    val fastTrain : Int,
    val fastDoor : Int,
    val exWalkTime : Int
)
