package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.db.CartDB
import com.example.testshoppingmarket.db.CartModel
import javax.inject.Inject

class CartInsertRepository @Inject constructor(
    private val db: CartDB
) {

    suspend fun insertCart(cartModel: CartModel) = db.getDAO().insertCart(cartModel)

    fun getContentCart() = db.getDAO().getContentCart()
}