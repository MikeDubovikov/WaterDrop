package com.mdubovikov.waterdrop.data.extensions

import com.mdubovikov.waterdrop.data.dto.GoodsDto
import com.mdubovikov.waterdrop.domain.model.Goods

fun GoodsDto.toModel() = Goods(
    id = id,
    image = image.correctUrlImage(),
    price = price.first().price.correctPrice()
)

fun List<GoodsDto>.toListModel() = map { it.toModel() }

private fun String.correctUrlImage() = "https://szorin.vodovoz.ru/$this"

private fun Int.correctPrice() = "$this ₽"