package com.mookseong.subwaysupport.ui.main

import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.base.BaseFragment

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun initListener() {
        super.initListener()
    }

    override fun afterViewCreated() {
        super.afterViewCreated()
    }

}