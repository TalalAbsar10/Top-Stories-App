package com.example.egym.topstories.presentation.top_stories_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.egym.databinding.ItemsTopStoriesBinding
import com.example.egym.topstories.domain.model.TopStoriesItems
import javax.inject.Inject

class TopStoriesListAdapter @Inject constructor(val clickListener: ClickListener):
    ListAdapter<TopStoriesItems,TopStoriesListAdapter.ViewHolder>(PostsDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemsTopStoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TopStoriesItems, clickListener: ClickListener) {
            binding.data = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemsTopStoriesBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class PostsDiffCallback : DiffUtil.ItemCallback<TopStoriesItems>() {

    override fun areItemsTheSame(oldItem: TopStoriesItems, newItem: TopStoriesItems): Boolean {
        return oldItem.stories == newItem.stories
    }

    override fun areContentsTheSame(oldItem: TopStoriesItems, newItem: TopStoriesItems): Boolean {
        return oldItem == newItem
    }

}

class ClickListener @Inject constructor() {

    var onItemClick: ((TopStoriesItems) -> Unit)? = null

    fun onClick(data: TopStoriesItems) {
        onItemClick?.invoke(data)
    }
}