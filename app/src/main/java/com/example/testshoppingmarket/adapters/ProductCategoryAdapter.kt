package com.example.testshoppingmarket.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testshoppingmarket.databinding.ProductCategoryItemsBinding
import com.example.testshoppingmarket.model.ProductsCategory
import com.example.testshoppingmarket.utils.ImageLoader

interface OnItemClickCallbackProductCategory {
    fun onItemClickDetailProduct(productId: Int)
}

class ProductCategoryAdapter(private val onItemClickCallback: OnItemClickCallbackProductCategory) :
    RecyclerView.Adapter<ProductCategoryAdapter.ProductCategoriesViewHolder>() {

    private val productsCategory: ArrayList<ProductsCategory> = arrayListOf()
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoriesViewHolder {
        val binding =
            ProductCategoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductCategoriesViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun getItemCount(): Int = productsCategory.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<ProductsCategory>) {
        this.productsCategory.clear()
        this.productsCategory.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductCategoriesViewHolder, position: Int) {
        holder.bind(productsCategory[position], onItemClickCallback)
    }

    @Suppress("DEPRECATION")
    inner class ProductCategoriesViewHolder(private val binding: ProductCategoryItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProductsCategory, onItemClickCallback: OnItemClickCallbackProductCategory) {
            binding.txtDescriptionProductCategory.text = model.get(position).description
            ImageLoader.loadImage(
                binding.ivPictureProductInProductCategory,
                model.get(position).image
            )
            binding.txtTitleProductCtegory.text = model.get(position).title
            binding.txtPriceProductCategory.text = model.get(position).price.toString()

            itemView.setOnClickListener {
                onItemClickCallback.onItemClickDetailProduct(
                    model.get(position).id
                )
            }
        }
    }
}