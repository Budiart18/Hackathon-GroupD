package com.aeryz.hackathon3_groupd.presentation.fruitlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aeryz.hackathon3_groupd.R
import com.aeryz.hackathon3_groupd.data.CategoriesDataSource
import com.aeryz.hackathon3_groupd.data.CategoriesDataSourceImpl
import com.aeryz.hackathon3_groupd.data.ProductDataSourceImpl
import com.aeryz.hackathon3_groupd.databinding.FragmentFruitListBinding
import com.aeryz.hackathon3_groupd.model.Categories
import com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter.AdapterListCategories
import com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter.FruitListAdapter

class FruitListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentFruitListBinding
    private val adapter: FruitListAdapter by lazy {
        FruitListAdapter {
            /*navigateToDetailFragment(it)*/
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFruitListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showListCategories()
        setupGridRecyclerview()
    }

    private fun showListCategories() {
        val categoryListAdapter = AdapterListCategories()
        binding.rvCategories.adapter = categoryListAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false )
        val categoriesDataSource: CategoriesDataSource = CategoriesDataSourceImpl()
        val categoriesList: List<Categories> = categoriesDataSource.getCategories()
        categoryListAdapter.setData(categoriesList)
    }

    private fun setupGridRecyclerview() {
        binding.rvFruit.adapter = adapter
        binding.rvFruit.layoutManager = GridLayoutManager(requireContext(), 2 )
        adapter.setData(ProductDataSourceImpl().getFruits())
    }


}