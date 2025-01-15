package com.mdubovikov.waterdrop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mdubovikov.waterdrop.domain.model.Goods

class GoodsItemDiffCallback : DiffUtil.ItemCallback<Goods>() {

    override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem == newItem
    }
}