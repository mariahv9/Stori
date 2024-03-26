package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface GetRegisterUseCase {
    suspend fun register(userModel: UserModel): Resource<Boolean>
}
