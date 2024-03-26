package com.example.domain.repository

import com.example.common.Resource
import com.example.data.datasource.LoginDatasource
import com.example.data.db.entities.MovementEntity
import com.example.domain.mapper.toUserModel
import com.example.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDatasource
) : LoginRepository {
    override suspend fun login(email: String, password: String): Resource<UserModel> {
        return when (val resource = loginDataSource.login(email, password)) {
            is Resource.Success -> {
                val userModel = resource.data.toUserModel()
                Resource.Success(userModel)
            }

            is Resource.Failure -> {
                Resource.Failure(resource.exception)
            }

            is Resource.Loading -> TODO()
        }
    }

    override suspend fun isLogged(): Flow<UserModel> {
        val response = loginDataSource.isLogged()
        response.collect {
            when {
                it.isLogged -> flowOf(response)
                else -> emptyFlow()
            }
        }
        return response.map {
            it.toUserModel()
        }
    }
}
