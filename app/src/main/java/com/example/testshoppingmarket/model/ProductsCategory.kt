package com.example.testshoppingmarket.model

class ProductsCategory : ArrayList<ProductsCategory.ProductsCategoryItem>(){
    data class ProductsCategoryItem(
        val id: Int,
        val title: String,
        val price: Double,
        val description: String,
        val category: String,
        val image: String,
        val rating: Rating
    ) {
        data class Rating(
            val rate: Double,
            val count: Int
        )
    }
}