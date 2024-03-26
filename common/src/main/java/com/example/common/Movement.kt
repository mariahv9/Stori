package com.example.common

import java.util.Date

data class Movement(
    val id: String,
    val movement: String,
    val description: String,
    val date: Date,
    val amount: Double
)
