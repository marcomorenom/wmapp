package com.example.supermart.domain.usecase

import android.util.Log
import com.example.supermart.application.contracts.BaseUseCase
import com.example.supermart.application.repositories.ProductRepositoryImpl
import com.example.supermart.domain.entities.ProductEntity
import com.example.supermart.domain.enum.LoadStrategy
import com.example.supermart.domain.enum.LoadStrategy.*
import com.example.supermart.frameworks.persistance.DataSourceImpl
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepositoryImpl,
    private val localDataSource: DataSourceImpl,
) : BaseUseCase {

    operator fun invoke(
        loadStrategy: LoadStrategy = Default
    ) = flow {
        val products = when(loadStrategy){
            is Default -> {
                if (getProductsOffline().isEmpty()) {
                    getProductsOnline()
                } else {
                    getProductsOnline()
                }
            }
            is ForceOnline -> {
                getProductsOnline()
            }
        }
        emit(products)
        return@flow
    }

    private suspend fun getProductsOnline(): List<ProductEntity> {
        Log.d(TAG, "getProductsOnline")
        return repository.getProducts().products
    }

    private suspend fun getProductsOffline(): List<ProductEntity> {
        Log.d(TAG, "getProductsOffline")
        return localDataSource.getProducts()
    }
    private companion object {
        private const val TAG = "GetProductsUC"
    }
}