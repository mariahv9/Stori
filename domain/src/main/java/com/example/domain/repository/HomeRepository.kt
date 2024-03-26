package com.example.domain.repository

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getUserName(userId: String): Flow<String>
    suspend fun getUserBalance(userId: String): Resource<Int>
    suspend fun getUserId(): Resource<String?>
}
