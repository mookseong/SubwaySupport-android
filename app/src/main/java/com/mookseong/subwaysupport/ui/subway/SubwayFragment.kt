package com.mookseong.subwaysupport.ui.subway

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.base.BaseFragment
import com.mookseong.subwaysupport.data.SubWayData
import com.mookseong.subwaysupport.data.SubwayAPI
import com.mookseong.subwaysupport.data.SubwayReq
import com.mookseong.subwaysupport.data.SubwayViewType
import com.mookseong.subwaysupport.data.subway.ChangeInfo
import com.mookseong.subwaysupport.data.subway.DriveInfo
import com.mookseong.subwaysupport.data.subway.Stations
import com.mookseong.subwaysupport.databinding.FragmentSubwayBinding
import com.mookseong.subwaysupport.ui.main.SubwayRecycler
import kotlin.math.log


class SubwayFragment :
    BaseFragment<FragmentSubwayBinding, SubwayViewModel>(R.layout.fragment_subway) {

    private lateinit var subwaySearchViewAdapter: SubwayRecycler

    companion object {
        fun newInstance() = SubwayFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[SubwayViewModel::class.java]
        subwaySearchViewAdapter = SubwayRecycler(arrayListOf())
    }

    override fun initView(): Unit = with(binding) {
        super.initView()
        subwaySearchView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false;
            adapter = subwaySearchViewAdapter
        }
    }

    override fun initViewData() {
        super.initViewData()
        viewModel.getResult().observe(this@SubwayFragment, Observer<SubwayAPI> { it ->
            val driveInfo: ArrayList<DriveInfo> = it.driveInfoSet.driveInfo
            val exChangeInfo: ArrayList<ChangeInfo> = it.exChangeInfoSet.exChangeInfo
            val stations: ArrayList<Stations> = it.stationSet.stations

            val lineList: ArrayList<SubWayData> = ArrayList()
            val lineColor: ArrayList<Long> = ArrayList()

            driveInfo.map {
                for (i in 0.. it.stationCount){
                    lineColor.add(it.laneID.toLong());
                }
            }
            println( lineColor.toString())

            stations.mapIndexed { index, i ->
                lineList.add(
                    SubWayData(
                        i.startName,
                       lineColor[index],
                        when (i.startName) {
                            it.globalStartName -> SubwayViewType.START_LINE
                            in exChangeInfo.map { it.exName } -> SubwayViewType.TRANSFER_LINE
                            else -> SubwayViewType.PASS_LINE
                        }
                    )
                )
            }
            lineList.add(SubWayData(it.globalEndName, 0, SubwayViewType.END_LINE))
            lineList.map { subwaySearchViewAdapter.addItem(it) }
        })
    }

}