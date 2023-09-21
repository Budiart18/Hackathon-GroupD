package com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aeryz.hackathon3_groupd.databinding.ItemCategoriesMenuBinding
import com.aeryz.hackathon3_groupd.model.Categories


class AdapterListCategories(): RecyclerView.Adapter<MenuItemCategoriesViewHolder>(){
    private val differ = AsyncListDiffer(this, object : DiffUtil. ItemCallback<Categories>(){
        override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean {
            return oldItem.id == newItem.id
        }
    })

    fun setData(data: List<Categories>) {
        differ.submitList(data)
        notifyItemChanged(0, data.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuItemCategoriesViewHolder {
        return MenuItemCategoriesViewHolder(
            binding = ItemCategoriesMenuBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: MenuItemCategoriesViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }
}


class MenuItemCategoriesViewHolder(
    private val binding: ItemCategoriesMenuBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: Categories) {
        binding.ivIconCategoriesMenu.load(item.imgUrl)
        binding.tvNameMenu.text = item.name
    }
}