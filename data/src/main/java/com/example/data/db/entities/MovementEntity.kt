package com.example.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "movement")
data class MovementEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String = "",
    val movement: String,
    val description: String,
    val date: Date,
    val amount: Double
)