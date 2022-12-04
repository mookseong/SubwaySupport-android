package com.mookseong.subwaysupport.ui.main

import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentMainBinding
import com.mookseong.subwaysupport.ui.subway.SubwayRecycler

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    private lateinit var subwayRecycler: SubwayRecycler

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        subwayRecycler = SubwayRecycler(arrayListOf())
    }
    override fun initView() {
        super.initView()

        binding.subwaySearch.setOnClickListener {

        }

    }
}