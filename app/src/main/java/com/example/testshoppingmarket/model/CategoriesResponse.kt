package com.example.testshoppingmarket.model

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("electronics")
    var electronics: String,
    @SerializedName("jewelery")
    var jewelery: String,
    @SerializedName("men's clothing\n")
    var menClothing: String,
    @SerializedName("women's clothing\n")
    var womenClothing: String,
)
