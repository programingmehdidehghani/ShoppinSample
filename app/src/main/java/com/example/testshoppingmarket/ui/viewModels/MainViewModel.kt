package com.example.testshoppingmarket.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.testshoppingmarket.db.CartModel
import com.example.testshoppingmarket.repository.CartInsertRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val cartInsertRepository: CartInsertRepository
): AndroidViewModel(application) {


    fun insertCart(cartModel: CartModel) = viewModelScope.launch {
        cartInsertRepository.insertCart(cartModel)
    }

    fun getContentCart() : LiveData<List<CartModel>>{
       return cartInsertRepository.getContentCart()
    }

}