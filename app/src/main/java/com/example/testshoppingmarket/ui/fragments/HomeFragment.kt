package com.example.testshoppingmarket.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testshoppingmarket.adapters.CategoriesNameAdapter
import com.example.testshoppingmarket.databinding.LayoutHomeFragmentBinding
import com.example.testshoppingmarket.model.CategoriesHeader
import com.example.testshoppingmarket.ui.viewModel.HomeFragmentViewModel
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private val categoriesNameAdapter = CategoriesNameAdapter()
    @OptIn(ExperimentalCoroutinesApi::class)
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var binding: LayoutHomeFragmentBinding
    private var categoriesName: ArrayList<CategoriesHeader> = arrayListOf()

       override fun onCreateView(
           inflater: LayoutInflater,
           container: ViewGroup?,
           savedInstanceState: Bundle?
       ): View? {
           binding = LayoutHomeFragmentBinding.inflate(inflater, container, false)
           return binding.root
       }


    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentViewModel = ViewModelProvider(requireActivity()).get(HomeFragmentViewModel::class.java)
        getCategoriesName()
        setUpCategoriesNameRecyclerView()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getCategoriesName(){
        homeFragmentViewModel.getCategoriesName()
        homeFragmentViewModel.getCategoriesName.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                     response.data?.let{
                         hideProgress()
                         toast(requireContext(),"get categories name {${it}")
                         for (i in it){
                             toast(requireContext(),"fff")
                             categoriesName.add(it)
                         }
                         categoriesNameAdapter.updateList(categoriesName)
                     }
                }
                is Resource.Error -> {
                   response.errorMessage.let {
                       toast(requireContext(),"error for categories name {${it}")
                       Log.i("category","error is  .."+it)
                       hideProgress()
                   }
                }
                is Resource.Loading -> {
                    showProgress()
                }
            }
        })

    }

    private fun setUpCategoriesNameRecyclerView(){
        var layoutManager
                = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategoriesNameInHomeFragment.apply {
            this.layoutManager = layoutManager
            adapter = categoriesNameAdapter
        }
    }

    fun showProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.GONE
    }



}