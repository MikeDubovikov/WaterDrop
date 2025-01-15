package com.example.waterdrop.data.extensions

import com.example.waterdrop.data.dto.GoodsDto
import com.example.waterdrop.domain.model.Goods

fun GoodsDto.toModel() = Goods(
    id = id,
    image = image.correctUrlImage(),
    price = price.first().price
)

fun List<GoodsDto>.toListModel() = map { it.toModel() }

private fun String.correctUrlImage() = "https://szorin.vodovoz.ru/$this"