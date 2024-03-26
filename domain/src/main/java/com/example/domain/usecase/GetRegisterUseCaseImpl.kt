package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.model.UserModel
import com.example.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRegisterUseCaseImpl @Inject constructor(private val registerRepository: RegisterRepository) :
    GetRegisterUseCase {
    override suspend fun register(userModel: UserModel): Resource<Boolean> {
        return registerRepository.register(userModel)
    }
}
