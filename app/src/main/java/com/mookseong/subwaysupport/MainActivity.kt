package com.mookseong.subwaysupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mookseong.subwaysupport.ui.main.MainFragment
import com.mookseong.subwaysupport.ui.subway.SubwayFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SubwayFragment.newInstance())
                .commitNow()
        }
    }
}