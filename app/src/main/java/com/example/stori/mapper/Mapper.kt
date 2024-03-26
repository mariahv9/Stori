package com.example.stori.mapper

import com.example.domain.model.UserModel
import com.example.stori.state.UserState

fun UserState.toUserModel() = UserModel(
    id = id,
    email = email,
    password = password,
    name = name,
    surname = surname,
    balance = balance,
    isLogged = isLogged,
    movements = movements
)
