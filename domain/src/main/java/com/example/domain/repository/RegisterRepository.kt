package com.example.domain.repository

import com.example.common.Resource
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun register(userModel: UserModel): Resource<Boolean>
}
