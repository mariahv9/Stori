package com.example.stori.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.common.Resource.Success
import com.example.domain.usecase.GetHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {
    private val _userId = MutableStateFlow<String>("")
    val userId: StateFlow<String> = _userId

    private val _userName = MutableStateFlow<Resource<String>>(Resource.Loading())
    val userName: StateFlow<Resource<String>> = _userName

    private val _userBalance = MutableStateFlow<Resource<Int>>(Resource.Loading())
    val userBalance: StateFlow<Resource<Int>> = _userBalance

    private val _name = MutableStateFlow<Resource<String>>(Resource.Loading())
    val name: StateFlow<Resource<String>> = _name

    init {
        fetchUserId()
        fetchUserBalance(_userId.value)
    }

    private fun fetchUserId() {
        viewModelScope.launch {
            try {
                val result = getHomeUseCase.getUserId()
                _userId.value = result.toString()
            } catch (e: Exception) {
                _userId.value = Resource.Failure(e).toString()
            }
        }
    }

    fun fetchName(id: String) {
        viewModelScope.launch {
            try {
                getHomeUseCase.getUserName(id).collect { nameResult ->
                    _name.value = Resource.Success(nameResult)
                }
            } catch (e: Exception) {
                _name.value = Resource.Failure(e)
            }
        }
    }

    fun fetchUserBalance(userId: String) {
        viewModelScope.launch {
            _userBalance.value = Resource.Loading()
            try {
                val balanceResult = getHomeUseCase.getUserBalance(userId)
                _userBalance.value = Success(balanceResult).data
            } catch (e: Exception) {
                _userBalance.value = Resource.Failure(e)
            }
        }
    }
}
