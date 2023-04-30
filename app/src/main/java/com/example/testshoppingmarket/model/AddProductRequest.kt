package com.example.testshoppingmarket.model

import com.google.gson.annotations.SerializedName

data class AddProductRequest(
    @SerializedName("title")
    var title: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("category")
    var category: String
)
