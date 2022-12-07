package com.mookseong.subwaysupport.ui.subway.subwayViewHolder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.databinding.LayoutPassLineBinding

class PassLineViewHolder(private val binding: LayoutPassLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(data: SubWayData) {
        binding.passLineTitle.text = data.wayName
        binding.passLineView.setBackgroundColor(Color.parseColor(data.wayColor))
    }
}
