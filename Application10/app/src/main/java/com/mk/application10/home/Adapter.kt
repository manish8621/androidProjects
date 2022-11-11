package com.mk.application10.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mk.application10.databinding.ListItemLayoutBinding
import com.mk.application10.network.Anime

class Adapter:ListAdapter<Anime,Adapter.ItemViewHolder>(DiffUtilItemCallBack()) {


    class ItemViewHolder(val binding:ListItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime){
            binding.anime = anime
        }
        companion object{
            fun from(parent:ViewGroup):ItemViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view  = ListItemLayoutBinding.inflate(layoutInflater,parent,false)
                return ItemViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
class DiffUtilItemCallBack:DiffUtil.ItemCallback<Anime>(){
    override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem.anime_id == newItem.anime_id
    }

    override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem.anime_id == newItem.anime_id
    }

}