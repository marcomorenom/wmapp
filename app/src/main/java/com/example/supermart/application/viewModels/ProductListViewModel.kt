package com.example.supermart.application.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.supermart.application.contracts.BaseViewModel
import com.example.supermart.domain.entities.ProductEntity
import com.example.supermart.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val workDispatcher: CoroutineDispatcher,
    ): ViewModel(), BaseViewModel {

    private var _productsState: MutableState<List<ProductEntity>> = mutableStateOf(listOf())
    val productsState get() = _productsState

    fun loadProducts() {
        viewModelScope.launch(workDispatcher) {
            getProductsUseCase().collect {
                _productsState.value = it
            }
        }
    }
}