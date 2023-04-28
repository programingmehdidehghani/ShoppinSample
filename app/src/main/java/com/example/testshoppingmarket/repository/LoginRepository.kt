package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.LoginRequest
import com.example.testshoppingmarket.model.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLogin(loginRequest: LoginRequest): Response<LoginResponse>{
           return apiService.loginResponse(loginRequest)
    }
}