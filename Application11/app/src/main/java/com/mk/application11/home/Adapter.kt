package com.mk.application11.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mk.application11.database.DatabaseAnime
import com.mk.application11.databinding.ListItemLayoutBinding
import com.mk.application11.network.Anime

class Adapter:ListAdapter<DatabaseAnime, Adapter.ItemViewHolder>(DiffUtilItemCallBack()) {


    class ItemViewHolder(val binding:ListItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: DatabaseAnime){
            binding.anime = anime
        }
        companion object{
            fun from(parent:ViewGroup): ItemViewHolder
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
class DiffUtilItemCallBack:DiffUtil.ItemCallback<DatabaseAnime>(){
    override fun areItemsTheSame(oldItem: DatabaseAnime, newItem: DatabaseAnime): Boolean {
        return oldItem.animeId == newItem.animeId
    }

    override fun areContentsTheSame(oldItem: DatabaseAnime, newItem: DatabaseAnime): Boolean {
        return oldItem == newItem
    }

}