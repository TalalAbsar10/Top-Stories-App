package com.example.egym.topstories.presentation.top_stories_sections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.egym.databinding.ItemsTopStoriesSectionsBinding
import com.example.egym.topstories.data.data_source.dto.top_stories_details_dto.Result
import javax.inject.Inject

class TopStoriesSectionsAdapter @Inject constructor() : RecyclerView.Adapter<TopStoriesSectionsAdapter.MyViewHolder>() {

    private var listener: ((Result) -> Unit)? = null

    var list = mutableListOf<Result>()

    fun setContentList(list: MutableList<Result>) {
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewHolder: ItemsTopStoriesSectionsBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding =
            ItemsTopStoriesSectionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    fun itemClickListener(l: (Result) -> Unit) {
        listener = l
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewHolder.data = this.list[position]

        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}