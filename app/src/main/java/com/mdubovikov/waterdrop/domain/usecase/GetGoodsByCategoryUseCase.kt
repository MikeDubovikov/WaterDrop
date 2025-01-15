package com.mdubovikov.waterdrop.domain.usecase

import com.mdubovikov.waterdrop.common.Categories
import com.mdubovikov.waterdrop.common.Result
import com.mdubovikov.waterdrop.domain.repository.CatalogRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGoodsByCategoryUseCase @Inject constructor(
    private val catalogRepository: CatalogRepository
) {
    operator fun invoke(category: Categories) = flow {
        try {
            emit(Result.Pending)
            val goods = catalogRepository.getGoods(category = category)
            emit(Result.Success(value = goods))
        } catch (e: Exception) {
            emit(Result.Error(exception = e))
        }
    }
}