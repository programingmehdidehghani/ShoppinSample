package com.example.testshoppingmarket.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.testshoppingmarket.databinding.LayoutDialogAddProductBinding
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding

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
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
        val bundle = this.arguments
        val title = bundle!!.getString("productId")
    }

}