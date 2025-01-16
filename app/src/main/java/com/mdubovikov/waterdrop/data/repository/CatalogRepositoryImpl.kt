package com.mdubovikov.waterdrop.data.repository

import com.mdubovikov.waterdrop.common.Categories
import com.mdubovikov.waterdrop.data.api.ApiService
import com.mdubovikov.waterdrop.data.extensions.toListModel
import com.mdubovikov.waterdrop.domain.model.Goods
import com.mdubovikov.waterdrop.domain.repository.CatalogRepository
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CatalogRepository {

    override suspend fun getGoods(category: Categories): List<Goods> {
        val categoryList = apiService.getGoods().categories
        val selectedCategory = categoryList.find {
            it.name == when (category) {
                Categories.WATER -> "Вода"
                Categories.COOLERS -> "Кулеры"
                Categories.CUSTOMERS_CHOICE -> "Выбор покупателей"
            }
        }

        return selectedCategory?.goods?.toListModel()
            ?: throw IllegalArgumentException("Unknown category")
    }
}