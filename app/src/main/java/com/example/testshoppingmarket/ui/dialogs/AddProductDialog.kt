package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.testshoppingmarket.databinding.LayoutDialogAddProductBinding
import com.example.testshoppingmarket.utils.ImageLoader

class AddProductDialog: DialogFragment() {

    private lateinit var binding: LayoutDialogAddProductBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutDialogAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = 700
        params.height = 1000
        ImageLoader.loadImage(binding.ivImageDialogAddProduct,"https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg")
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