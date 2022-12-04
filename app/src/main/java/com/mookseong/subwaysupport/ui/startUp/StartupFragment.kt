package com.mookseong.subwaysupport.ui.startUp

import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentStartupBinding

class StartupFragment : BaseFragment<FragmentStartupBinding, StartupViewModel>(R.layout.fragment_startup) {

    companion object {
        fun newInstance() = StartupFragment()
    }

    override fun initView() {
        super.initView()
        viewModel = ViewModelProvider(this)[StartupViewModel::class.java]
    }
}