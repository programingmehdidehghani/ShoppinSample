package com.example.testshoppingmarket.ui.dialogs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding
import com.example.testshoppingmarket.ui.activites.ShoppingCartActivity
import com.example.testshoppingmarket.utils.ImageLoader


@Suppress("UNREACHABLE_CODE")
class DetailProductDialog : DialogFragment() {

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
        params.height = 800
        window.attributes = params
        val bundle = this.arguments
        var image = bundle!!.getString("image")
        var title = bundle!!.getString("title")
        var description = bundle!!.getString("description")
        var price = bundle!!.getString("price")
        var rating = bundle!!.getInt("rating")

        ImageLoader.loadImage(binding.ivImageDetailProduct, image.toString())
        binding.txtDescriptionInDialogDetailProduct.text = description
        binding.txtTitleDialogDetailProduct.text = title
        binding.txtPriceInDetailProduct.text = price
        binding.rbInDetailProduct.rating = rating.toFloat()
        binding.btnAddToCartInDialogDetailProduct.setOnClickListener {
            val intent = Intent(this.requireContext(),ShoppingCartActivity::class.java)
            intent.putExtra("name",binding.txtTitleDialogDetailProduct.text)
            intent.putExtra("image",image.toString())
            intent.putExtra("price",binding.txtPriceInDetailProduct.text)
            startActivity(intent)
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