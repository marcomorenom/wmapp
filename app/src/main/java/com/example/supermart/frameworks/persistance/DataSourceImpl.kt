package com.example.supermart.frameworks.persistance

import com.example.supermart.application.contracts.DataSource
import com.example.supermart.domain.entities.ProductEntity
import com.example.supermart.frameworks.persistance.db.DataBase
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val dataBase: DataBase
) : DataSource {

    override suspend fun saveProducts(list: List<ProductEntity>): Boolean {
        dataBase.productsDAO().updateProducts(list)
        return true
    }

    override suspend fun getProducts(): List<ProductEntity> {
        return dataBase.productsDAO().getProducts()
    }

}