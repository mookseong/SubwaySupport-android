package com.mookseong.subwaysupport.ui.subway

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mookseong.subwaysupport.databinding.LayoutTextBinding

class LineTextRecycler(private val arrayList: ArrayList<String>) :
    RecyclerView.Adapter<TextViewHolder>() {

    override fun getItemCount() = arrayList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(string: String) {
        arrayList.add(string)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: TextViewHolder, p1: Int) =
        p0.bindItem(arrayList[p1])


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TextViewHolder =
        TextViewHolder(LayoutTextBinding.inflate(LayoutInflater.from(p0.context), p0, false))
}

class TextViewHolder(private val binding: LayoutTextBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bindItem(data: String) {
        binding.text.text = data
    }
}