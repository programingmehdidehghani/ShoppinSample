package com.example.testshoppingmarket.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private val viewBinding by lazy {
        LayoutActivityPaymentBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val allTotal = intent.getStringExtra("total")
        viewBinding.txtTotalAmountInPaymentActivity.text = getString(R.string.txt_all_total_in_payment).format(allTotal)
        viewBinding.btnCheckOutInPaymentActivity.setOnClickListener {

        }
    }
}