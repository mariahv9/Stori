package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : GetHomeUseCase {
    override suspend fun getUserName(userId: String): Flow<String> {
        return homeRepository.getUserName(userId)
    }

    override suspend fun getUserBalance(userId: String): Resource<Int> {
        return homeRepository.getUserBalance(userId)
    }

    override suspend fun getUserId(): Resource<String?> {
        return homeRepository.getUserId()
    }
}
