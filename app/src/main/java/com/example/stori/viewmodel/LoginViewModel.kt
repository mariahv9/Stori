package com.example.stori.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.domain.usecase.GetLoginUseCase
import com.example.stori.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase
) : ViewModel() {
    private val _loginState = MutableStateFlow(UserState())
    var userState = _loginState.asStateFlow()
    var isUserName by mutableStateOf(false)
    var isPassword by mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)

    fun setEmailValid(valid: Boolean) {
        isUserName = valid
    }

    fun setPasswordValid(valid: Boolean) {
        isPassword = valid
    }

    fun signIn(onNavigate: () -> Unit, email: String, password: String) {
        viewModelScope.launch {
            when (val result = getLoginUseCase.login(email, password)) {
                is Resource.Success -> {
                    errorMessage.value = null
                    getLoginUseCase.isLogged().apply {
                        Resource.Success {
                            _loginState.update { it }
                        }
                    }
                    onNavigate()
                }

                is Resource.Failure -> {
                    errorMessage.value = result.exception.message
                }

                is Resource.Loading -> TODO()
            }
        }
    }
}
