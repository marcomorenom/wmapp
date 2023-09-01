package com.example.supermart.domain.dtos

import com.example.supermart.domain.entities.ProductEntity
import com.google.gson.annotations.SerializedName

data class ProductResponseDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val products: List<ProductEntity>,
)

