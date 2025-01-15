package com.mdubovikov.waterdrop.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdubovikov.waterdrop.common.Categories
import com.mdubovikov.waterdrop.common.Result
import com.mdubovikov.waterdrop.domain.usecase.GetGoodsByCategoryUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getGoodsByCategoryUseCase: GetGoodsByCategoryUseCase
) : ViewModel() {

    private val category = MutableStateFlow(Categories.CUSTOMERS_CHOICE)

    @OptIn(ExperimentalCoroutinesApi::class)
    val goods = category
        .flatMapLatest { query ->
            when (query) {
                Categories.CUSTOMERS_CHOICE -> getGoodsByCategoryUseCase.invoke(category = query)
                Categories.WATER -> getGoodsByCategoryUseCase.invoke(category = query)
                Categories.COOLERS -> getGoodsByCategoryUseCase.invoke(category = query)
                else -> throw IllegalStateException("Unknown query state")
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Result.Pending
        )
}