package com.example.stori.state

import com.example.common.Movement

data class UserState(
    var id: String = "",
    var email: String = "",
    var password: String = "",
    var name: String = "",
    var surname: String = "",
    var balance: Int = 0,
    val isLogged: Boolean = false,
    val movements: List<Movement> = listOf()
)
