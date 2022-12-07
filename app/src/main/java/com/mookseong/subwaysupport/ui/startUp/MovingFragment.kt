package com.mookseong.subwaysupport.ui.startUp

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.FragmentTransaction
import com.mookseong.subwaysupport.R
import com.mookseong.subwaysupport.databinding.FragmentMovingBinding
import com.mookseong.subwaysupport.ui.base.BaseFragment

class MovingFragment : BaseFragment<FragmentMovingBinding, MovingViewModel >(R.layout.fragment_moving) {

    companion object {
        fun newInstance() = MovingFragment()
    }

    override fun init() {
        super.init()
        viewModel = ViewModelProvider(this)[MovingViewModel::class.java]
    }

    override fun initListener() {
        super.initListener()
        binding.button.setOnClickListener {
            nextFragment("escalator")
        }
        binding.button2.setOnClickListener {
            nextFragment("elevator")
        }
    }

    private fun nextFragment(key : String){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref!!.edit()) {
            putBoolean(key, true)
            apply()
        }
        parentFragmentManager.beginTransaction().replace(R.id.container, PregnantFragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null)
            .commit()
    }

}