package com.mdubovikov.waterdrop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mdubovikov.waterdrop.databinding.ItemCardBinding
import com.mdubovikov.waterdrop.domain.model.Goods

class GoodsAdapter(
) : ListAdapter<Goods, GoodsItemViewHolder>(GoodsItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsItemViewHolder {

        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return GoodsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoodsItemViewHolder, position: Int) {
        val meal = getItem(position)
        holder.bind(meal)
    }
}