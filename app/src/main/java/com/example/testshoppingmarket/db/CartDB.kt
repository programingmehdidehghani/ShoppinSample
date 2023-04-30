package com.example.testshoppingmarket.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CartModel::class],
    version = 1
)
abstract class CartDB : RoomDatabase() {

    abstract fun getDAO() : CartDAO

}