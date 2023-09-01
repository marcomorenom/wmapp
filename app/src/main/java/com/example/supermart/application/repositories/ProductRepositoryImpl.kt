package com.example.supermart.application.repositories

import com.example.supermart.application.contracts.ProductRepository
import com.example.supermart.domain.dtos.ProductResponseDTO
import com.example.supermart.frameworks.network.services.ProductsService
import retrofit2.Retrofit
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val retrofit: Retrofit,
    ) : ProductRepository {

    override suspend fun getProducts(): ProductResponseDTO {
        return retrofit.create(ProductsService::class.java).getProducts()
    }

}