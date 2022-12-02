package com.mookseong.subwaysupport.ui.subway

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.base.BaseFragment
import com.mookseong.subwaysupport.data.SubWayData
import com.mookseong.subwaysupport.data.SubwayReq
import com.mookseong.subwaysupport.data.SubwayViewType
import com.mookseong.subwaysupport.data.subway.ChangeInfo
import com.mookseong.subwaysupport.data.subway.DriveInfo
import com.mookseong.subwaysupport.data.subway.Stations
import com.mookseong.subwaysupport.databinding.FragmentSubwayBinding
import com.mookseong.subwaysupport.ui.main.SubwayRecycler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubwayFragment : BaseFragment<FragmentSubwayBinding, SubwayViewModel>(R.layout.fragment_subway) {

    private lateinit var subwaySearchViewAdapter : SubwayRecycler

    companion object {
        fun newInstance() = SubwayFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[SubwayViewModel::class.java]
        subwaySearchViewAdapter = SubwayRecycler(arrayListOf())
    }

    override fun initView() {
        super.initView()
        binding.subwaySearchView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false;
            adapter = subwaySearchViewAdapter
        }
    }

    override fun initViewData() {
        super.initViewData()
        viewModel.getStations().observe(this@SubwayFragment, Observer<List<Stations>>{
            it.forEach{ i ->
                subwaySearchViewAdapter.addItem(SubWayData(i.startName, 0, SubwayViewType.PASS_LINE))
            }

        })
    }
}