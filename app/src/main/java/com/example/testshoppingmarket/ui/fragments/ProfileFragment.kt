package com.example.testshoppingmarket.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testshoppingmarket.R
import com.example.testshoppingmarket.databinding.LayoutHomeFragmentBinding
import com.example.testshoppingmarket.databinding.LayoutProfileFragmentBinding

class ProfileFragment: Fragment() {

    private lateinit var binding: LayoutProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etCategoryInAddProfile.text
    }
}