package com.example.testshoppingmarket.db

import androidx.room.RoomDatabase

abstract class CartDB : RoomDatabase() {

    abstract fun getDAO() : CartDAO

}