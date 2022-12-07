package com.mookseong.subwaysupport.ui.startUp

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.FragmentTransaction
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.databinding.FragmentPregnantBinding
import com.mookseong.subwaysupport.ui.base.BaseFragment
import com.mookseong.subwaysupport.ui.main.MainFragment

class PregnantFragment : BaseFragment<FragmentPregnantBinding, PregnantViewModel>(R.layout.fragment_pregnant) {

    companion object {
        fun newInstance() = PregnantFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[PregnantViewModel::class.java]
    }

    override fun initListener() {
        super.initListener()
        binding.buttonYes2.setOnClickListener {
            nextFragment("pregnant", true)
        }
        binding.buttonNo2.setOnClickListener {
            nextFragment("pregnant", false)
        }
    }
    private fun nextFragment(key: String, value : Boolean){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref!!.edit()) {
            putBoolean(key, value)
            putBoolean("setup", true)
            apply()
        }
        parentFragmentManager.beginTransaction().replace(R.id.container, MainFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null)
            .commit()
    }
}