package com.example.testshoppingmarket.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.App
import com.example.testshoppingmarket.model.CategoriesHeader
import com.example.testshoppingmarket.model.ProductsCategory
import com.example.testshoppingmarket.repository.CategoriesRepository
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.hasInternetConnection
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    application: Application,
    private val repository: CategoriesRepository
): AndroidViewModel(application) {

    private val _getCategoriesName = MutableLiveData<Resource<CategoriesHeader>>()
    val getCategoriesName : LiveData<Resource<CategoriesHeader>> = _getCategoriesName

    private val _getProductCategory = MutableLiveData<Resource<ProductsCategory>>()
    val getProductCategory : LiveData<Resource<ProductsCategory>> = _getProductCategory

    private val _getResultSort = MutableLiveData<Resource<ProductsCategory>>()
    val getResultSortLive : LiveData<Resource<ProductsCategory>> = _getResultSort

    fun getCategoriesName() = viewModelScope.launch {
        getCategories()
    }

    fun getProductCategoryShow(category: String) = viewModelScope.launch {
        getProductCategory(category)
    }

    fun getResultSort(sort: String) = viewModelScope.launch {
        getResultSortRequest(sort)
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
                    Log.i("category","error is  .."+response.message())
                    Resource.Error(response.message())
                }
            } else {
                _getCategoriesName.postValue(Resource.Error("No Internet Connection.!"))
                Log.i("category","error is  ..")
                toast(getApplication(), "No Internet Connection.!")

            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _getCategoriesName.postValue(Resource.Error(e.message()))
            Log.i("category","error is  .."+e.message())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _getCategoriesName.postValue(Resource.Error(t.message!!))
                    Log.i("category","error is  .."+t.message)
                }
            }
        }
    }

    private suspend fun getProductCategory(category: String){
        _getProductCategory.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getProductCategory(category)
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _getProductCategory.postValue(Resource.Success(response.body()!!))
                    }
                } else {
                    _getProductCategory.postValue(Resource.Error(response.message()))
                    Log.i("category","error is  .."+response.message())
                    Resource.Error(response.message())
                }
            } else {
                _getProductCategory.postValue(Resource.Error("No Internet Connection.!"))
                Log.i("category","error is  ..")
                toast(getApplication(), "No Internet Connection.!")

            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _getProductCategory.postValue(Resource.Error(e.message()))
            Log.i("category","error is  .."+e.message())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _getProductCategory.postValue(Resource.Error(t.message!!))
                    Log.i("category","error is  .."+t.message)
                }
            }
        }
    }

    private suspend fun getResultSortRequest(sort: String){
        _getResultSort.postValue(Resource.Loading)
        try {
            if (hasInternetConnection<App>()) {
                val response = repository.getSortingResult(sort)
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _getResultSort.postValue(Resource.Success(response.body()!!))
                    }
                } else {
                    _getResultSort.postValue(Resource.Error(response.message()))
                    Log.i("category","error is  .."+response.message())
                    Resource.Error(response.message())
                }
            } else {
                _getResultSort.postValue(Resource.Error("No Internet Connection.!"))
                Log.i("category","error is  ..")
                toast(getApplication(), "No Internet Connection.!")

            }
        } catch (e: HttpException) {
            toast(getApplication(), "Exception ${e.message}")
            _getResultSort.postValue(Resource.Error(e.message()))
            Log.i("category","error is  .."+e.message())
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    toast(getApplication(), "Exception ${t.message}")
                    _getResultSort.postValue(Resource.Error(t.message!!))
                    Log.i("category","error is  .."+t.message)
                }
            }
        }
    }

}