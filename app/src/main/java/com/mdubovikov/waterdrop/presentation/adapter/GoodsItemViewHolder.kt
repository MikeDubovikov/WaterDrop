package com.mdubovikov.waterdrop.presentation.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mdubovikov.waterdrop.databinding.ItemCardBinding
import com.mdubovikov.waterdrop.domain.model.Goods

class GoodsItemViewHolder(
    private val binding: ItemCardBinding,
    private val onClickItem: ((goods: Goods) -> Unit)?

) : RecyclerView.ViewHolder(binding.root) {

    fun bind(goods: Goods) {

        with(binding) {

            Glide.with(ivItem)
                .load(Uri.parse(goods.image))
                .into(ivItem)
            root.setOnClickListener { onClickItem?.let { item -> item(goods) } }

            tvPrice.text = goods.price
        }
    }
}