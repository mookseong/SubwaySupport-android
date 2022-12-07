package com.mookseong.subwaysupport.ui.subway.subwayViewHolder

import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.databinding.LayoutEndLineBinding
import com.mookseong.subwaysupport.ui.subway.LineTextRecycler
import com.opencsv.CSVReader
import java.io.InputStreamReader

class EndLineViewHolder(private val binding: LayoutEndLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val lineTextRecycler: LineTextRecycler by lazy {
        LineTextRecycler(arrayListOf())
    }

    fun bindItem(data: SubWayData) = with(binding) {
        endLineRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false;
            adapter = lineTextRecycler
        }

        binding.endLineTitle.text = data.wayName
        binding.endLineCircleTitle.text = "하차"
        binding.endLineView.setBackgroundColor(Color.parseColor(data.wayColor))
        binding.endLineCircle.setBackgroundColor(Color.parseColor(data.wayColor))

    }

}
