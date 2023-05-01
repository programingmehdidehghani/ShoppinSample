package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
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
        val total = bundle!!.getString("total")
        val cardNumber = bundle!!.getString("cardNumber")
        binding.txtPriceAmountInPaymentDialog.text = total
        binding.txtContentCardNumberInPaymentDialog.text = cardNumber
    }

    override fun onStop() {
        super.onStop()
        this.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.dismiss()
    }
}