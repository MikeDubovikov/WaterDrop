package com.mdubovikov.waterdrop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.mdubovikov.waterdrop.domain.model.Brand

class BrandItemDiffCallback : DiffUtil.ItemCallback<Brand>() {

    override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean {
        return oldItem == newItem
    }
}