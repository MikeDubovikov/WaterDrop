package com.mdubovikov.waterdrop.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.mdubovikov.waterdrop.databinding.BrandCardBinding
import com.mdubovikov.waterdrop.domain.model.Brand

class BrandItemViewHolder(
    private val binding: BrandCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(brand: Brand) {

        binding.tvName.text = brand.name
    }
}