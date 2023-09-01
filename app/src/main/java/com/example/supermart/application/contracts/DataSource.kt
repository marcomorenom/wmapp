package com.example.supermart.application.contracts

import com.example.supermart.domain.entities.ProductEntity

interface DataSource {
    suspend fun saveProducts(list: List<ProductEntity>) : Boolean
    suspend fun getProducts() : List<ProductEntity>
}