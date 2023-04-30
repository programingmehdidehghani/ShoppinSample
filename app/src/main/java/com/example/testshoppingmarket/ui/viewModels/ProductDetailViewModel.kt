package com.example.testshoppingmarket.ui.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.repository.ProductDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    application: Application,
    private val repository: ProductDetailRepository
) : ViewModel(){

    fun getProduct() = viewModelScope.launch {

    }

    suspend fun getProductDetail(){

    }
}