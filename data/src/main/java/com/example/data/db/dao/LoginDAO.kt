package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.db.entities.MovementEntity
import com.example.data.db.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDAO {
    @Query("SELECT * FROM user")
    suspend fun getUsers(): UserEntity?

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getByEmailAndPassword(email: String, password: String): UserEntity?

    @Query("SELECT * FROM user WHERE email = :email")
    fun getByEmail(email: String): UserEntity?
}
