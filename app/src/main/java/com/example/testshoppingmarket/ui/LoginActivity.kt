package com.example.testshoppingmarket.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutLoginActivityBinding
import com.example.testshoppingmarket.model.LoginRequest
import com.example.testshoppingmarket.ui.viewModel.LoginViewModel
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModelLogin: LoginViewModel by viewModels()

    private val viewBinding by lazy {
        LayoutLoginActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnLoginInLoginActivity.setOnClickListener {
/*            if (viewBinding.etNameInLoginActivity.text.toString().isNotEmpty() && viewBinding.etPassInLoginActivity.text.toString().isNotEmpty()) {
                val loginRequest = LoginRequest(
                    viewBinding.etNameInLoginActivity.text.toString(),
                    viewBinding.etPassInLoginActivity.text.toString()
                )
                viewModelLogin.loginUser(loginRequest)
                viewModelLogin.loginData.observe(this, Observer { response ->
                    when (response) {
                        is Resource.Success -> {
                            hideProgress()
                            response.data?.let {
                                toast(this,it.token)*/
                                val intent = Intent(this,MainActivity::class.java)
                                startActivity(intent)
     /*                       }
                        }
                        is Resource.Error -> {
                            hideProgress()
                            response.errorMessage.let {
                                toast(this,it)
                            }
                        }
                        is Resource.Loading -> {
                            showProgress()
                        }
                    }
                })
            } else {
                toast(this, "userName or pass is empty")
            }*/
        }

    }

    fun showProgress() {
        viewBinding.progressLoginActivity.visibility = View.VISIBLE
    }

    fun hideProgress() {
        viewBinding.progressLoginActivity.visibility = View.GONE
    }
}