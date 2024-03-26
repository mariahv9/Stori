package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.model.UserModel
import com.example.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository
) : GetLoginUseCase {
    override suspend fun login(email: String, password: String): Resource<UserModel> {
        return loginRepository.login(email, password)
    }

    override suspend fun isLogged(): Flow<UserModel> {
        return loginRepository.isLogged()
    }
}
