package com.example.testshoppingmarket.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutHomeFragmentBinding
import com.example.testshoppingmarket.databinding.LayoutMainActivityBinding
import com.example.testshoppingmarket.ui.viewModel.HomeFragmentViewModel
import com.example.testshoppingmarket.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private val homeViewModel: HomeFragmentViewModel by viewModels()

    private val viewBinding by lazy {
        LayoutHomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun getCategoriesName(){
        homeViewModel.getCategoriesName()
        homeViewModel.getCategoriesName.observe(this, Observer { response ->
            when(response){
                is Resource.Success ->{

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        })

    }

    fun setUpCategoriesNameRecyclerView(){

    }



}