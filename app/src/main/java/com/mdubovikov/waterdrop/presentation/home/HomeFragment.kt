package com.mdubovikov.waterdrop.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.mdubovikov.waterdrop.R
import com.mdubovikov.waterdrop.WaterDropApp
import com.mdubovikov.waterdrop.common.Categories
import com.mdubovikov.waterdrop.common.Result
import com.mdubovikov.waterdrop.common.ViewModelFactory
import com.mdubovikov.waterdrop.databinding.FragmentHomeBinding
import com.mdubovikov.waterdrop.domain.model.Brand
import com.mdubovikov.waterdrop.domain.model.Goods
import com.mdubovikov.waterdrop.presentation.adapter.BrandAdapter
import com.mdubovikov.waterdrop.presentation.adapter.GoodsAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw IllegalStateException("Fragment $this binding cannot be accessed")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    private val goodsAdapter by lazy { GoodsAdapter(::onItemClick) }
    private val brandsAdapter by lazy { BrandAdapter() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as WaterDropApp).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvGoods.adapter = goodsAdapter
            rvBrands.adapter = brandsAdapter
            tabCustomersChoice.setOnClickListener {
                switchCategory(Categories.CUSTOMERS_CHOICE)
                highlightActiveCategory(Categories.CUSTOMERS_CHOICE)
            }

            tabWater.setOnClickListener {
                switchCategory(Categories.WATER)
                highlightActiveCategory(Categories.WATER)
            }

            tabCoolers.setOnClickListener {
                switchCategory(Categories.COOLERS)
                highlightActiveCategory(Categories.COOLERS)
            }
        }

        highlightActiveCategory(viewModel.selectedCategory.value)
        loadData()
    }

    private fun loadData() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.goods.collectLatest { goods ->
                    with(binding) {
                        when (goods) {
                            is Result.Pending -> {
                                progressBar.visibility = View.VISIBLE
                            }

                            is Result.Success -> {
                                progressBar.visibility = View.GONE
                                rvGoods.visibility = View.VISIBLE
                                goodsAdapter.submitList(goods.value)
                                brandsAdapter.submitList(
                                    listOf(
                                        Brand(1, "Бренд #1"),
                                        Brand(2, "Бренд #2"),
                                        Brand(3, "Бренд #3"),
                                        Brand(4, "Бренд #4"),
                                        Brand(5, "Бренд #5")
                                    )
                                )
                            }

                            is Result.Error -> {
                                progressBar.visibility = View.GONE
                                rvGoods.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

    private fun switchCategory(category: Categories) {
        viewModel.switchCategory(category)
    }

    private fun highlightActiveCategory(category: Categories) {
        with(binding) {
            tvCustomersChoice.setTextColor(requireContext().getColor(R.color.black))
            tvWater.setTextColor(requireContext().getColor(R.color.black))
            tvCoolers.setTextColor(requireContext().getColor(R.color.black))

            when (category) {
                Categories.CUSTOMERS_CHOICE -> {
                    tvCustomersChoice.setTextColor(requireContext().getColor(R.color.light_blue))
                }

                Categories.WATER -> {
                    tvWater.setTextColor(requireContext().getColor(R.color.light_blue))
                }

                Categories.COOLERS -> {
                    tvCoolers.setTextColor(requireContext().getColor(R.color.light_blue))
                }
            }
        }
    }

    private fun onItemClick(goods: Goods) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
            goodsId = goods.id,
            goodsPrice = goods.price,
            goodsImage = goods.image
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}