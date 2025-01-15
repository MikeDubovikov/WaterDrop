package com.example.waterdrop.domain.repository

import com.example.waterdrop.common.Categories
import com.example.waterdrop.domain.model.Goods

interface CatalogRepository {

    suspend fun getGoods(category: Categories): List<Goods>
}