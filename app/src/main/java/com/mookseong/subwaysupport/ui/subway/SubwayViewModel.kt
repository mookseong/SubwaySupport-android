package com.mookseong.subwaysupport.ui.subway

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mookseong.subwaysupport.data.SubwayReq
import com.mookseong.subwaysupport.data.subway.ChangeInfo
import com.mookseong.subwaysupport.data.subway.DriveInfo
import com.mookseong.subwaysupport.data.subway.Stations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubwayViewModel : ViewModel() {
    private val responseBody: Retrofit =
        Retrofit.Builder().baseUrl("https://api.odsay.com/v1/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    private val _driveInfo  = MutableLiveData<List<DriveInfo>>()
    private val driveInfo: LiveData<List<DriveInfo>> = _driveInfo

    private val _exChangeInfo  = MutableLiveData<List<ChangeInfo>>()
    private val exChangeInfo: LiveData<List<ChangeInfo>> = _exChangeInfo

    private val _stations  = MutableLiveData<List<Stations>>()
    private val stations : LiveData<List<Stations>> = _stations

    init {
        responseBody.create(SubwayAPIService::class.java)
            .getSubwayRouterSearch(
                0,
                1000,
                310,
                714,
                1,
                ""
            )
            .enqueue(object : Callback<SubwayReq> {
                override fun onResponse(
                    call: Call<SubwayReq>,
                    response: Response<SubwayReq>
                ) {
                    if (response.isSuccessful){
                        Log.d("결과", "성공 : ${response.raw()}")
                        _driveInfo.value = response.body()!!.result.driveInfoSet.driveInfo
                        _exChangeInfo.value = response.body()!!.result.exChangeInfoSet.exChangeInfo
                        _stations.value = response.body()!!.result.stationSet.stations
                    }
                }

                override fun onFailure(call: Call<SubwayReq>, t: Throwable) {
                    Log.d("결과:", "실패 : $t")
                    Log.d("결과:", "실패 : ${t.message}")
                }
            })
    }

    fun getDriveInfo() = driveInfo

    fun getChangeInfo() = exChangeInfo

    fun getStations() = stations
}