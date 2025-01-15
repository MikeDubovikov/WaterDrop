package com.example.waterdrop.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoodsResponse(
    @SerialName("status") val status: String,
    @SerialName("message") val message: String,
    @SerialName("TOVARY") val categories: List<CategoryDto>
)