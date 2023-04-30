package com.example.testshoppingmarket.ui.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.AddProductResponse
import com.example.testshoppingmarket.model.ProductDetail
import com.example.testshoppingmarket.repository.ProductDetailRepository
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.hasInternetConnection
import com.example.testshoppingmarket.utils.toast
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailProductViewModel @Inject constructor(
    application: Application,
    private val repository: ProductDetailRepository
):AndroidViewModel(application){

    private val _detailProduct = MutableLiveData<Resource<ProductDetail>>()
    val detailProduct: LiveData<Resource<ProductDetail>> = _detailProduct

    fun getProductDetail(productId: Int) = viewModelScope.launch {
         resultDetailProduct(productId)
    }

    suspend fun resultDetailProduct(productId: Int){
        _detailProduct.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getDetailProduct(productId)
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _detailProduct.postValue(Resource.Success(response.body()!!))
                    }
                } else {
                    _detailProduct.postValue(Resource.Error(response.message()))
                    Log.i("category", "error is  .." + response.message())
                    Resource.Error(response.message())
                }
            } else {
                _detailProduct.postValue(Resource.Error("No Internet Connection.!"))
                Log.i("category", "error is  ..")
                toast(getApplication(), "No Internet Connection.!")

            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _detailProduct.postValue(Resource.Error(e.message()))
            Log.i("category", "error is  .." + e.message())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _detailProduct.postValue(Resource.Error(t.message!!))
                    Log.i("category", "error is  .." + t.message)
                }
            }
        }
    }
}