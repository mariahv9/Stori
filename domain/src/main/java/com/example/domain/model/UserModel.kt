package com.example.domain.model

import com.example.common.Movement

data class UserModel(
    val id: String,
    val email: String,
    val password: String,
    val name: String,
    val surname: String,
    val balance: Int,
    val isLogged: Boolean,
    val movements: List<Movement>
)
