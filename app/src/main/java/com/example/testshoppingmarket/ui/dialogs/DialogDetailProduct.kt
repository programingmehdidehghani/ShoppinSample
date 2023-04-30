package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding
import com.example.testshoppingmarket.ui.viewModels.DetailProductViewModel
import com.example.testshoppingmarket.ui.viewModels.HomeFragmentViewModel
import com.example.testshoppingmarket.ui.viewModels.LoginViewModel
import com.example.testshoppingmarket.utils.ImageLoader
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast

@Suppress("UNREACHABLE_CODE")
class DialogDetailProduct : DialogFragment() {

    private lateinit var binding: LayoutDialogDetailProductBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutDialogDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        var image = bundle!!.getString("image")
        var title = bundle!!.getString("title")
        var description = bundle!!.getString("description")
        var price = bundle!!.getString("price")

        ImageLoader.loadImage(binding.ivImageDetailProduct, image.toString())
        binding.txtDescriptionInDialogDetailProduct.text = description
        binding.txtTitleDialogDetailProduct.text = title
        binding.txtPriceInDetailProduct.text = price
    }



}