package com.mdubovikov.waterdrop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mdubovikov.waterdrop.databinding.BrandCardBinding
import com.mdubovikov.waterdrop.domain.model.Brand

class BrandAdapter() : ListAdapter<Brand, BrandItemViewHolder>(BrandItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandItemViewHolder {

        val binding = BrandCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return BrandItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandItemViewHolder, position: Int) {
        val brand = getItem(position)
        holder.bind(brand)
    }
}