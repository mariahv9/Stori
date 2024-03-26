package com.example.domain.repository

import com.example.common.Resource
import com.example.data.datasource.RegisterDataSource
import com.example.domain.mapper.toUserEntity
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val registerDataSource: RegisterDataSource) :
    RegisterRepository {
    override suspend fun register(userModel: UserModel): Resource<Boolean> {
        return registerDataSource.validateRegister(userModel.toUserEntity())
    }
}
