package com.mdubovikov.waterdrop.presentation.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mdubovikov.waterdrop.databinding.ItemCardBinding
import com.mdubovikov.waterdrop.domain.model.Goods

class GoodsItemViewHolder(
    private val binding: ItemCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(goods: Goods) {

        with(binding) {

            Glide.with(ivItem)
                .load(Uri.parse(goods.image))
                .into(ivItem)

            tvPrice.text = goods.price.toString()
        }
    }
}