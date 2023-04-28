package com.example.testshoppingmarket.api

import com.example.testshoppingmarket.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("")
    suspend fun loginRequest(
        @Field("username") username: String, @Field("password") password: String
    ): Response<LoginResponse>

}
