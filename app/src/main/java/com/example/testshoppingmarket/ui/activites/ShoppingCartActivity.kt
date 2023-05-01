package com.example.testshoppingmarket.ui.activites

import android.content.Intent
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
import com.example.testshoppingmarket.utils.ImageLoader
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

    fun insetCart() {
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")
        val cartModel = CartModel(
            name.toString(),
            image.toString(),
            price.toString()
        )
        mainViewModel.insertCart(cartModel)
        viewBinding.txtTitleProductInShoppingCart.text = name
        viewBinding.txtPriceDbProductInShoppingCart.text = price
        viewBinding.txtTotalCheckProductInShoppingCart.text = price
        viewBinding.txtResultTotalAmountInShoppingCart.text = price
        ImageLoader.loadImage(viewBinding.ivImageProductInShappingCart, image.toString())
        viewBinding.btnCheckOutInShoppingCart.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("total",price)
            startActivity(intent)
        }
    }


}