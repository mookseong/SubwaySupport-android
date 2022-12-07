package com.mookseong.subwaysupport.ui.subway.subwayViewHolder

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.data.local.SubWayData
import com.mookseong.subwaysupport.databinding.LayoutTransferLineBinding
import com.mookseong.subwaysupport.ui.subway.LineTextRecycler
import com.opencsv.CSVReader
import java.io.InputStreamReader

class TransferLineViewHolder(private val binding: LayoutTransferLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val lineTextRecycler: LineTextRecycler by lazy {
        LineTextRecycler(arrayListOf())
    }

    fun bindItem(data: SubWayData) = with(binding) {

        transferLineRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
            isNestedScrollingEnabled = false;
            adapter = lineTextRecycler
        }
        binding.transferLineTitle.text = data.wayName
        binding.transferLineCircleTitle.text = data.wayInfo
        binding.transferLineView.setBackgroundColor(Color.parseColor(data.wayColor))
        binding.transferLineCircle.setBackgroundColor(Color.parseColor(data.wayColor))

        val arrayList: ArrayList<String> = arrayListOf(
            "interior_elevator.csv"
        )
        arrayList.map {
            val readerCSV = CSVReader(InputStreamReader(itemView.context.assets.open(it)))
            val preferences =
                itemView.context.getSharedPreferences("MainActivity", Context.MODE_PRIVATE)
            readerCSV.readAll().map { i ->
                if (i.toList()[1].contains(data.wayName) && i.toList()[4].contains(data.wayDirection)) {
                    if (preferences.getBoolean("temperature", false))
                        lineTextRecycler.addItem("약냉방 엘리베이터  : ${i.toList()[6]}")
                    if (preferences.getBoolean("elevator", false))
                        lineTextRecycler.addItem("엘리베이터 : ${i.toList()[4]} ")
                    if (preferences.getBoolean("pregnant", false))
                        lineTextRecycler.addItem("임산부석 엘리베이터  : ${i.toList()[5]}")
                    if (preferences.getBoolean("pregnant", false) && preferences.getBoolean("temperature", false)
                    )
                        lineTextRecycler.addItem("임산부석 약냉방 엘리베이터  : ${i.toList()[7]}")
                }
            }
        }
    }

}

