package com.example.supermart.domain.usecase

import com.example.supermart.application.contracts.BaseUseCase
import com.example.supermart.application.repositories.ProductRepositoryImpl
import com.example.supermart.frameworks.persistance.DataSourceImpl
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepositoryImpl,
    private val db: DataSourceImpl,
) : BaseUseCase {

    operator fun invoke() = flow {
        val productsResponseDTO = repository.getProducts()
        val products = productsResponseDTO.products
        db.saveProducts(products)
        emit(products)
        return@flow
    }

}