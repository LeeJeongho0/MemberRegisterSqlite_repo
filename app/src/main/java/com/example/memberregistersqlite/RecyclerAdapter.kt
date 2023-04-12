package com.example.memberregistersqlite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memberregistersqlite.databinding.ItemViewBinding

class RecyclerAdapter(val memberData:MutableList<Member>):RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = memberData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val binding = holder.binding
        binding.tvName.text = memberData.get(position).name
        binding.tvId.text = memberData.get(position).id
        binding.tvEmail.text = memberData.get(position).email
    }

    class Holder(val binding:ItemViewBinding):RecyclerView.ViewHolder(binding.root)

}