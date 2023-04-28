package com.example.testshoppingmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.ActivityMainBinding


class LoginActivity : AppCompatActivity() {

    private val viewBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.btnLoginInLoginActivity.setOnClickListener {
            if (viewBinding.etNameInLoginActivity.text.isNotEmpty() && viewBinding.etPassInLoginActivity.text.isNotEmpty()){

            } else {
                Toast.makeText(this@LoginActivity,"userName or pass is empty",Toast.LENGTH_SHORT).show()
            }
        }

    }
}