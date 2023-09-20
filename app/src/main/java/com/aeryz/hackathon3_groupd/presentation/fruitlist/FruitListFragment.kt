package com.aeryz.hackathon3_groupd.presentation.fruitlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.aeryz.hackathon3_groupd.data.ProductDataSourceImpl
import com.aeryz.hackathon3_groupd.databinding.FragmentFruitDetailBinding
import com.aeryz.hackathon3_groupd.databinding.FragmentFruitListBinding
import com.aeryz.hackathon3_groupd.presentation.fruitlist.adapter.FruitListAdapter

class FruitListFragment : Fragment() {
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
        setupGridRecyclerview()
    }

    private fun setupGridRecyclerview() {
        binding.rvFruit.adapter = adapter
        binding.rvFruit.layoutManager = GridLayoutManager(requireContext(), 2 )
        adapter.setData(ProductDataSourceImpl().getFruits())
    }
}