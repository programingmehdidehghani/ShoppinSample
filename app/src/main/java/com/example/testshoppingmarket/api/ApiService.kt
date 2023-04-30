package com.example.testshoppingmarket.api

import com.example.testshoppingmarket.model.AddProductResponse
import com.example.testshoppingmarket.model.AddProductRequest
import com.example.testshoppingmarket.model.CategoriesHeader
import com.example.testshoppingmarket.model.ProductDetail
import com.example.testshoppingmarket.model.LoginRequest
import com.example.testshoppingmarket.model.LoginResponse
import com.example.testshoppingmarket.model.ProductsCategory
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("auth/login")
    suspend fun loginResponse(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("products/categories")
    suspend fun gerCategories(): Response<CategoriesHeader>

    @GET("products/category/{category}")
    suspend fun gerProductCategory(@Path("category") category: String): Response<ProductsCategory>

    @GET("products/{productId}")
    suspend fun getDetailProduct(@Path("productId") productId: String): Response<ProductDetail>

    @GET("products")
    suspend fun getSortingProduct(@Query("sort") sort: String): Response<ProductsCategory>

    @POST("products")
    suspend fun addProduct(@Body addProfile: AddProductRequest): Response<AddProductResponse>

}
