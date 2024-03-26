package com.example.domain.usecase

import com.example.common.Resource
import com.example.data.db.entities.MovementEntity
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface GetLoginUseCase {
    suspend fun login(email: String, password: String): Resource<UserModel>
    suspend fun isLogged(): Flow<UserModel>
}
