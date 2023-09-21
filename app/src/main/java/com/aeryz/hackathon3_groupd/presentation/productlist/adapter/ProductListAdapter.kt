package com.aeryz.hackathon3_groupd.presentation.productlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aeryz.hackathon3_groupd.R
import com.aeryz.hackathon3_groupd.databinding.ProductItemListBinding
import com.aeryz.hackathon3_groupd.model.Product

class ProductListAdapter(private val onItemClick: (Product) -> Unit): RecyclerView.Adapter<ProductListViewHolder>()
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            binding = ProductItemListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

}

class ProductListViewHolder(
    private val binding: ProductItemListBinding,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Product) {
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
        binding.ivImage.load(item.imgUrl)
        binding.tvName.text = item.name
        binding.tvWeight.text = itemView.context.getString(R.string.text_product_weight_format, item.weight)
        binding.tvPrice.text = itemView.context.getString(R.string.text_product_price_format, item.price)
    }
}