package com.example.stori.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.domain.usecase.GetRegisterUseCase
import com.example.stori.mapper.toUserModel
import com.example.stori.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getRegisterUseCase: GetRegisterUseCase
) : ViewModel() {
    var validatedPassword by mutableStateOf(false)
    var isNamed by mutableStateOf(true)
    var isSurNamed by mutableStateOf(true)
    var isEmail by mutableStateOf(true)
    var isPassword by mutableStateOf(true)
    private val _signUpState = MutableStateFlow(UserState())
    val signUpState = _signUpState.asStateFlow()
    var errorMessage by mutableStateOf<String?>(null)
    var isRegistered by mutableStateOf(false)

    private fun isValidPassword(password: String): Boolean {
        return if (password.isNotEmpty()) {
            val uppercase = Regex("[A-Z]").containsMatchIn(password)
            val lowercase = Regex("[a-z]").containsMatchIn(password)
            val number = Regex("\\d").containsMatchIn(password)
            val characters = Regex("[!@#\$%^&*(),.?\":{}|<>]").containsMatchIn(password)
            val length = password.length > 8
            uppercase && lowercase && number && characters && length
        } else {
            false
        }
    }

    fun setEmailValid(valid: Boolean) {
        isEmail = valid
    }

    fun setNameValid(valid: Boolean) {
        isNamed = valid
    }

    fun setSurnameValid(valid: Boolean) {
        isSurNamed = valid
    }

    fun setPasswordValid(valid: Boolean) {
        isPassword = valid
    }

    fun register(onNavigate: () -> Unit) {
        if (validateFields()) {
            viewModelScope.launch {
                try {
                    val userModel = _signUpState.value.copy(
                        id = UUID.randomUUID().toString(),
                    ).toUserModel()

                    val result = getRegisterUseCase.register(userModel)
                    if (result is Resource.Success) {
                        if (result.data) {
                            errorMessage = null
                            onNavigate()
                        } else {
                            errorMessage = "Error durante el registro"
                        }
                    } else if (result is Resource.Failure) {
                        errorMessage = result.exception.message
                    }
                } catch (exception: Exception) {
                    errorMessage = exception.message
                }
            }
        }
    }

    private fun validateFields(): Boolean {
        isNamed = _signUpState.value.name.isNotEmpty()
        isSurNamed = _signUpState.value.surname.isNotEmpty()
        isEmail = _signUpState.value.email.isNotEmpty()
        isPassword = _signUpState.value.password.isNotEmpty()
        validatedPassword = isValidPassword(_signUpState.value.password)
        return if (isNamed && isSurNamed && isEmail && isPassword && validatedPassword) {
            true
        } else {
            errorMessage = "Por favor, completa todos los campos"
            false
        }
    }

}

