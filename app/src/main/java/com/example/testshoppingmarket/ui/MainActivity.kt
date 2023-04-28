package com.example.testshoppingmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.ActivityMain2Binding
import com.example.testshoppingmarket.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main2.bottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.shopNavHostFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bottomNavigationView.setupWithNavController(shopNavHostFragment.findNavController())

    }
}