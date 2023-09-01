package com.example.supermart.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.supermart.domain.entities.ProductEntity.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName
import kotlin.random.Random


@Entity(tableName = TABLE_NAME)
data class ProductEntity(
    @SerializedName("url") @PrimaryKey(autoGenerate = false) @ColumnInfo(name = ID_KEY) var id : String = "",
    @SerializedName("name") @ColumnInfo(name = NAME_KEY) val name : String = "{}",
    @SerializedName("cost") @ColumnInfo(name = COST_KEY) val cost : Int = getRandomCost(),
){
    companion object {
        internal const val TABLE_NAME = "product_table"
        internal const val ID_KEY = "product_id"
        internal const val NAME_KEY = "name"
        internal const val COST_KEY = "cost"
    }

}

fun getRandomCost(): Int {
    return Random.nextInt(1, 101)
}
