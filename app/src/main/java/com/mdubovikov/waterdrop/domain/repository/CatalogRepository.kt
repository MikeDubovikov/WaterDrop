package com.mdubovikov.waterdrop.domain.repository

import com.mdubovikov.waterdrop.common.Categories
import com.mdubovikov.waterdrop.domain.model.Goods

interface CatalogRepository {

    suspend fun getGoods(category: Categories): List<Goods>
}