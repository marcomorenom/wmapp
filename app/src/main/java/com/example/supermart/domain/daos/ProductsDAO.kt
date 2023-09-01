package com.example.supermart.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.supermart.domain.entities.ProductEntity
import com.example.supermart.domain.entities.ProductEntity.Companion.ID_KEY
import com.example.supermart.domain.entities.ProductEntity.Companion.TABLE_NAME

@Dao
interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProducts(products : List<ProductEntity>)

    @Query("SELECT * from $TABLE_NAME")
    suspend fun getProducts() : List<ProductEntity>


    @Query("SELECT * from $TABLE_NAME ORDER BY $ID_KEY ASC LIMIT 10")
    suspend fun getProduct() : ProductEntity
}
