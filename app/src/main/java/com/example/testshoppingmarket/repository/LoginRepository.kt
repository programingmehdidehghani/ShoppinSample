package com.example.testshoppingmarket.repository

import com.example.testshoppingmarket.api.ApiService
import com.example.testshoppingmarket.model.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLogin(userName: String , pass: String): Response<LoginResponse>{
           return apiService.loginResponse(userName,pass)
    }
}