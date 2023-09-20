package com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aeryz.hackathon3_groupd.data.ProductDataSource
import com.aeryz.hackathon3_groupd.databinding.FruitItemListBinding
import com.aeryz.hackathon3_groupd.model.Product

class FruitListAdapter(private val onItemClick: (Product) -> Unit): RecyclerView.Adapter<FruitListViewHolder>()
{
    private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem:  Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    })

    fun setData(data: List<Product>) {
        differ.submitList(data)
        notifyItemRangeChanged(0, data.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitListViewHolder {
        return FruitListViewHolder(
            binding = FruitItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: FruitListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

}

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