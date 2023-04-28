package com.example.testshoppingmarket.ui.viewModel

import com.example.testshoppingmarket.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) {
}
