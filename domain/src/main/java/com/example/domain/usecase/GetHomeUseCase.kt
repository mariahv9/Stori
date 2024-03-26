package com.example.domain.usecase

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface GetHomeUseCase {
    suspend fun getUserName(userId: String): Flow<String>
    suspend fun getUserBalance(userId: String): Resource<Int>
    suspend fun getUserId(): Resource<String?>
}
