package com.example.waterdrop.domain.repository

import com.example.waterdrop.domain.model.Goods

interface CatalogRepository {

    suspend fun getGoods(category: Int): List<Goods>
}