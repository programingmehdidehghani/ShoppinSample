package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.AddProductResponse
import com.example.testshoppingmarket.model.AddProductRequest
import retrofit2.Response
import javax.inject.Inject

class AddProductRepository @Inject constructor(
    private val apiService: ApiService
){

    suspend fun addProduct (addProduct: AddProductRequest) : Response<AddProductResponse>{
        return apiService.addProduct(addProduct)
    }
}