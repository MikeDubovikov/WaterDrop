package com.example.waterdrop.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoodsDto(
    @SerialName("ID") val id: Long,
    @SerialName("DETAIL_PICTURE") val image: String,
    @SerialName("EXTENDED_PRICE") val price: List<PriceDto>
)