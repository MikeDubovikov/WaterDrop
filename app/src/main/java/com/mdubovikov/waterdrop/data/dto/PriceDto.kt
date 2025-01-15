package com.mdubovikov.waterdrop.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PriceDto(
    @SerialName("PRICE") val price: Int
)
