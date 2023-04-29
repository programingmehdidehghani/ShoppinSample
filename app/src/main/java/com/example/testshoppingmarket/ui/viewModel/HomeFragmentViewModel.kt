package com.example.testshoppingmarket.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.CategoriesResponse
import com.example.testshoppingmarket.repository.CategoriesRepository
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.hasInternetConnection
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    application: Application,
    private val repository: CategoriesRepository
): AndroidViewModel(application) {

    private val _getCategoriesName = MutableLiveData<Resource<CategoriesResponse>>()
    val getCategoriesName : LiveData<Resource<CategoriesResponse>> = _getCategoriesName

    fun getCategoriesName() = viewModelScope.launch {
        getCategories()
    }

    private suspend fun getCategories(){
        _getCategoriesName.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getCategoriesName()
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _getCategoriesName.postValue(Resource.Success(response.body()!!))
                    }
                } else {
                    _getCategoriesName.postValue(Resource.Error(response.message()))
                    Resource.Error(response.message())
                }
            } else {
                _getCategoriesName.postValue(Resource.Error("No Internet Connection.!"))
                toast(getApplication(), "No Internet Connection.!")
            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _getCategoriesName.postValue(Resource.Error(e.message()))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _getCategoriesName.postValue(Resource.Error(t.message!!))
                }
            }
        }
    }

}