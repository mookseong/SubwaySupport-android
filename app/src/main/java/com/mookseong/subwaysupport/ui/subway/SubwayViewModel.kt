package com.mookseong.subwaysupport.ui.subway

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mookseong.subwaysupport.data.entity.SubwayAPI
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.model.SubwayLineModelService
import com.mookseong.subwaysupport.repository.SubwayRepository
import kotlinx.coroutines.launch

class SubwayViewModel(private val subwayRepository: SubwayRepository) : ViewModel() {
    private val _subwayAPIData = MutableLiveData<ArrayList<SubWayData>>()
    val subwayAPIData: LiveData<ArrayList<SubWayData>> = _subwayAPIData

    fun setSubwayService(
        lang: Int,
        CID: Int,
        SID: Int,
        EID: Int,
        Sopt: Int,
        apiKey: String
    ) {
        viewModelScope.launch {
            subwayRepository.getSubwayRouterSearch(lang, CID, SID, EID, Sopt, apiKey)?.let { response ->
                    if (response.isSuccessful) {
                        _subwayAPIData.value = SubwayLineModelService().crystalSubwayLine(response.body()!!.result)
                    }
                }
        }

    }



}