package com.example.supermart.application.contracts

import com.example.supermart.domain.dtos.ProductResponseDTO


interface ProductRepository {
    suspend fun getProducts(): ProductResponseDTO
}