package com.example.testshoppingmarket.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CartDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cartModel: CartModel)

    @Query("SELECT * FROM cart")
    fun getContentCart(): LiveData<List<CartModel>>

}