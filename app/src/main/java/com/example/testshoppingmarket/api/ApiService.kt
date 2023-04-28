package com.example.testshoppingmarket.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("")
    suspend fun loginRequest(@Field): Response<Response>
}