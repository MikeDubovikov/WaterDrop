package com.mdubovikov.waterdrop.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    @SerialName("ID") val id: Int,
    @SerialName("NAME") val name: String,
    @SerialName("data") val goods: List<GoodsDto>
)
