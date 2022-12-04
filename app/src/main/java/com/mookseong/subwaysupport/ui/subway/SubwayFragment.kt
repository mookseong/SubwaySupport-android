package com.mookseong.subwaysupport.ui.subway

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.BuildConfig
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentSubwayBinding
import com.mookseong.subwaysupport.repository.SubwayRepository


class SubwayFragment :
    BaseFragment<FragmentSubwayBinding, SubwayViewModel>(R.layout.fragment_subway) {

    private lateinit var subwaySearchViewAdapter: SubwayRecycler
    private lateinit var repositoryViewModelFactory: RepositoryViewModelFactory

    companion object {
        fun newInstance() = SubwayFragment()
    }

    override fun init() {
        super.init()
        subwaySearchViewAdapter = SubwayRecycler(arrayListOf())
        repositoryViewModelFactory = RepositoryViewModelFactory(SubwayRepository())
        viewModel = ViewModelProvider(this, repositoryViewModelFactory)[SubwayViewModel::class.java]
        viewModel.setSubwayService(0, 1000, 1622, 714, 1, BuildConfig.ODSAY_API_KEY)
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
        viewModel.subwayAPIData.observe(this@SubwayFragment, Observer<ArrayList<SubWayData>> {
            it.map { i -> subwaySearchViewAdapter.addItem(i) }
        })
    }

}
