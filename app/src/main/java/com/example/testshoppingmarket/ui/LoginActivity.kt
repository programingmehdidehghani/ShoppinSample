package com.example.testshoppingmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.ActivityMainBinding
import com.example.testshoppingmarket.ui.viewModel.LoginViewModel
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModelLogin: LoginViewModel by viewModels()

    private val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnLoginInLoginActivity.setOnClickListener {
            if (viewBinding.etNameInLoginActivity.text.isNotEmpty() && viewBinding.etPassInLoginActivity.text.isNotEmpty()){

            } else {
                toast(this, "userName or pass is empty")

            }
        }

    }

    fun showProgress(){
        viewBinding.progressLoginActivity.visibility = View.VISIBLE
    }

    fun hideProgress(){
        viewBinding.progressLoginActivity.visibility = View.GONE
    }
}