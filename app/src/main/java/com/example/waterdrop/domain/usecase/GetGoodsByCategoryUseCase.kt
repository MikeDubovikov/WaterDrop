package com.example.waterdrop.domain.usecase

import com.example.waterdrop.common.Categories
import com.example.waterdrop.common.Result
import com.example.waterdrop.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGoodsByCategoryUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) {
    fun getGoods(category: Categories) = flow {
        try {
            emit(Result.Pending)
            val goods = catalogRepository.getGoods(category = category)
            emit(Result.Success(value = goods))
        } catch (e: Exception) {
            emit(Result.Error(exception = e))
        }
    }
}