package com.example.testshoppingmarket.ui.activites

import android.R.menu
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutMainActivityBinding
import com.example.testshoppingmarket.db.CartModel
import com.example.testshoppingmarket.ui.viewModels.LoginViewModel
import com.example.testshoppingmarket.ui.viewModels.MainViewModel
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private val viewBinding by lazy {
        LayoutMainActivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shopNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        viewBinding.bottomNavigationView.setupWithNavController(navController)
    }



}