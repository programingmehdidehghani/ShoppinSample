package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.CategoriesHeader
import com.example.testshoppingmarket.model.ProductsCategory
import retrofit2.Response
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCategoriesName(): Response<CategoriesHeader> {
        return apiService.gerCategories()
    }

    suspend fun getProductCategory(category: String): Response<ProductsCategory> {
        return apiService.gerProductCategory(category)
    }

    suspend fun getSortingResult(sort: String): Response<ProductsCategory> {
        return apiService.getSortingProduct(sort)
    }
}