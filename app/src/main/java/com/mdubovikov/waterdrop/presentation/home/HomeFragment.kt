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
import com.mdubovikov.waterdrop.WaterDropApp
import com.mdubovikov.waterdrop.common.Result
import com.mdubovikov.waterdrop.common.ViewModelFactory
import com.mdubovikov.waterdrop.databinding.FragmentHomeBinding
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
    private lateinit var goodsAdapter: GoodsAdapter

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as WaterDropApp).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goodsAdapter = GoodsAdapter()
        binding.rvGoods.adapter = goodsAdapter
        loadData()
    }

    private fun loadData() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.goods.collectLatest { goods ->
                    with(binding) {
                        when (goods) {
                            is Result.Pending -> {
//                                progressBar.visibility = View.VISIBLE
//                                rvMeals.visibility = View.GONE
//                                tvMealsNotFound.visibility = View.GONE
//                                tvMealsError.visibility = View.GONE

                            }

                            is Result.Success -> {
                                goodsAdapter.submitList(Result.Success.value)
                            }

                            is Result.Error -> {
//                                tvMealsError.visibility = View.VISIBLE
//                                progressBar.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}