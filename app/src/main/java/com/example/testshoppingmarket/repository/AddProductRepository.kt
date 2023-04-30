package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.AddProduct
import com.example.testshoppingmarket.model.AddProductRequest
import retrofit2.Response
import javax.inject.Inject

class AddProductRepository @Inject constructor(
    private val apiService: ApiService
){

    suspend fun addProduct (addProduct: AddProductRequest) : Response<AddProduct>{
        return apiService.addProduct(addProduct)
    }
}