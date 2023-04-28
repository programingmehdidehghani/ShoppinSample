package com.example.testshoppingmarket.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testshoppingmarket.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.LoginRequest
import com.example.testshoppingmarket.model.LoginResponse
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.Resource.Success
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
    val loginData: LiveData<Resource<LoginResponse>> = _loginData
    fun loginUser(loginRequest: LoginRequest) = viewModelScope.launch {
        getLogin(loginRequest)
    }

    private suspend fun getLogin(loginRequest: LoginRequest) {
        _loginData.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getLogin(loginRequest)
                if (response.isSuccessful) {
                    if (response.body()!!.token.isNotEmpty()) {
                        toast(getApplication(), response.body()!!.token)
                        _loginData.postValue(Success(response.body()!!))
                    }
                } else {
                    _loginData.postValue(Resource.Error(response.message()))
                    Resource.Error(response.message())
                }
            } else {
                _loginData.postValue(Resource.Error("No Internet Connection.!"))
                toast(getApplication(), "No Internet Connection.!")
            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _loginData.postValue(Resource.Error(e.message()))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _loginData.postValue(Resource.Error(t.message!!))
                }
            }
        }
    }


}
