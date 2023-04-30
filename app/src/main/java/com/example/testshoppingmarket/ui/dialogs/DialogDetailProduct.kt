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
    private lateinit var detailViewModel: DetailProductViewModel
    private val viewModelLogin: DetailProductViewModel by viewModels()


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
      //  detailViewModel = ViewModelProvider(requireActivity()).get(DetailProductViewModel::class.java)
        val bundle = this.arguments
        val productId = bundle!!.getInt("productId")
        getResultDetailProduct(productId)
    }

    fun getResultDetailProduct(productId: Int) {
        viewModelLogin.getProductDetail(productId)
        viewModelLogin.detailProduct.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        hideProgress()
                        ImageLoader.loadImage(binding.ivImageDetailProduct,it.image)
                        binding.txtDescriptionInDialogDetailProduct.text = it.description
                        binding.txtTitleDialogDetailProduct.text = it.title
                        binding.txtPriceInDetailProduct.text = it.price.toString()
                    }
                }

                is Resource.Error -> {
                    response.errorMessage.let {
                        toast(requireContext(), "error for categories name {${it}")
                        Log.i("category", "error is  .." + it)
                        hideProgress()
                    }
                }

                is Resource.Loading -> {
                    showProgress()
                }
            }
        })
    }

    fun showProgress() {
        binding.progressInDetailProduct.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.progressInDetailProduct.visibility = View.GONE
    }

}