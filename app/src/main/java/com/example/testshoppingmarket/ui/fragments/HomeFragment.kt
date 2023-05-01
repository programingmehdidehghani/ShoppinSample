package com.example.testshoppingmarket.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testshoppingmarket.adapters.CategoriesNameAdapter
import com.example.testshoppingmarket.adapters.OnItemClickCallback
import com.example.testshoppingmarket.adapters.OnItemClickCallbackProductCategory
import com.example.testshoppingmarket.adapters.ProductCategoryAdapter
import com.example.testshoppingmarket.databinding.LayoutHomeFragmentBinding
import com.example.testshoppingmarket.model.CategoriesHeader
import com.example.testshoppingmarket.model.ProductsCategory
import com.example.testshoppingmarket.ui.activites.AddProductActivity
import com.example.testshoppingmarket.ui.dialogs.DialogDetailProduct
import com.example.testshoppingmarket.ui.viewModels.HomeFragmentViewModel
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class HomeFragment : Fragment(), OnItemClickCallback , OnItemClickCallbackProductCategory {


    private val categoriesNameAdapter = CategoriesNameAdapter(this)
    private val productCategoryAdapter = ProductCategoryAdapter(this)

    @OptIn(ExperimentalCoroutinesApi::class)
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var binding: LayoutHomeFragmentBinding
    private var categoriesName: ArrayList<CategoriesHeader> = arrayListOf()
    private var productCategory: ArrayList<ProductsCategory> = arrayListOf()
    private var sortResult: ArrayList<ProductsCategory> = arrayListOf()

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
        binding.btnAddProductInHomeFragment.setOnClickListener {
            val intent = Intent(requireContext(), AddProductActivity::class.java)
            startActivity(intent)
        }
        getCategoriesName()
        setUpCategoriesNameRecyclerView()
        resultSortingAsecending()
        resultSortingDescending()
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

    private fun setUpProductCategoryRecyclerView(){
        var layoutManager
                = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvProductCategoryHomeFragment.apply {
            this.layoutManager = layoutManager
            adapter = productCategoryAdapter
        }
    }

    fun showProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.GONE
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onItemClick(category: String) {
        toast(requireContext(),"click {$category}")
        homeFragmentViewModel.getProductCategoryShow(category)
        getProductCategory()
        setUpProductCategoryRecyclerView()
    }



    @OptIn(ExperimentalCoroutinesApi::class)
    fun getProductCategory(){
        homeFragmentViewModel.getProductCategory.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                    response.data?.let{
                        hideProgress()
                        for (i in it){
                            productCategory.add(it)
                        }
                        productCategoryAdapter.updateList(productCategory)
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

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun resultSortingAsecending(){
        binding.txtAsendingInHomeFragment.setOnClickListener {
            homeFragmentViewModel.getResultSort("asec")
            homeFragmentViewModel.getResultSortLive.observe(viewLifecycleOwner, Observer { response ->
                when(response){
                    is Resource.Success ->{
                        response.data?.let{
                            hideProgress()
                            sortResult.clear()
                            for (i in it){
                                sortResult.add(it)
                            }
                            productCategoryAdapter.updateList(sortResult)
                            setUpProductCategoryRecyclerView()
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
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun resultSortingDescending(){
        binding.txtDesendingInHomeFragment.setOnClickListener {
            homeFragmentViewModel.getResultSort("desc")
            homeFragmentViewModel.getResultSortLive.observe(viewLifecycleOwner, Observer { response ->
                when(response){
                    is Resource.Success ->{
                        response.data?.let{
                            hideProgress()
                            sortResult.clear()
                            for (i in it){
                                sortResult.add(it)
                            }
                            productCategoryAdapter.updateList(sortResult)
                            setUpProductCategoryRecyclerView()
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
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onItemClickDetailProduct(productId: Int) {
        homeFragmentViewModel.getProductDetail(productId)
        homeFragmentViewModel.detailProduct.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        hideProgress()
                        val fm: FragmentManager = requireActivity().supportFragmentManager
                        val dialog = DialogDetailProduct()
                        val bundle = Bundle()
                        bundle.putString("image",it.image)
                        bundle.putString("title",it.title)
                        bundle.putString("description",it.description)
                        bundle.putString("price",it.price.toString())
                        dialog.arguments = bundle
                        dialog.show(fm, "start")
                    }
                }

                is Resource.Error -> {
                    response.errorMessage.let {
                        toast(requireContext(), "error for categories name {${it}")
                        Log.i("category", "error is  .." + it)
                        hideProgress()
                    }
                }

                is Resource.Loading -> {
                    showProgress()
                }
            }
        })



    }


}