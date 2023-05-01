package com.example.testshoppingmarket.ui.activites

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.testshoppingmarket.databinding.LayoutActivityAddProfileBinding
import com.example.testshoppingmarket.model.AddProductRequest
import com.example.testshoppingmarket.ui.dialogs.DialogAddProduct
import com.example.testshoppingmarket.ui.viewModels.AddProductViewModel
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductActivity : AppCompatActivity() {

    private val viewModeProduct: AddProductViewModel by viewModels()


    private val viewBinding by lazy {
        LayoutActivityAddProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        sendAddProduct()
    }

    fun sendAddProduct(){
        viewBinding.btnAddProductInAddProfile.setOnClickListener {
            val addProduct = AddProductRequest(
                viewBinding.etTitleInAddProfile.text.toString(),
                viewBinding.etPriceInAddProfile.text.toString(),
                viewBinding.etDescriptionInAddProfile.text.toString(),
                viewBinding.etImageInAddProfile.text.toString(),
                viewBinding.etCategoryInAddProfile.text.toString()
            )
            viewModeProduct.addProduct(addProduct)
            viewModeProduct.addProduct.observe(this, Observer { response ->
                when(response){
                    is Resource.Success ->{
                        response.data?.let{
                            hideProgress()
                            toast(this,"get categories name {${it}")
                            val fm: FragmentManager = this.supportFragmentManager
                            val dialog = DialogAddProduct()
                            dialog.show(fm,"start")
                        }
                    }
                    is Resource.Error -> {
                        response.errorMessage.let {
                            toast(this,"error for categories name {${it}")
                            Log.i("category","error is  .."+it)
                            hideProgress()
                        }
                    }
                    is Resource.Loading -> {
                        showProgress()
                    }
                }
            })
        }
    }

    fun showProgress() {
        viewBinding.prInAddProductActivity.visibility = View.VISIBLE
    }

    fun hideProgress() {
        viewBinding.prInAddProductActivity.visibility = View.GONE
    }
}