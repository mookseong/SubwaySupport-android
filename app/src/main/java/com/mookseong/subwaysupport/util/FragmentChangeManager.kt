package com.mookseong.subwaysupport.util

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mookseong.subwaysupport.R


class FragmentChangeManager(
    private val fragment: Fragment,
    private val fragmentManager: FragmentManager
) {

    private fun setFragment() {
        fragmentManager.beginTransaction().replace(R.id.container, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit()

    }

//    fun setInfoFragment(data: ProductListModel) {
//        val bundle = Bundle()
//        bundle.putLong("SEQ", data.productSeq)
//        fragment.arguments = bundle
//        setFragment()
//    }
//
//    fun setInfoFragment(data: SearchList) {
//        val bundle = Bundle()
//        bundle.putLong("SEQ", data.productSeq)
//        fragment.arguments = bundle
//        setFragment()
//    }

    fun setInfoFragment(data: String) {
        val bundle = Bundle()
        bundle.putString("title", data)
        fragment.arguments = bundle
        setFragment()
    }

    fun setInfoFragment() = setFragment()


}