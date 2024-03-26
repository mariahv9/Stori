package com.example.domain.repository

import com.example.common.Resource
import com.example.data.db.entities.MovementEntity
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(email: String, password: String): Resource<UserModel>
    suspend fun isLogged(): Flow<UserModel>
}
