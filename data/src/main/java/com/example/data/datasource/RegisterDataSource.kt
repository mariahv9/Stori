package com.example.data.datasource

import com.example.common.Resource
import com.example.data.db.dao.RegisterDAO
import com.example.data.db.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterDataSource @Inject constructor(private val signUpDAO: RegisterDAO) {
    suspend fun validateRegister(userEntity: UserEntity): Resource<Boolean> =
        try {
            when (withContext(Dispatchers.IO) { signUpDAO.getByEmail(userEntity.email) }) {
                0 -> {
                    signUpDAO.transaction(userEntity)
                    Resource.Success(true)
                }

                else -> {
                    Resource.Success(false)
                }
            }
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }

}
