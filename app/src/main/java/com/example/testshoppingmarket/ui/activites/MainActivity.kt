package com.example.testshoppingmarket.ui.activites

import android.R.menu
import android.os.Bundle
import android.view.Menu
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

    private val mainViewModel: MainViewModel by viewModels()


    private val viewBinding by lazy {
        LayoutMainActivityBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shopNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        viewBinding.bottomNavigationView.setupWithNavController(navController)
        toast(this,"call activity on creat")
        var isFirstRun = false
        isFirstRun = intent.getBooleanExtra("isFirstRun",isFirstRun)
        if (isFirstRun){
            return
        }
        insetCart()
    }


    override fun onResume() {
        super.onResume()


        toast(this,"call activity")
    }

    fun insetCart(){
        mainViewModel.getContentCart().observe(this, Observer {

        })
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val image = intent.getStringExtra("image")
        val cartModel = CartModel(
            name.toString(),
            image.toString(),
            price.toString()
        )
        mainViewModel.insertCart(cartModel)
    }

}