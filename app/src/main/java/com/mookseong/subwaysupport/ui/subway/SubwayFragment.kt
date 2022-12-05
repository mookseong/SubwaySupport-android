package com.mookseong.subwaysupport.ui.subway

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.BuildConfig
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.data.entity.SubwayAPI
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentSubwayBinding
import com.mookseong.subwaysupport.repository.SubwayRepository


class SubwayFragment :
    BaseFragment<FragmentSubwayBinding, SubwayViewModel>(R.layout.fragment_subway) {

    companion object {
        fun newInstance() = SubwayFragment()
    }

    private val subwaySearchViewAdapter: SubwayRecycler by lazy {
        SubwayRecycler(arrayListOf())
    }
    private val repositoryViewModelFactory: RepositoryViewModelFactory by lazy {
        RepositoryViewModelFactory(SubwayRepository())
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this, repositoryViewModelFactory)[SubwayViewModel::class.java]
        viewModel.setSubwayService(0, 1000, 1609, 714, 1, BuildConfig.ODSAY_API_KEY)
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

    @SuppressLint("SetTextI18n")
    override fun initViewData() = with(viewModel) {
        super.initViewData()
        subwayAPIData.observe(this@SubwayFragment, Observer<ArrayList<SubWayData>> { subwayData ->
            subwayData.map { subwaySearchViewAdapter.addItem(it) }
        })
        subwayAPIResult.observe(this@SubwayFragment, Observer<SubwayAPI> {
            binding.subwayFare.text = "카드 ${it.fare}원"
            binding.subwayTravelTime.text =
                (if ((it.globalTravelTime / 60) >= 1) {
                    "${it.globalTravelTime / 60}시 ${it.globalTravelTime % 60}분"
                } else {
                    "${it.globalTravelTime % 60}분"
                }).toString()
            try {
                binding.subwayChangeLine.text = "환승 ${it.exChangeInfoSet.exChangeInfo.size}회"
            }catch (e :java.lang.Exception){
                Log.d("Error", e.toString())
                binding.subwayChangeLine.text = "환승 1회"
            }

        })
    }

}
