package com.mookseong.subwaysupport.ui.startUp

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.FragmentTransaction
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.databinding.FragmentTemperatureBinding
import com.mookseong.subwaysupport.ui.base.BaseFragment

class TemperatureFragment : BaseFragment<FragmentTemperatureBinding,TemperatureViewModel>(R.layout.fragment_temperature) {

    companion object {
        fun newInstance() = TemperatureFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[TemperatureViewModel::class.java]
    }

    override fun initListener() {
        super.initListener()
        binding.buttonYes.setOnClickListener {
            nextFragment("temperature", true)
        }
        binding.buttonNo.setOnClickListener {
            nextFragment("temperature", false)
        }
    }

    private fun nextFragment( key: String, value : Boolean){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putBoolean(key, value)
            apply()
        }
        parentFragmentManager.beginTransaction().replace(R.id.container, MovingFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null)
            .commit()
    }
}