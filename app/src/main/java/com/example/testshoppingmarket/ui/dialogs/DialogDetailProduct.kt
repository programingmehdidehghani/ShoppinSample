package com.example.testshoppingmarket.ui.dialogs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testshoppingmarket.databinding.LayoutDialogDetailProductBinding
import com.example.testshoppingmarket.ui.viewModels.DetailProductViewModel
import com.example.testshoppingmarket.ui.viewModels.HomeFragmentViewModel
import com.example.testshoppingmarket.utils.Resource
import com.example.testshoppingmarket.utils.toast

@Suppress("UNREACHABLE_CODE")
class DialogDetailProduct : DialogFragment() {

    private lateinit var binding: LayoutDialogDetailProductBinding
    private lateinit var detailViewModel: DetailProductViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutDialogDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel =
            ViewModelProvider(requireActivity()).get(DetailProductViewModel::class.java)
        val bundle = this.arguments
        val productId = bundle!!.getInt("productId")
        getResultDetailProduct(productId)
    }

    fun getResultDetailProduct(productId: Int) {
        detailViewModel.getProductDetail(productId)
        detailViewModel.detailProduct.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        hideProgress()
                        sortResult.clear()
                        for (i in it) {
                            sortResult.add(it)
                        }
                        productCategoryAdapter.updateList(sortResult)
                        setUpProductCategoryRecyclerView()
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

    fun showProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.pbCategoryInHomeFragment.visibility = View.GONE
    }

}