package com.aeryz.hackathon3_groupd.presentation.detailmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.aeryz.hackathon3_groupd.R
import com.aeryz.hackathon3_groupd.databinding.FragmentDetailMenuBinding
import com.aeryz.hackathon3_groupd.model.Product

class DetailMenuFragment : Fragment() {

    companion object{
        const val ARGS_PRODUCT = "ARGS_PRODUCT"
    }

    private val product : Product? by lazy {
        DetailMenuFragmentArgs.fromBundle(arguments as Bundle).product
    }

    private lateinit var binding: FragmentDetailMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProductData()
        buttonBuyNow()
        countTotalPrice()
    }

    private fun countTotalPrice() {
        var totalProduct : Int = 1
        var totalPrice : Double
        val plusButton = binding.ivPlusButton
        val minusButton = binding.ivMinusButton
        val textTotalProduct = binding.tvProductCount
        val textTotalPrice = binding.tvProductPrice
        plusButton.setOnClickListener{
            totalProduct += 1
            totalPrice = (totalProduct * (product?.price?.toInt() ?: 0)).toDouble()
            textTotalProduct.text = totalProduct.toString()
            textTotalPrice.text = getString(R.string.text_product_price_format_idr, totalPrice)
        }
        minusButton.setOnClickListener{
            if (totalProduct <= 1){
                totalProduct = 1
            } else {
                totalProduct -= 1
                totalPrice = (totalProduct * (product?.price?.toInt() ?: 0)).toDouble()
                textTotalProduct.text = totalProduct.toString()
                textTotalPrice.text = getString(R.string.text_product_price_format_idr, totalPrice)
            }
        }
    }

    private fun buttonBuyNow() {
        binding.btnBuyNow.setOnClickListener{
            Toast.makeText(
                requireContext(),
                "Buying ${product?.name} is success",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showProductData() {
        if (product != null){
            binding.ivProductImg.load(product?.imgUrl)
            binding.tvProductName.text = product?.name
            binding.tvProductRating.text = product?.rating.toString()
            binding.tvProductDesc.text = product?.desc
            binding.tvProductShop.text = getString(R.string.text_by_shop, product?.supplierName)
            binding.tvProductPrice.text = getString(R.string.text_product_price_format_idr, product?.price)
        } else {
            Toast.makeText(requireContext(), "Product Detail is Null", Toast.LENGTH_SHORT).show()
        }
    }

}