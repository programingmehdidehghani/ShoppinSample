package com.example.testshoppingmarket.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testshoppingmarket.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.LoginResponse
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.hasInternetConnection
import com.example.testshoppingmarket.utils.toast
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val repository: LoginRepository
) : AndroidViewModel(application) {

    private val _loginData = MutableLiveData<Resource<LoginResponse>>()
    fun loginUser() = viewModelScope.launch {

    }

    suspend fun getLogin(userName: String, pass: String) {
        Resource.Loading
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getLogin(userName, pass)
                if (response.isSuccessful) {
                    if (response.body()!!.token.isNotEmpty()) {
                        toast(getApplication(), response.body()!!.token)
                        Resource.Success(response.body()!!.token)
                    }
                } else {
                    Resource.Error(response.message())
                }
            } else {
                Resource.Error("No Internet Connection.!")
                toast(getApplication(), "No Internet Connection.!")
            }
        } catch (e: HttpException){
            when(e){
                is IOException -> {
                    toast(getApplication(), "Exception ${e.message}")
                    Resource.Error(e.message())
                }

            }
        } catch (t: Throwable){
            when(t){
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    Resource.Error(t.message!!)
                }
            }
        }
    }


}
