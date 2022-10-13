package com.mookseong.subwaysupport.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel


abstract class BaseFragment<binding_ : ViewDataBinding, viewModel_ : ViewModel>(@LayoutRes val LayoutID: Int) : Fragment() {

    protected lateinit var binding: binding_
    protected lateinit var viewModel: viewModel_

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, LayoutID, container, false)
        initListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewCreated()
    }

    protected open fun initView() {}
    protected open fun initListener() {}
    protected open fun afterViewCreated() {}

}