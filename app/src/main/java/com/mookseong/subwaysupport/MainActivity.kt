package com.mookseong.subwaysupport

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mookseong.subwaysupport.ui.main.MainFragment
import com.mookseong.subwaysupport.ui.startUp.TemperatureFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
            if (!sharedPref.getBoolean("setup", false)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TemperatureFragment.newInstance())
                    .commitNow()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
            }

        }
    }
}