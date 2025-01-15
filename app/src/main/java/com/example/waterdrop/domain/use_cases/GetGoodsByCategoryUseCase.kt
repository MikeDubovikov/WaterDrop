package com.example.waterdrop.domain.use_cases

import com.example.waterdrop.common.Result
import com.example.waterdrop.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGoodsByCategoryUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) {
    fun getGoods(category: Int) = flow {
        try {
            emit(Result.Pending)
            val goods = catalogRepository.getGoods(category = category)
            emit(Result.Success(value = goods))
        } catch (e: Exception) {
            emit(Result.Error(exception = e))
        }
    }
}