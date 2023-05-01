package com.example.testshoppingmarket.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "cart"
)
data class CartModel(
    val name: String,
    val image: String,
    val price: String
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}