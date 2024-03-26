package com.example.domain.repository

import com.example.common.Resource
import com.example.data.datasource.HomeDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getUserName(userId: String): Flow<String> {
        return homeDataSource.getUserName(userId)
    }

    override suspend fun getUserBalance(userId: String): Resource<Int> {
        return homeDataSource.getUserBalance(userId)
    }

    override suspend fun getUserId(): Resource<String?> {
        return homeDataSource.getUserId()
    }
}
