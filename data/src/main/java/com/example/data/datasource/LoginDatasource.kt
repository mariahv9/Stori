package com.example.data.datasource

import com.example.common.Resource
import com.example.data.db.dao.LoginDAO
import com.example.data.db.entities.MovementEntity
import com.example.data.db.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class LoginDatasource @Inject constructor(private val loginDAO: LoginDAO) {
    suspend fun login(email: String, password: String): Resource<UserEntity> =
        try {
            val user = withContext(Dispatchers.IO) {
                loginDAO.getByEmailAndPassword(email, password)
            }
            if (user != null) {
                Resource.Success(user)
            } else {
                Resource.Failure(Exception("Usuario no encontrado"))
            }
        } catch (exception: Exception) {
            Resource.Failure(exception)
        }


    suspend fun isLogged(): Flow<UserEntity> =
        try {
            flowOf(checkNotNull(withContext(Dispatchers.IO) {
                loginDAO.getUsers()
            }))
        } catch (exception: Exception) {
            flow {
                exception.message
            }
        }
}
