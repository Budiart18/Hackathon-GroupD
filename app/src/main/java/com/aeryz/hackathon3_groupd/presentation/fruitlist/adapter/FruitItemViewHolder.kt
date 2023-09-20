package com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aeryz.hackathon3_groupd.databinding.FruitItemListBinding
import com.aeryz.hackathon3_groupd.model.Product

class FruitListViewHolder(
    private val binding: FruitItemListBinding,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
        binding.ivImage.load(item.imgUrl)
        binding.tvName.text = item.name
        binding.tvPrice.text = item.price.toString()
    }
}