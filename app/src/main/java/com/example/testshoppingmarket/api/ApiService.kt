package com.example.testshoppingmarket.api

import com.example.testshoppingmarket.model.CategoriesResponse
import com.example.testshoppingmarket.model.LoginRequest
import com.example.testshoppingmarket.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun loginResponse(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("products/categories")
    suspend fun gerCategories(): Response<List<CategoriesResponse>>

}
