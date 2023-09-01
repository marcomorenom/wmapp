package com.example.supermart.frameworks.network.services

import com.example.supermart.domain.dtos.ProductResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsService {
    @GET("pokemon")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0,
    ): ProductResponseDTO
}