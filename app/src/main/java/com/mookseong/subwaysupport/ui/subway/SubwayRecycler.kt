package com.mookseong.subwaysupport.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.data.SubWayData
import com.mookseong.subwaysupport.data.SubwayViewType
import com.mookseong.subwaysupport.databinding.LayoutEndLineBinding
import com.mookseong.subwaysupport.databinding.LayoutPassLineBinding
import com.mookseong.subwaysupport.databinding.LayoutStartLineBinding
import com.mookseong.subwaysupport.databinding.LayoutTransferLineBinding


class SubwayRecycler(private val subWayData: ArrayList<SubWayData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getItemCount() = subWayData.size


    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return subWayData[position].wayType
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(wayData: SubWayData) {
        subWayData.add(wayData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerView.ViewHolder {
        return when (position) {
            SubwayViewType.START_LINE ->
                StartLineViewHolder(
                    LayoutStartLineBinding.inflate(
                        LayoutInflater.from(viewGroup.context), viewGroup, false
                    )
                )
            SubwayViewType.END_LINE ->
                EndLineViewHolder(
                    LayoutEndLineBinding.inflate(
                        LayoutInflater.from(viewGroup.context), viewGroup, false
                    )
                )
            SubwayViewType.PASS_LINE ->
                PassLineViewHolder(
                    LayoutPassLineBinding.inflate(
                        LayoutInflater.from(viewGroup.context), viewGroup, false
                    )
                )
            SubwayViewType.TRANSFER_LINE ->
                TransferLineViewHolder(
                    LayoutTransferLineBinding.inflate(
                        LayoutInflater.from(viewGroup.context), viewGroup, false
                    )
                )
            else ->
                PassLineViewHolder(
                    LayoutPassLineBinding.inflate(
                        LayoutInflater.from(viewGroup.context), viewGroup, false
                    )
                )

        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when {
            (viewHolder is StartLineViewHolder && subWayData[position].wayType == SubwayViewType.START_LINE) ->
                viewHolder.bindItem(subWayData[position])

            (viewHolder is EndLineViewHolder && subWayData[position].wayType == SubwayViewType.END_LINE) ->
                viewHolder.bindItem(subWayData[position])

            (viewHolder is PassLineViewHolder && subWayData[position].wayType == SubwayViewType.PASS_LINE) ->
                viewHolder.bindItem(subWayData[position])

            (viewHolder is TransferLineViewHolder && subWayData[position].wayType == SubwayViewType.TRANSFER_LINE) ->
                viewHolder.bindItem(subWayData[position])

            else -> {
                Log.e(
                    "Error",
                    "Cast cannot be done!!, MatchingType=${subWayData[position].wayType} view=${viewHolder.toString()}, "
                )
            }
        }
    }
}

class StartLineViewHolder(private val binding: LayoutStartLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(data: SubWayData) {
        binding.startLineTitle.text = data.wayName
    }
}

class EndLineViewHolder(private val binding: LayoutEndLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(data: SubWayData) {
        binding.endLineTitle.text = data.wayName
    }
}

class PassLineViewHolder(private val binding: LayoutPassLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(data: SubWayData) {
        binding.passLineTitle.text = data.wayName
    }
}

class TransferLineViewHolder(private val binding: LayoutTransferLineBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindItem(data: SubWayData) {
        binding.startLineTitle.text = data.wayName
    }
}

