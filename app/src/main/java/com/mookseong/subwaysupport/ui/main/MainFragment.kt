package com.mookseong.subwaysupport.ui.main

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.data.local.SubwayFragmentData
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.databinding.FragmentMainBinding
import com.mookseong.subwaysupport.ui.subway.SubwayFragment
import com.mookseong.subwaysupport.ui.subway.SubwayRecycler
import com.opencsv.CSVReader
import java.io.InputStreamReader

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
            val bundle = Bundle()
            val fragment = SubwayFragment()
            CSVReader(InputStreamReader(requireContext().assets.open("ODSay.csv"))).readAll().map {
                if (it.toList()[1].contains(binding.searchId.text.toString())) {
                    println(it.toList()[0].toInt())
                    bundle.putInt("start", it.toList()[0].toInt())
                }
            }
            CSVReader(InputStreamReader(requireContext().assets.open("ODSay.csv"))).readAll().map {
                if (it.toList()[1].contains(binding.endLineId.text.toString())) {
                    println(it.toList()[0].toInt())
                    bundle.putInt("end", it.toList()[0].toInt())
                }
            }
            fragment.arguments = bundle
            parentFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null)
                .commit()
        }
    }
}