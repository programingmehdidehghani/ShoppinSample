package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding
import com.example.testshoppingmarket.databinding.LayoutResultPaymentDialogBinding

class ResultPaymentDialog : DialogFragment() {


    private lateinit var binding: LayoutResultPaymentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutResultPaymentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = 700
        params.height = 1000
        val bundle = this.arguments
        var total = bundle!!.getString("total")
        binding.txtPriceAmountInPaymentDialog.text = total
    }
}