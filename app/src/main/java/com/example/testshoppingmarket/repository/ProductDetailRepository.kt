package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.ProductDetail
import retrofit2.Response
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getDetailProduct(productId: Int): Response<ProductDetail>{
        return apiService.getDetailProduct(productId)
    }
}