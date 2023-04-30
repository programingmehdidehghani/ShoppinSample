package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding
import com.example.testshoppingmarket.utils.ImageLoader


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
        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = 700
        params.height = 1000
        window.attributes = params
        val bundle = this.arguments
        var image = bundle!!.getString("image")
        var title = bundle!!.getString("title")
        var description = bundle!!.getString("description")
        var price = bundle!!.getString("price")

        ImageLoader.loadImage(binding.ivImageDetailProduct, image.toString())
        binding.txtDescriptionInDialogDetailProduct.text = description
        binding.txtTitleDialogDetailProduct.text = title
        binding.txtPriceInDetailProduct.text = price
        binding.btnAddToCartInDialogDetailProduct.setOnClickListener {
            this.dismiss()
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.dismiss()
    }



}