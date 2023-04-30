package com.example.testshoppingmarket.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.AddProduct
import com.example.testshoppingmarket.model.AddProductRequest
import com.example.testshoppingmarket.repository.AddProductRepository
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.hasInternetConnection
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    application: Application,
    private val repository: AddProductRepository
) : AndroidViewModel(application) {

    private val _addProduct = MutableLiveData<Resource<AddProduct>>()
    val addProduct: LiveData<Resource<AddProduct>> = _addProduct

    fun addProduct(addProduct: AddProductRequest) = viewModelScope.launch {
        addProfileResult(addProduct)
    }

    suspend fun addProfileResult(addProduct: AddProductRequest) {
        _addProduct.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.addProduct(addProduct)
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _addProduct.postValue(Resource.Success(response.body()!!))
                    }
                } else {
                    _addProduct.postValue(Resource.Error(response.message()))
                    Log.i("category", "error is  .." + response.message())
                    Resource.Error(response.message())
                }
            } else {
                _addProduct.postValue(Resource.Error("No Internet Connection.!"))
                Log.i("category", "error is  ..")
                toast(getApplication(), "No Internet Connection.!")

            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _addProduct.postValue(Resource.Error(e.message()))
            Log.i("category", "error is  .." + e.message())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _addProduct.postValue(Resource.Error(t.message!!))
                    Log.i("category", "error is  .." + t.message)
                }
            }
        }
    }


}