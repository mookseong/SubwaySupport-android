package com.mookseong.subwaysupport.ui.main

import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}