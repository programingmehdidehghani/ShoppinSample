package com.example.testshoppingmarket.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutActivityAddProfileBinding
import com.example.testshoppingmarket.databinding.LayoutLoginActivityBinding
import com.example.testshoppingmarket.model.AddProduct
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProfileActivity : AppCompatActivity() {

    private val viewBinding by lazy {
        LayoutActivityAddProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    fun sendAddProduct(){
        val addProduct = AddProduct(
            1,
            viewBinding.etTitleInAddProfile.text,

        )
    }
}