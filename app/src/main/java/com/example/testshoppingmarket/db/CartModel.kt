package com.example.testshoppingmarket.db

import androidx.room.Entity


@Entity(
    tableName = "cart"
)
data class CartModel(
    val name: String,
    val image: String,
    val price: String
)