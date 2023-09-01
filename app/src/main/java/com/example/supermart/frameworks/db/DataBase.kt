package com.example.supermart.frameworks.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.supermart.domain.daos.ProductsDAO
import com.example.supermart.domain.entities.ProductEntity

@Database(
    entities = [
        ProductEntity::class
    ], version = 1
)

abstract class DataBase: RoomDatabase()  {
    abstract fun productsDAO(): ProductsDAO
}

internal const val DATABASE_NAME = "Database"