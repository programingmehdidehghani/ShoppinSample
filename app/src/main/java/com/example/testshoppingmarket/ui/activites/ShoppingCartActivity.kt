package com.example.testshoppingmarket.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutActivityShoppingCartBinding
import com.example.testshoppingmarket.databinding.LayoutMainActivityBinding
import com.example.testshoppingmarket.db.CartModel
import com.example.testshoppingmarket.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private val viewBinding by lazy {
        LayoutActivityShoppingCartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        insetCart()
    }

    fun insetCart(){
        var id = 0
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")
        id++
        val cartModel = CartModel(
            id,
            name.toString(),
            image.toString(),
            price.toString()
        )
        mainViewModel.insertCart(cartModel)
        mainViewModel.getContentCart().observe(this, Observer {

        })
    }
}